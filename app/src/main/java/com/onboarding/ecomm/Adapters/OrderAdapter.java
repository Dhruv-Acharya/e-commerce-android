package com.onboarding.ecomm.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.onboarding.ecomm.Model.Response.OrderItemResponse;
import com.onboarding.ecomm.R;
import com.onboarding.ecomm.viewholder.MyOrderViewHolder;

import java.util.List;

public class OrderAdapter extends RecyclerView.Adapter {


    List<OrderItemResponse> orderItemResponses;

    public OrderAdapter(List<OrderItemResponse> orderItemResponses) {
        this.orderItemResponses = orderItemResponses;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_order, viewGroup, false);
        return new MyOrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((MyOrderViewHolder) viewHolder).bind(orderItemResponses.get(i));
    }

    @Override
    public int getItemCount() {
        return orderItemResponses.size();
    }


}




