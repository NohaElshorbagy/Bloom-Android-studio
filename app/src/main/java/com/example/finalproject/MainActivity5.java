package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity5 extends AppCompatActivity {
    RecyclerView recyclerView,recyclerView2;
    String[] s1, s2, s3, numb , title , fee;
    int[] images = {R.drawable.plant1, R.drawable.plant2, R.drawable.plant3, R.drawable.plant4
            , R.drawable.plant5};
    int[] imagess = {R.drawable.plant1, R.drawable.plant2, R.drawable.plant3, R.drawable.plant4
            , R.drawable.plant5};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);


        Intent in = getIntent();
        String str = in.getStringExtra("Type");



        recyclerView = findViewById(R.id.Recycleview);
        recyclerView2 = findViewById(R.id.RecycleView2);


        s1 = getResources().getStringArray(R.array.plants);
        s2 = getResources().getStringArray(R.array.Total);
        s3 = getResources().getStringArray(R.array.fee);
        numb = getResources().getStringArray(R.array.number);
        title = getResources().getStringArray(R.array.RecomFlowers);
        fee = getResources().getStringArray(R.array.fee);


        MyAdabterr myAdabterr = new MyAdabterr(this, s1, s3, numb, images);
        recyclerView.setAdapter(myAdabterr);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        MostSellingAdapterr mostSellingAdapterr = new MostSellingAdapterr(this,title,fee,imagess);
        recyclerView2.setAdapter(mostSellingAdapterr);
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

//    }
//    public  void btnnclick (View view)
//    {
//        startActivity(new Intent(this, MainActivity.class));
//
//    }
//    public void btnclick (View view)
//    {
//        startActivity(new Intent(this, MainActivity3.class));
//
//    }
//    public void btnnnclick (View view)
//    {
//        startActivity(new Intent(this, MainActivity4.class));
//
//    }





}}
