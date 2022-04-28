package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity3 extends AppCompatActivity {

    RecyclerView recyclerView;
    String[] s1, s2, s3, numb;
    int[] images = {R.drawable.alstroemerias, R.drawable.azalea, R.drawable.buttercup, R.drawable.rose
            , R.drawable.chrysanthemum};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
//        Intent intent = getIntent();

        recyclerView = findViewById(R.id.view);


        s1 = getResources().getStringArray(R.array.Flowers);
        s2 = getResources().getStringArray(R.array.Total);
        s3 = getResources().getStringArray(R.array.fee);
        numb = getResources().getStringArray(R.array.number);


        MySecondAdapter myAdabter = new MySecondAdapter(this, s1, s3, numb, images);
        recyclerView.setAdapter(myAdabter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//
//        ImageButton homeBtn = findViewById(R.id.imageButton2);
//
//        homeBtn.setOnClickListener(new View.OnClickListener() {
//                                       @Override
//                                       public void onClick(View v) {
//                                           startActivity(new Intent(MainActivity2.this, MainActivity2.class));
//                                       }
//                                   }
//        );


    }


}
