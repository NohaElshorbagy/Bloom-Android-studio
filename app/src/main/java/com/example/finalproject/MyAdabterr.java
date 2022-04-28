package com.example.finalproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdabterr extends RecyclerView.Adapter<MyAdabterr.MyViewHolder>  {
    String data1[] , fee[] , num[] ;
    int images[];
    Context context;

    public MyAdabterr (Context ct , String s1[],String s3[],String numb[], int img[])
    {
        context = ct;
        data1=s1;
        fee=s3;
        num=numb;
        images= img;


    }




    @NonNull
    @Override
    public MyAdabterr.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.my_row , parent , false);
        return new MyAdabterr.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdabterr.MyViewHolder holder, int position) {
        holder.mytext1.setText(data1[position]);
//        holder.mytext2.setText("$"+total[position]);
        holder.myimage.setImageResource(images[position]);
        holder.myimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context,MainActivity4.class);
                context.startActivity(i);
            }
        });
        holder.num.setText(num[position]);
        holder.TotalEachItem.setText("$"+fee[position]);
        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Your Item Is Added", Toast.LENGTH_SHORT).show();
            }
        });
        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Your item has been removed", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView mytext1 , mytext2,TotalEachItem , num;
        ImageView myimage , plus , minus;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mytext1 = itemView.findViewById(R.id.titleTxt);
//            mytext2 = itemView.findViewById(R.id.total);
            myimage = itemView.findViewById(R.id.imageView);
            TotalEachItem = itemView.findViewById(R.id.totalEachItem);
            plus = itemView.findViewById(R.id.plusCardBtn);
            minus = itemView.findViewById(R.id.minusCardBtn);
            num = itemView.findViewById(R.id.numberItemTxt);

        }
    }
}

