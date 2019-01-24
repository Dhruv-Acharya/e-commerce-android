package com.onboarding.ecomm.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.onboarding.ecomm.R;

public class MySearchViewHolder extends RecyclerView.ViewHolder {
    private TextView productName;
    private ImageView productImage;

    public MySearchViewHolder(@NonNull View itemView) {
        super(itemView);
        productName = itemView.findViewById(R.id.searchProductName);
        productImage = itemView.findViewById(R.id.searchResultImage);
    }

    public void bind(String productname, String imageUrl) {
        productName.setText(productname);
        Glide.with(productImage.getContext()).load(imageUrl).into(productImage);
    }
}
