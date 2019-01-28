package com.onboarding.ecomm.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.onboarding.ecomm.R;

public class MySearchViewHolder extends RecyclerView.ViewHolder {
    private TextView productName;
    private CardView searchCardView;
    private ImageView productImage;

    public MySearchViewHolder(@NonNull View itemView) {
        super(itemView);
        productName = itemView.findViewById(R.id.searchProductName);
        productImage = itemView.findViewById(R.id.searchResultImage);
        searchCardView = itemView.findViewById(R.id.searchCardView);
    }

    public void bind(String productname, String imageUrl) {

        searchCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        productName.setText(productname);
        Glide.with(productImage.getContext()).load(imageUrl).into(productImage);
    }
}
