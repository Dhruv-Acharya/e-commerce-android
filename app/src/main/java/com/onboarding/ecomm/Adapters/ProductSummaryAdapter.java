package com.onboarding.ecomm.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.onboarding.ecomm.Model.Response.OrderItemResponse;
import com.onboarding.ecomm.R;
import com.onboarding.ecomm.viewholder.MyProductSummaryViewHolder;

import java.util.List;

public class ProductSummaryAdapter extends RecyclerView.Adapter {

    private List<OrderItemResponse> orderItemResponses;
    private String address="";

    public ProductSummaryAdapter(List<OrderItemResponse> orderItemResponses,String address) {
        this.orderItemResponses = orderItemResponses;
        this.address=address;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_product_summary, viewGroup, false);
        return new MyProductSummaryViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
//        Log.e("Address", address);
        ((MyProductSummaryViewHolder) viewHolder).bind(orderItemResponses.get(i),address);

    }

    @Override
    public int getItemCount() {
        return orderItemResponses.size();
    }
}
