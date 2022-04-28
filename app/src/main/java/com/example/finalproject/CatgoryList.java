package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CatgoryList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catgory_list);

    }
    public void flowerclk (View view)
    {
        startActivity(new Intent(this, MainActivity2.class));

    }
    public void plant (View view)
    {
        startActivity(new Intent(this, MainActivity5.class));

    }
}