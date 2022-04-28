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

public class MostSellingAdapter extends RecyclerView.Adapter<MostSellingAdapter.MyViewHolder>{
    String title[] , fee[] ;
    int images[];
    Context context;
    public MostSellingAdapter(Context ct , String s1[], String s3[], int img[])
    {
        context = ct;
        title=s1;
        fee=s3;
        images= img;

    }

    @NonNull
    @Override
    public MostSellingAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v= inflater.inflate(R.layout.viewholder , parent , false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MostSellingAdapter.MyViewHolder holder, int position) {
        holder.mytext1.setText(title[position]);
//        holder.mytext2.setText("$"+total[position]);
        holder.myimage.setImageResource(images[position]);
        holder.TotalEachItem.setText("$"+fee[position]);
        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "Your Item Is Added To Cart", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount(){return images.length;}


    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mytext1, mytext2, TotalEachItem, num;
        ImageView myimage, plus, minus;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mytext1 = itemView.findViewById(R.id.title);
//            mytext2 = itemView.findViewById(R.id.total);
            myimage = itemView.findViewById(R.id.pic);
            TotalEachItem = itemView.findViewById(R.id.fee);
            plus = itemView.findViewById(R.id.addBtn);
//            minus = itemView.findViewById(R.id.minuscardbtn);
        }
    }
}