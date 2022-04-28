package com.example.finalproject;

import android.app.Notification;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.finalproject.Domain.CategoryDomain;
import com.example.finalproject.Domain.PlantDomain;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String SHARED_PREFERENCES = "SHARED_PREFERENCES";
    //Notification Edit
    ImageView btnwhats ;

    private NotificationManagerCompat NotificationManager;
    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView recyclerViewCategotyList, recyclerViewPopularList;
    EditText ET;
    TextView tv;
    TextView username;
    NavigationView navigationView;
    View headerView;
    TextView usernameHeader;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Notification
        NotificationManager = NotificationManagerCompat.from(this);
        ET = findViewById(R.id.editTextTextPersonName2);
        tv = findViewById(R.id.textView6);
        username = findViewById(R.id.username);
        navigationView=findViewById(R.id.navigation_view);
        headerView = navigationView.getHeaderView(0);
        usernameHeader=headerView.findViewById(R.id.username_header);
//        textView=findViewById(R.id.textView3);
//       // YoYo.with(Techniques.swing).duration(1000).repeat(1).playOn(textView);
//        YoYo.with(Techniques.BounceInRight).duration(1000).repeat(1).playOn(textView);
        recyclerViewCategoty();
        recyclerViewPopular();
        SharedPreferences sharedPreferences = getSharedPreferences(SHARED_PREFERENCES,MODE_PRIVATE);
        String firstName = sharedPreferences.getString("firstName","");
        String lastName = sharedPreferences.getString("lastName","");
        username.setText(firstName + " " + lastName);
        usernameHeader.setText("Hello "+firstName);

        btnwhats = findViewById(R.id.imageView3);
        btnwhats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_DIAL);
                Uri uri = Uri.parse(("tel:"+012343456));
                i.setData(uri);
                startActivity(i);

            }
        });
    }

    public void SendOnChannel1(View v) {
        Notification notification = new NotificationCompat.Builder(this, App.CHANNEL_ID)
                .setSmallIcon(R.drawable.banner)
                .setContentTitle("Bloom")
                .setContentText("What got you distructed? Come back and order from our scentful collection")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_RECOMMENDATION)
                .build();

        NotificationManager.notify(1, notification);
    }

    public void SendOnChannel2(View v) {
        Notification notification = new NotificationCompat.Builder(this, App.CHANNEL2_ID)
                .setSmallIcon(R.drawable.banner)
                .setContentTitle("Bloom")
                .setContentText("What got you distructed? Come back and order from our scentful collection")
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .build();

        NotificationManager.notify(2, notification);

    }

    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList = findViewById(R.id.view2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<PlantDomain> plantlist = new ArrayList<>();
        plantlist.add(new PlantDomain("Aloe ", "pic10", "description1 ", 50.0, 10, 20));
        plantlist.add(new PlantDomain("Green Plant ", "pic12", "description2 ", 45.0, 10, 20));
        plantlist.add(new PlantDomain("Mini Plant ", "pic13", "description2 ", 60.0, 10, 20));
        plantlist.add(new PlantDomain("Arceceae Plant ", "pic11", "description2 ", 25.0, 10, 20));

        adapter2 = new RecommendedAdapter(plantlist);
        recyclerViewPopularList.setAdapter(adapter2);
    }

    private void recyclerViewCategoty() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategotyList = findViewById(R.id.view1);
        recyclerViewCategotyList.setLayoutManager(linearLayoutManager);
        ArrayList<CategoryDomain> categoryList = new ArrayList<>();
        categoryList.add(new CategoryDomain("Plants", "pic6"));
        categoryList.add(new CategoryDomain("Flowers", "picflower"));
        categoryList.add(new CategoryDomain("Collections", "pic24"));


        adapter = new CategoryAdapter(categoryList);
        recyclerViewCategotyList.setAdapter(adapter);
    }
    public void ctgbtn (View view)
    {
        startActivity(new Intent(this, CatgoryList.class));

    }
}