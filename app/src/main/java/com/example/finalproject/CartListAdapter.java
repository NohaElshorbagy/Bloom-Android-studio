package com.example.finalproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.finalproject.Domain.PlantDomain;
import com.example.finalproject.Helper.ManagementCart;
import com.example.finalproject.Interface.ChangeNumberItemListener;

import java.util.ArrayList;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.ViewHolder> {
ArrayList<PlantDomain> listPlantSelected;
private ManagementCart managementCart;
ChangeNumberItemListener changeNumberItemListener;
    public CartListAdapter(ArrayList<PlantDomain> listPlantSelected, Context context, ChangeNumberItemListener changeNumberItemListener) {
        this.listPlantSelected = listPlantSelected;
        managementCart=new ManagementCart(context);
        this.changeNumberItemListener=changeNumberItemListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cart,parent,false);
        return  new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
holder.title.setText(listPlantSelected.get(position).getTitle());
holder.feeEachItem.setText("$"+String.valueOf(listPlantSelected.get(position).getFee()));
holder.totalEachItem.setText("$"+Math.round(listPlantSelected.get(position).getNumberInCart()*listPlantSelected.get(position).getFee()));
holder.num.setText(String.valueOf(listPlantSelected.get(position).getNumberInCart()));
String picUrl="";

int drawableResourceId=holder.itemView.getContext().getResources().getIdentifier(listPlantSelected.get(position).getPic(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.pic);
holder.plusItem.setOnClickListener(view -> managementCart.plusNumberPlant(listPlantSelected, position, () -> {
    notifyDataSetChanged();
    changeNumberItemListener.changed();
}));
holder.minusItem.setOnClickListener(view -> managementCart.minusNumberPlant(listPlantSelected, position, () -> {
    notifyDataSetChanged();
    changeNumberItemListener.changed();
}));
    }

    @Override
    public int getItemCount() {
        return listPlantSelected.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,feeEachItem;
        ImageView pic,plusItem,minusItem;
        TextView totalEachItem,num;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title);
            pic=itemView.findViewById(R.id.pic);
            feeEachItem=itemView.findViewById(R.id.fee);
            totalEachItem=itemView.findViewById(R.id.totalEachItem);
            plusItem=itemView.findViewById(R.id.plusCardBtn);
            minusItem=itemView.findViewById(R.id.minusCardBtn);
            num=itemView.findViewById(R.id.numberItemTxt);
        }
    }
}
