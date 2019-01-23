package com.onboarding.ecomm.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.onboarding.ecomm.Model.Response.CartResponse;
import com.onboarding.ecomm.R;

public class CartViewHolder extends RecyclerView.ViewHolder {
    private TextView productName;
    private TextView merchantName;
    private TextView productPrice;
    private TextView productQuantity;
    private ImageView productImage;


    public CartViewHolder(@NonNull View itemView) {

        super(itemView);

        productName = itemView.findViewById(R.id.productNameCart);
        productPrice = itemView.findViewById(R.id.productPriceCart);
        productImage = itemView.findViewById(R.id.imageViewCart);
        productQuantity = itemView.findViewById(R.id.quantityCart);
        merchantName = itemView.findViewById(R.id.merchantNameCart);

    }

    public void bind(final CartResponse cartResponse) {
        productName.setText(cartResponse.getName());
        productPrice.setText(String.valueOf(cartResponse.getPrice()));
        Glide.with(productImage.getContext()).load(cartResponse.getImageUrl()).into(productImage);
        productQuantity.setText(String.valueOf(cartResponse.getQuantity()));
        merchantName.setText(cartResponse.getMerchantName());


    }
}
