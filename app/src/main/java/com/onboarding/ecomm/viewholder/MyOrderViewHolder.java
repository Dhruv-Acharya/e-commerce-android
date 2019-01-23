package com.onboarding.ecomm.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.onboarding.ecomm.Model.Response.OrderItemResponse;
import com.onboarding.ecomm.Model.Response.ProductByCategoryResponce;
import com.onboarding.ecomm.R;

public class MyOrderViewHolder extends RecyclerView.ViewHolder {
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

    public void bind(final OrderItemResponse orderItemResponse){
        pname.setText(orderItemResponse.getProductName());
        pprice.setText(orderItemResponse.getProductPrice());
        pmerchant.setText(orderItemResponse.getMerchantName());
        pQuantity.setText(orderItemResponse.getProductQuantity());
        Glide.with(pimage.getContext()).load(orderItemResponse.getProductImageUrl()).into(pimage);

    }

}
