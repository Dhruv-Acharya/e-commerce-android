package com.onboarding.ecomm.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.onboarding.ecomm.Model.Response.CartResponse;
import com.onboarding.ecomm.R;
import com.onboarding.ecomm.viewholder.CartViewHolder;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<CartResponse> cartResponseList;

    public CartAdapter(List<CartResponse> cartResponseList) {
        this.cartResponseList = cartResponseList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cart_layout,viewGroup,false);
        return new CartViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((CartViewHolder)viewHolder).bind(cartResponseList.get(i));

    }

    @Override
    public int getItemCount() {
        return cartResponseList.size();
    }
}
