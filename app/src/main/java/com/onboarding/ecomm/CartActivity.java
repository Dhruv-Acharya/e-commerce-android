package com.onboarding.ecomm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.onboarding.ecomm.Adapters.CartAdapter;
import com.onboarding.ecomm.Adapters.CartCommunicator;
import com.onboarding.ecomm.Login.AppController;
import com.onboarding.ecomm.Login.IApiClass;
import com.onboarding.ecomm.Model.Response.CartResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CartActivity extends AppCompatActivity implements CartCommunicator {
    private RecyclerView recyclerView;
    private CartAdapter adapter;
    private IApiClass iApiClass;
    private String customerId = "";
    private List<CartResponse> cartResponseList = new ArrayList<>();
    private TextView totalQuantity;
    private TextView totalAmount;
    private Button buyNow;
    private Button remove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        Intent intent = getIntent();
        customerId = intent.getStringExtra("CustomerId");
        remove=findViewById(R.id.remove);

        totalAmount = findViewById(R.id.totalAmount);
        totalQuantity = findViewById(R.id.totalQuantity);


        iApiClass = AppController.retrofitOrderItem.create(IApiClass.class);
        loadScreen();


//        remove.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                iApiClass.deleteProduct(customerId,)
//                loadScreen();
//
//            }
//        });


    }
    private void loadScreen()
    {
        iApiClass.getCartItems(customerId).enqueue(new Callback<List<CartResponse>>() {
            @Override
            public void onResponse(Call<List<CartResponse>> call, Response<List<CartResponse>> response) {
                cartResponseList = response.body();
                recyclerView = findViewById(R.id.recyclerViewCart);
                adapter = new CartAdapter(cartResponseList,CartActivity.this);
//                adapter.setCartCommunicator(CartActivity.this);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(CartActivity.this));
                addQuantityAndAmount(cartResponseList);





            }

            @Override
            public void onFailure(Call<List<CartResponse>> call, Throwable t) {

            }
        });

    }

    private void addQuantityAndAmount(List<CartResponse> cartResponseList) {
        double totalAmountInternal = 0;
        int totalQuantityInternal = 0;

        for (CartResponse cartResponse : cartResponseList) {
            totalAmountInternal += (cartResponse.getPrice() * cartResponse.getQuantity());
            totalQuantityInternal += cartResponse.getQuantity();
        }

        totalAmount.setText(String.valueOf(totalAmountInternal));
        totalQuantity.setText(String.valueOf(totalQuantityInternal));
    }


    @Override
    public void doOnclick(final String productId, final String merchantId) {
        iApiClass.deleteProduct(customerId,productId,merchantId);
    }
}


