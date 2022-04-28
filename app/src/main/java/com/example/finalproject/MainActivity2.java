package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.Toast;


public class MainActivity2 extends AppCompatActivity {
    AirplaneModeChangeReceiver airplaneModeChangeReceiver = new AirplaneModeChangeReceiver();

    BroadcastReceiver broadcastReceiver;


    RecyclerView recyclerView,recyclerView2;
    String[] s1, s2, s3, numb , title , fee;
    int[] images = {R.drawable.alstroemerias, R.drawable.azalea, R.drawable.buttercup, R.drawable.rose
            , R.drawable.chrysanthemum};

    int[] imagess = {R.drawable.alstroemerias, R.drawable.azalea, R.drawable.buttercup, R.drawable.rose
            , R.drawable.chrysanthemum};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Intent in = getIntent();
        String str = in.getStringExtra("Type");




        broadcastReceiver = new MyReceiver();
        registerNetworkBroadcastReciver();




        recyclerView = findViewById(R.id.Recycleview);
        recyclerView2 = findViewById(R.id.RecycleView2);


        s1 = getResources().getStringArray(R.array.Flowers);
        s2 = getResources().getStringArray(R.array.Total);
        s3 = getResources().getStringArray(R.array.fee);
        numb = getResources().getStringArray(R.array.number);
        title = getResources().getStringArray(R.array.RecomFlowers);
        fee = getResources().getStringArray(R.array.fee);


        MyAdabter myAdabter = new MyAdabter(this, s1, s3, numb, images);
        recyclerView.setAdapter(myAdabter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        MostSellingAdapter mostSellingAdapter = new MostSellingAdapter(this,title,fee,imagess);
        recyclerView2.setAdapter(mostSellingAdapter);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

//    public void OnBroadCastSendBtn (View v)
//    {
//        Intent intent = new Intent();
//        intent.setAction(com.example.myapplication12.);
//        intent.setFlags(Intent.FLAG_EXCLUDE_STOPPED_PACKAGES);
//        sendBroadcast(intent);
//
//
//    }
//        b.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(MainActivity.this, "hii", Toast.LENGTH_SHORT).show();
//            }
//        });


//        ImageButton homeBtn = findViewById(R.id.imageButton2);

//        homeBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(MainActivity.this, MainActivity2.class));
//            }
//        });

    }
    public  void btnnclick (View view)
    {
        startActivity(new Intent(this, MainActivity.class));

    }
    public void btnclick (View view)
    {
        startActivity(new Intent(this, MainActivity3.class));

    }
    public void btnnnclick (View view)
    {
        startActivity(new Intent(this, MainActivity4.class));

    }




    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        registerReceiver(airplaneModeChangeReceiver, filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(airplaneModeChangeReceiver);
    }


    protected void registerNetworkBroadcastReciver ()
    {

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.N)
        {
            registerReceiver(broadcastReceiver , new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));

        }
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O)
        {
            registerReceiver(broadcastReceiver , new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));

        }
    }
    protected  void unRegisterd ()
    {
        try {
            unregisterReceiver(broadcastReceiver);

        }
        catch (IllegalArgumentException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unRegisterd();
    }
}