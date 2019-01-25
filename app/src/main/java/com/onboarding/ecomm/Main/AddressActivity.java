package com.onboarding.ecomm.Main;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.onboarding.ecomm.Adapters.AddressAdapter;
import com.onboarding.ecomm.Adapters.ProductSummaryAdapter;
import com.onboarding.ecomm.OrderSummary;
import com.onboarding.ecomm.R;

public class AddressActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Button btn_address;
    private RadioButton btn_radio;
    private RadioGroup radioGroup;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        btn_address=findViewById(R.id.addressbutton);
        radioGroup = findViewById(R.id.radio);
        int selectedId=radioGroup.getCheckedRadioButtonId();
        btn_radio=  findViewById(selectedId);
        recyclerView = findViewById(R.id.addressrecyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        AddressAdapter addressAdapter = new AddressAdapter();
        recyclerView.setAdapter(addressAdapter);
        btn_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AddressActivity.this, OrderSummary.class);
                intent.putExtra("Address",btn_radio.getText());
                startActivity(intent);

            }
        });
    }
}
