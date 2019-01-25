package com.onboarding.ecomm.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.onboarding.ecomm.Model.Response.CartResponse;
import com.onboarding.ecomm.R;
import com.onboarding.ecomm.viewholder.MyProductSummaryViewHolder;

import java.util.List;

public class ProductSummaryAdapter extends RecyclerView.Adapter {

    private List<CartResponse> productSummaryList;

    public ProductSummaryAdapter(List<CartResponse> productSummaryList) {
        this.productSummaryList = productSummaryList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_product_summary, viewGroup, false);
        return new MyProductSummaryViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((MyProductSummaryViewHolder) viewHolder).bind(cartResponseList.get(i));

    }

    @Override
    public int getItemCount() {
        return productSummaryList.size();
    }
}
