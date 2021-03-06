package com.onboarding.ecomm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.onboarding.ecomm.Adapters.OrderAdapter;
import com.onboarding.ecomm.Login.AppController;
import com.onboarding.ecomm.Login.IApiClass;
import com.onboarding.ecomm.Model.Response.OrderItemResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderActivity extends AppCompatActivity {


    private String orderId = "";


    private OrderAdapter orderAdapter;
    private IApiClass iApiClass;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<OrderItemResponse> orderItemResponses = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent intent = getIntent();
        orderId = intent.getStringExtra("OrderId");
        Log.d("OrderId", orderId);
        recyclerView = findViewById(R.id.recyclerView);

        iApiClass = AppController.retrofitOrderItem.create(IApiClass.class);
        iApiClass.getOrderItems(orderId).enqueue(new Callback<List<OrderItemResponse>>() {
            @Override
            public void onResponse(Call<List<OrderItemResponse>> call, Response<List<OrderItemResponse>> response) {
                Log.e("Click", "done");
                orderItemResponses.addAll(response.body());
                Log.d("Click", orderItemResponses.toString());

                orderAdapter = new OrderAdapter(orderItemResponses);
                recyclerView.setLayoutManager(new LinearLayoutManager(OrderActivity.this, LinearLayoutManager.VERTICAL, false));
                recyclerView.setAdapter(orderAdapter);

            }

            @Override
            public void onFailure(Call<List<OrderItemResponse>> call, Throwable t) {
                Log.d("Failure1", "Failure");

            }
        });

    }


}

