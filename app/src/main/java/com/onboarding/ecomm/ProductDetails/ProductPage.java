package com.onboarding.ecomm.ProductDetails;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.onboarding.ecomm.Main.CartListActivity;
import com.onboarding.ecomm.Main.MainActivity;
import com.onboarding.ecomm.R;
import com.onboarding.ecomm.notification.NotificationCountSetClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductPage extends AppCompatActivity {
    private ImageView imageView;
    private static TextView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_page);
        TextView textViewAddToCart = findViewById(R.id.add_to_cart);
        TextView textViewBuyNow = (TextView)findViewById(R.id.buy_now_button);



        String imageUrl="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTJeNNhKT2LFUYO9SnxIdLcyksrulnikVUFsv7Ypru8Qs3e9HFB";
        imageView= findViewById(R.id.product_image);
        Glide.with(imageView.getContext())
                .load(imageUrl)
                .into(imageView);
        textViewAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Item added to cart", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                MainActivity.notificationCountCart++;
                NotificationCountSetClass.setNotifyCount(MainActivity.notificationCountCart);
            }
        });

        textViewBuyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MainActivity.notificationCountCart++;
                NotificationCountSetClass.setNotifyCount(MainActivity.notificationCountCart);
                startActivity(new Intent(ProductPage.this, CartListActivity.class));

            }
        });


    }
}







