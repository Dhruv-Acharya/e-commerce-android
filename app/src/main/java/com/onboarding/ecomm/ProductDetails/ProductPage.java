package com.onboarding.ecomm.ProductDetails;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.onboarding.ecomm.Login.AppController;
import com.onboarding.ecomm.Login.IApiClass;
import com.onboarding.ecomm.Main.CartListActivity;
import com.onboarding.ecomm.Main.MainActivity;
import com.onboarding.ecomm.Model.Request.ProductResponse;
import com.onboarding.ecomm.R;
import com.onboarding.ecomm.notification.NotificationCountSetClass;

import retrofit2.Call;
import retrofit2.Callback;

public class ProductPage extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private static TextView product_price, product_name, usp, description;
    private static Button add_to_cart, buy_now;
    private ImageView imageView;
    private IApiClass iApiClass;
    private String productId = null;
    private String merchantId = null;
    private String imageUrl = null;
    private Spinner merchant = null;
    String[] bankNames = {"BOI", "SBI", "HDFC", "PNB", "OBC"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        product_price = findViewById(R.id.product_price);
        product_name = findViewById(R.id.product_name);
        usp = findViewById(R.id.usp);
        description = findViewById(R.id.description);
        add_to_cart = findViewById(R.id.add_to_cart);
        buy_now = findViewById(R.id.buy_now_button);
        imageView = findViewById(R.id.product_image);
        merchant = findViewById(R.id.merchant_spinner);


        merchant.setOnItemSelectedListener(this);


        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, bankNames);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//Setting the ArrayAdapter data on the Spinner
        merchant.setAdapter(aa);
        setContentView(R.layout.product_page);
        TextView textViewAddToCart = findViewById(R.id.add_to_cart);
        TextView textViewBuyNow = (TextView) findViewById(R.id.buy_now_button);


        imageView = findViewById(R.id.product_image);

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


        iApiClass = AppController.retrofitProduct.create(IApiClass.class);
        iApiClass.getProductReponse(productId, merchantId).enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, retrofit2.Response<ProductResponse> response) {
                product_price.setText(response.body().getPrice());
                product_name.setText(response.body().getName());
                usp.setText(response.body().getUsp());
                description.setText(response.body().getDescription());
                imageUrl = response.body().getImageUrl();
                Glide.with(imageView.getContext())
                        .load(imageUrl)
                        .into(imageView);
            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t) {

            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        Toast.makeText(getApplicationContext(), bankNames[position], Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}







