package com.onboarding.ecomm.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.onboarding.ecomm.Model.Response.ProductByCategoryResponce;
import com.onboarding.ecomm.R;

import java.util.ArrayList;
import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter {


    List<ProductByCategoryResponce> productList;
    public OrderAdapter(List<ProductByCategoryResponce> productList) {
        this.productList = productList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_order, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  RecyclerView.ViewHolder viewHolder, int i) {
       // ((MyViewHolder) viewHolder).bind();
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }



}

class MyOrderViewHolder extends RecyclerView.ViewHolder {
    TextView pname;
    TextView pprice;
    ImageView pimage;
    TextView pmerchant;
    TextView pQuantity;


    public MyOrderViewHolder(@NonNull View itemView) {
        super(itemView);
        pname = itemView.findViewById(R.id.pname);
        pimage = itemView.findViewById(R.id.pimage);
        pprice=itemView.findViewById(R.id.pprice);
        pmerchant=itemView.findViewById(R.id.pmerchant);
        pQuantity=itemView.findViewById(R.id.pquantity);
    }

    void bind(String productName, String imageUrl,String productPrice,String productMerchant,String productQuantity){
        pname.setText(productName);
        pprice.setText(productPrice);
        pmerchant.setText(productMerchant);
        pQuantity.setText(productQuantity);
        Glide.with(pimage.getContext()).load(imageUrl).into(pimage);

    }

}


