package com.onboarding.ecomm.ProductDetails;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.onboarding.ecomm.Login.AppController;
import com.onboarding.ecomm.Login.IApiClass;
import com.onboarding.ecomm.Main.MainActivity;
import com.onboarding.ecomm.Model.Response.MerchantResponse;
import com.onboarding.ecomm.Model.Response.ProductResponse;
import com.onboarding.ecomm.Model.Response.RequestForAddToCart;
import com.onboarding.ecomm.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductPage extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private static TextView product_price, product_name, usp, description;
    private static Button add_to_cart, buy_now;
    List<String> merchantNames = new ArrayList<>();
    private ImageView imageView;
    private IApiClass iApiClass;
    private String productId = "";
    private String merchantId = null;
    private String imageUrl = null;
    private Spinner merchant = null;
    private HashMap<String, Integer> merchantMap = new HashMap<>();
    private HashMap<String, String> merchantIdMap = new HashMap<>();
    private ElegantNumberButton quantity = null;
    private static int quantityInCart=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_page);
        product_price = findViewById(R.id.product_price);
        product_name = findViewById(R.id.product_name);
        usp = findViewById(R.id.usp);
        description = findViewById(R.id.description);
        add_to_cart = findViewById(R.id.add_to_cart);
        buy_now = findViewById(R.id.buy_now_button);
        imageView = findViewById(R.id.product_image);
        merchant = findViewById(R.id.merchant_spinner);
        quantity = findViewById(R.id.quantity);
        quantity.setNumber(String.valueOf(0));


        merchant.setOnItemSelectedListener(this);
        productId = getIntent().getStringExtra("ProductID");
        Log.e("ProductId", productId);

//        TextView textViewAddToCart = findViewById(R.id.add_to_cart);
//        TextView textViewBuyNow = (TextView) findViewById(R.id.buy_now_button);


        imageView = findViewById(R.id.product_image);


//        textViewAddToCart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Item added to cart", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//                MainActivity.notificationCountCart++;
//                NotificationCountSetClass.setNotifyCount(MainActivity.notificationCountCart);
//            }
//        });
//
//        textViewBuyNow.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                MainActivity.notificationCountCart++;
//                NotificationCountSetClass.setNotifyCount(MainActivity.notificationCountCart);
//                startActivity(new Intent(ProductPage.this, CartListActivity.class));
//
//            }
//        });


        System.out.println(productId + "ProductID");
        iApiClass = AppController.retrofitProduct.create(IApiClass.class);
        iApiClass.getProductReponse(productId).enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, retrofit2.Response<ProductResponse> response) {
                Log.e("Log", response.body().toString());
                //product_price.setText(merchantMap.get(merchantNames.get(0)));
                product_name.setText(response.body().getName());
                Toast.makeText(ProductPage.this, "fetched", Toast.LENGTH_SHORT).show();
                usp.setText(response.body().getUsp());
                description.setText(response.body().getDescription());
                imageUrl = response.body().getImageUrl();
                Glide.with(imageView.getContext())
                        .load(imageUrl)
                        .into(imageView);


                iApiClass.getMerchants(productId).enqueue(new Callback<List<MerchantResponse>>() {
                    @Override
                    public void onResponse(Call<List<MerchantResponse>> call, Response<List<MerchantResponse>> response) {


                        List<MerchantResponse> merchantResponses = response.body();
                        for (MerchantResponse merchantResponse : merchantResponses) {
                            merchantNames.add(merchantResponse.getName());
                            merchantMap.put(merchantResponse.getName(), merchantResponse.getPrice());
                            merchantIdMap.put(merchantResponse.getName(), merchantResponse.getMerchantId());
                        }
                        product_price.setText(String.valueOf(merchantMap.get(merchantNames.get(0))));

                        ArrayAdapter aa = new ArrayAdapter(ProductPage.this, android.R.layout.simple_spinner_item, merchantNames);
                        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//Setting the ArrayAdapter data on the Spinner
                        merchant.setAdapter(aa);
                    }

                    @Override
                    public void onFailure(Call<List<MerchantResponse>> call, Throwable t) {
                        Log.d("TESTMYLOG", t.getMessage());
                    }
                });
            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t) {

            }
        });








        add_to_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Failure2", String.valueOf(MainActivity.tokenId));
                //  MainActivity.tokenId="abc";
                if (MainActivity.tokenId != null) {
                    Log.e("Quantity",String.valueOf(quantity.getNumber()));
//                    quantityInCart= Integer.valueOf(quantity.getNumber());
                    if (quantityInCart== 0) {
                        iApiClass = AppController.retrofitOrderItem.create(IApiClass.class);
                        RequestForAddToCart requestForAddToCart = new RequestForAddToCart();
                        requestForAddToCart.setQuantity(Integer.valueOf(quantity.getNumber()));
                        quantityInCart=Integer.valueOf(quantity.getNumber());
                        iApiClass.addToCart(MainActivity.tokenId, productId, merchantId, requestForAddToCart).enqueue(new Callback<Void>() {
                            @Override
                            public void onResponse(Call<Void> call, Response<Void> response) {
                                Log.d("response.code()", String.valueOf(response.code()));
                                if (response.code() == 200) {
                                    Toast.makeText(ProductPage.this, "Product added", Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(ProductPage.this, "Product not added", Toast.LENGTH_LONG).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<Void> call, Throwable t) {
                                Log.d("Failure", t.getMessage());


                            }
                        });


                    }else{
                        iApiClass = AppController.retrofitOrderItem.create(IApiClass.class);
                        RequestForAddToCart requestForAddToCart = new RequestForAddToCart();
                        requestForAddToCart.setQuantity(Integer.valueOf(quantity.getNumber())+quantityInCart);
                        quantityInCart=Integer.valueOf(quantity.getNumber())+quantityInCart;
                        iApiClass.updateToCart(MainActivity.tokenId,productId,merchantId,requestForAddToCart).enqueue(new Callback<Void>() {
                            @Override
                            public void onResponse(Call<Void> call, Response<Void> response) {
                                if(response.code() == 200) {
                                    Toast.makeText(ProductPage.this, "Product added", Toast.LENGTH_LONG).show();
                                } else {
                                    Toast.makeText(ProductPage.this, "Product not added", Toast.LENGTH_LONG).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<Void> call, Throwable t) {
                                Log.d("Failed to update cart", t.getMessage());

                            }
                        });

                    }

                }
            }
        });


    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        product_price.setText(String.valueOf(merchantMap.get(merchantNames.get(position))));
        merchantId = merchantIdMap.get(merchantNames.get(position));

        Toast.makeText(getApplicationContext(), merchantNames.get(position), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}







