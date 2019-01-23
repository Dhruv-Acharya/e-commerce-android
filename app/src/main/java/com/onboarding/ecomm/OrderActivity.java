package com.onboarding.ecomm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.onboarding.ecomm.Adapters.CardViewAdapter;
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


    private String orderId="";


    private IApiClass iApiClass;
    RecyclerView recyclerView;
    private List<OrderItemResponse> orderItemResponses = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent intent = new Intent();

        orderId=intent.getStringExtra("");

        iApiClass = AppController.retrofitOrderItem.create(IApiClass.class);
        iApiClass.getOrderItems(orderId).enqueue(new Callback<List<OrderItemResponse>>() {
            @Override
            public void onResponse(Call<List<OrderItemResponse>> call, Response<List<OrderItemResponse>> response) {
                orderItemResponses = response.body();

            }

            @Override
            public void onFailure(Call<List<OrderItemResponse>> call, Throwable t) {

            }
        });
        recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        OrderAdapter orderAdapter = new OrderAdapter(orderItemResponses);
        recyclerView.setAdapter(orderAdapter);
    }


    }

