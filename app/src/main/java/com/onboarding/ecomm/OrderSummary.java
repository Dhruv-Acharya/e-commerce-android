package com.onboarding.ecomm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.onboarding.ecomm.Adapters.AddressAdapter;
import com.onboarding.ecomm.Adapters.OrderAdapter;
import com.onboarding.ecomm.Adapters.ProductSummaryAdapter;
import com.onboarding.ecomm.Main.MainActivity;

public class OrderSummary extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Button btn_continueshopping;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_order_summary);
        recyclerView = findViewById(R.id.product_summary_recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        ProductSummaryAdapter productSummaryAdapter = new ProductSummaryAdapter();
        recyclerView.setAdapter(productSummaryAdapter);
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
