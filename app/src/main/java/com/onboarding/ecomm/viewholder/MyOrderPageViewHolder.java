package com.onboarding.ecomm.viewholder;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.onboarding.ecomm.Model.Response.OrderPageResponse;
import com.onboarding.ecomm.OrderActivity;
import com.onboarding.ecomm.R;

public class MyOrderPageViewHolder extends RecyclerView.ViewHolder {
    private TextView orderId;
    private TextView customerId;
    private TextView dateOfDelivery;
    private TextView price;
    private CardView cardView;

    public MyOrderPageViewHolder(@NonNull View itemView) {
        super(itemView);
        orderId = itemView.findViewById(R.id.orderId);
        customerId = itemView.findViewById(R.id.customerId);
        dateOfDelivery = itemView.findViewById(R.id.date);
        price = itemView.findViewById(R.id.amount);
        cardView = itemView.findViewById(R.id.recyclerViewOrder);
    }

    public void bind(final OrderPageResponse orderPageResponse) {
        orderId.setText(orderPageResponse.getOrderId());
        customerId.setText(orderPageResponse.getCustomerId());
        dateOfDelivery.setText(orderPageResponse.getDate());
        price.setText(String.valueOf(orderPageResponse.getAmount()));
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(orderId.getContext(), OrderActivity.class);
                intent.putExtra("OrderId", orderId.getText().toString());
                orderId.getContext().startActivity(intent);
            }
        });
    }
}
