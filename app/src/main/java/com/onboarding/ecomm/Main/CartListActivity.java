package com.onboarding.ecomm.Main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.onboarding.ecomm.R;

public class CartListActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_list);

        setCartLayout();

    }

    protected void setCartLayout() {
        LinearLayout layoutCartPayments = findViewById(R.id.layout_payment);
        LinearLayout layoutCartItems = findViewById(R.id.layout_items);
        LinearLayout layoutCartNoItems = findViewById(R.id.layout_cart_empty);

        if (MainActivity.notificationCountCart > 0) {
            layoutCartNoItems.setVisibility(View.GONE);
            layoutCartItems.setVisibility(View.VISIBLE);
            layoutCartPayments.setVisibility(View.VISIBLE);
        } else {
            layoutCartNoItems.setVisibility(View.VISIBLE);
            layoutCartItems.setVisibility(View.GONE);
            layoutCartPayments.setVisibility(View.GONE);

            Button bStartShopping = findViewById(R.id.bAddNew);
            bStartShopping.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }
    }
}
