package com.example.finalproject.Helper;

import android.content.Context;
import android.widget.Toast;

import com.example.finalproject.Domain.PlantDomain;
import com.example.finalproject.Interface.ChangeNumberItemListener;

import java.util.ArrayList;

public class ManagementCart {
    private Context context;
    private TinyDB tinyDB;

    public ManagementCart(Context context) {
        this.context = context;
        this.tinyDB =new TinyDB(context);
    }
    public void insertPlant(PlantDomain item ){
        ArrayList<PlantDomain> listPlant=getListCart();
        boolean existAlready=false;
        int n=0;
        for (int i=0;i<listPlant.size();i++){
            if(listPlant.get(i).getTitle().equals(item.getTitle())){
                existAlready=true;
                n=i;
                break;
            }
        }
        if(existAlready){
            listPlant.get(n).setNumberInCart(item.getNumberInCart());
        }else{
            listPlant.add(item);
        }
        tinyDB.putListObject("CardList",listPlant);
        Toast.makeText(context, "Added to your Cart", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<PlantDomain> getListCart() {
        return tinyDB.getListObject("CardList");
    }
public void minusNumberPlant(ArrayList<PlantDomain >listplant, int position, ChangeNumberItemListener changeNumberItemListener){
        if (listplant.get(position).getNumberInCart()==1){
            listplant.remove(position);
        }
        else{
            listplant.get(position).setNumberInCart(listplant.get(position).getNumberInCart() -1);
        }
        tinyDB.putListObject("CardList",listplant);
        changeNumberItemListener.changed();
}
public void plusNumberPlant(ArrayList<PlantDomain> listplant, int position,ChangeNumberItemListener changeNumberItemListener){
    listplant.get(position).setNumberInCart(listplant.get(position).getNumberInCart()+1);
    tinyDB.putListObject("CardList",listplant);
changeNumberItemListener.changed();
}
public Double getTotalFee(){
        ArrayList<PlantDomain>listplant2=getListCart();
        double fee=0.0;
    for (int i = 0; i < listplant2.size() ; i++) {
        fee=fee+(listplant2.get(i).getFee()*listplant2.get(i).getNumberInCart());
    }
    return fee;
}

}
