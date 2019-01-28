package com.onboarding.ecomm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.onboarding.ecomm.Adapters.ProductSummaryAdapter;
import com.onboarding.ecomm.Login.AppController;
import com.onboarding.ecomm.Login.IApiClass;
import com.onboarding.ecomm.Main.MainActivity;
import com.onboarding.ecomm.Model.Response.OrderItemResponse;
import com.onboarding.ecomm.Model.Response.OrderPageResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderSummary extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Button btn_continueshopping;
    List<OrderPageResponse> orderPageResponses=new ArrayList<>();
    List<OrderItemResponse> orderItemResponses=new ArrayList<>();
    ProductSummaryAdapter productSummaryAdapter;
    private TextView summaryAddress;
    private String address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_order_summary);
        Intent intent=getIntent();
        address=intent.getStringExtra("Address");
        recyclerView = findViewById(R.id.product_summary_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        summaryAddress = findViewById(R.id.summaryAddress);
        summaryAddress.setText(address);
        final IApiClass iApiClass= AppController.retrofitOrderItem.create(IApiClass.class);
        iApiClass.getOrderResponse(MainActivity.tokenId).enqueue(new Callback<List<OrderPageResponse>>() {
            @Override
            public void onResponse(Call<List<OrderPageResponse>> call, Response<List<OrderPageResponse>> response) {
                orderPageResponses.addAll(response.body());
                final String orderId=orderPageResponses.get(0).getOrderId();

                iApiClass.getOrderItems(orderId).enqueue(new Callback<List<OrderItemResponse>>() {
                    @Override
                    public void onResponse(Call<List<OrderItemResponse>> call, Response<List<OrderItemResponse>> response) {

                        System.out.println(address);


                        orderItemResponses.addAll(response.body());


                        productSummaryAdapter = new ProductSummaryAdapter(orderItemResponses,address);
                        recyclerView.setLayoutManager(new LinearLayoutManager(OrderSummary.this, LinearLayoutManager.VERTICAL, false));
                        recyclerView.setAdapter(productSummaryAdapter);
                    }

                    @Override
                    public void onFailure(Call<List<OrderItemResponse>> call, Throwable t) {

                    }
                });




            }

            @Override
            public void onFailure(Call<List<OrderPageResponse>> call, Throwable t) {

            }
        });

        btn_continueshopping=findViewById(R.id.buttonContinue);
        btn_continueshopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(OrderSummary.this, MainActivity.class);
                startActivity(intent);



            }
        });

    }
}
