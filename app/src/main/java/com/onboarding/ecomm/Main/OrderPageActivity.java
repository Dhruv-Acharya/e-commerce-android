package com.onboarding.ecomm.Main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.onboarding.ecomm.Adapters.OrderPageAdapter;
import com.onboarding.ecomm.Login.AppController;
import com.onboarding.ecomm.Login.IApiClass;
import com.onboarding.ecomm.Model.Response.OrderPageResponse;
import com.onboarding.ecomm.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OrderPageActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private OrderPageAdapter orderPageAdapter;
    private List<OrderPageResponse> orderList = new ArrayList<>();
    private IApiClass iApiClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_page);
        recyclerView = findViewById(R.id.recyclerViewOrder);
        iApiClass = AppController.retrofitOrderItem.create(IApiClass.class);
        orderPageAdapter = new OrderPageAdapter(orderList);
        recyclerView.setLayoutManager(new LinearLayoutManager(OrderPageActivity.this));
        recyclerView.setAdapter(orderPageAdapter);
        iApiClass.getOrderResponse(MainActivity.tokenId).enqueue(new Callback<List<OrderPageResponse>>() {
            @Override
            public void onResponse(Call<List<OrderPageResponse>> call, Response<List<OrderPageResponse>> response) {
                Log.d("Response1", response.body().toString());
                orderList = response.body();
                Log.d("Response2", response.body().toString());
                orderPageAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<OrderPageResponse>> call, Throwable t) {

            }
        });


    }
}

