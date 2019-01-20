package com.onboarding.ecomm.ProductDetails;

import android.media.Image;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.onboarding.ecomm.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductPage extends AppCompatActivity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_details);

        String imageUrl="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTJeNNhKT2LFUYO9SnxIdLcyksrulnikVUFsv7Ypru8Qs3e9HFB";
        imageView= findViewById(R.id.product_image);
        Glide.with(imageView.getContext())
                .load(imageUrl)
                .into(imageView);


    }
}







