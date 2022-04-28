package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {
    Button notify;
    ImageView btnwhats ;

    RecyclerView recyclerView2;
    String[] s1, s2, s3, numb , title , fee;
    int[] imagess = {R.drawable.alstroemerias, R.drawable.azalea, R.drawable.buttercup, R.drawable.rose
            , R.drawable.chrysanthemum};

    RatingBar rating;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        notify =findViewById(R.id.notify);
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.O){
            NotificationChannel channel =new NotificationChannel("mynt","mynt", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message="this is a notification";
                NotificationCompat.Builder builder=new NotificationCompat.Builder(MainActivity4.this,"mynt" ).setSmallIcon(R.drawable.ic_baseline_message_24).setContentTitle("new notification").setContentText("message").setAutoCancel(true);
                NotificationManagerCompat mangerCompat=NotificationManagerCompat.from(MainActivity4.this);
                mangerCompat.notify(1,builder.build());

                Intent intent=new Intent(MainActivity4.this, NotificationActicity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("message",message);
                PendingIntent pendingIntent=PendingIntent.getActivity(MainActivity4.this,1,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingIntent);

            }
        });



        recyclerView2 = findViewById(R.id.mRecyclerview);


        s1 = getResources().getStringArray(R.array.Flowers);
        s2 = getResources().getStringArray(R.array.Total);
        s3 = getResources().getStringArray(R.array.fee);
        numb = getResources().getStringArray(R.array.number);
        title = getResources().getStringArray(R.array.RecomFlowers);
        fee = getResources().getStringArray(R.array.fee);

        DescriptionAdapter mostSellingAdapter = new DescriptionAdapter(this,title,fee,imagess);
        recyclerView2.setAdapter(mostSellingAdapter);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));


        txt = (TextView) findViewById(R.id.textView2);
        getvalRating();



    }
    public void getvalRating() {
        rating = (RatingBar) findViewById(R.id.ratingBar);

        rating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean b) {
                txt.setText(String.valueOf(rating));

            }
        });
    }

}