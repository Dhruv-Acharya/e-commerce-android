package com.onboarding.ecomm.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.onboarding.ecomm.Model.Response.OrderItemResponse;
import com.onboarding.ecomm.R;

public class MyProductSummaryViewHolder extends RecyclerView.ViewHolder {
    private TextView productName;
    private TextView merchantName;
    private TextView price;
    private TextView orderId;
    private TextView clientAddress;

    public MyProductSummaryViewHolder(@NonNull View itemView) {
        super(itemView);
        productName = itemView.findViewById(R.id.summaryProductName);
        merchantName = itemView.findViewById(R.id.summaryMerchantName);
        price = itemView.findViewById(R.id.summaryAmount);
        //orderId = itemView.findViewById(R.id.summaryOrderId);
//        clientAddress = itemView.findViewById(R.id.summaryAddress);
    }

    public void bind(OrderItemResponse orderItemResponse,String address) {
        Log.e("Address" , address);
        productName.setText(orderItemResponse.getProductName());
        merchantName.setText(orderItemResponse.getMerchantName());
        price.setText("" + orderItemResponse.getProductPrice());
//        clientAddress.setText(address);

    }
}
