package com.onboarding.ecomm.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.onboarding.ecomm.Adapters.CartCommunicator;
import com.onboarding.ecomm.Model.Response.CartResponse;
import com.onboarding.ecomm.R;

public class CartViewHolder extends RecyclerView.ViewHolder {
    private TextView productName;
    private TextView merchantName;
    private TextView productPrice;
    private TextView productQuantity;
    private ImageView productImage;
    private Button removeButton;


    public CartViewHolder(@NonNull View itemView) {

        super(itemView);

        productName = itemView.findViewById(R.id.productNameCart);
        productPrice = itemView.findViewById(R.id.productPriceCart);
        productImage = itemView.findViewById(R.id.imageViewCart);
        productQuantity = itemView.findViewById(R.id.quantityCart);
        merchantName = itemView.findViewById(R.id.merchantNameCart);
        removeButton = itemView.findViewById(R.id.remove);

    }

    public void bind(final CartResponse cartResponse, final CartCommunicator cartCommunicator) {
        productName.setText(cartResponse.getName());
        productPrice.setText(String.valueOf(cartResponse.getPrice()));
        Glide.with(productImage.getContext()).load(cartResponse.getImageUrl()).into(productImage);
        productQuantity.setText(String.valueOf(cartResponse.getQuantity()));
        merchantName.setText(cartResponse.getMerchantName());
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cartCommunicator.doOnclick(cartResponse.getProductId(),cartResponse.getMerchantId());
            }
        });


    }
}
