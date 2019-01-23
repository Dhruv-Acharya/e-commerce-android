package com.onboarding.ecomm.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.onboarding.ecomm.Model.Response.OrderPageResponse;
import com.onboarding.ecomm.R;
import com.onboarding.ecomm.viewholder.MyOrderPageViewHolder;

import java.util.List;

public class OrderPageAdapter extends RecyclerView.Adapter {
    List<OrderPageResponse> orderPageResponse;

    public OrderPageAdapter(List<OrderPageResponse> orderPageResponse) {
        Log.d("Response3", "Constructor");
        this.orderPageResponse = orderPageResponse;
        Log.d("Response4", "Constructor got"+this.orderPageResponse.toString());
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //Log.d("Response3", "Inflated");
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.order_layout, viewGroup, false);
        return new MyOrderPageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((MyOrderPageViewHolder) viewHolder).bind(orderPageResponse.get(i));
    }

    @Override
    public int getItemCount() {
        return orderPageResponse.size();
    }
}
