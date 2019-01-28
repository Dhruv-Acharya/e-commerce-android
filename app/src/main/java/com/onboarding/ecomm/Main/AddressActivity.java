package com.onboarding.ecomm.Main;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.onboarding.ecomm.Adapters.AddressAdapter;
import com.onboarding.ecomm.Adapters.OrderAdapter;
import com.onboarding.ecomm.Adapters.ProductSummaryAdapter;
import com.onboarding.ecomm.Login.AppController;
import com.onboarding.ecomm.Login.IApiClass;
import com.onboarding.ecomm.Model.Response.AddressResponse;
import com.onboarding.ecomm.OrderActivity;
import com.onboarding.ecomm.OrderSummary;
import com.onboarding.ecomm.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddressActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Button btn_address;
    private RadioButton btn_radio;
    private RadioGroup radioGroup;
    final List<AddressResponse> addressResponses=new ArrayList();
    AddressAdapter addressAdapter ;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent=getIntent();
        String CustomerId=intent.getStringExtra("CustomerId");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        btn_address=findViewById(R.id.addressbutton);
//        radioGroup = findViewById(R.id.radio);
//        int selectedId=radioGroup.getCheckedRadioButtonId();
        btn_radio=  findViewById(R.id.radiobutton);
        recyclerView = findViewById(R.id.addressrecyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);



        IApiClass iApiClass=  AppController.retrofit.create(IApiClass.class);
        Log.e("CustomerId",CustomerId);
        iApiClass.getAddresses(CustomerId).enqueue(new Callback<List<AddressResponse>>() {
            @Override
            public void onResponse(Call<List<AddressResponse>> call, Response<List<AddressResponse>> response) {

                addressResponses.addAll(response.body());
                addressAdapter=new AddressAdapter(addressResponses);

                recyclerView.setLayoutManager(new LinearLayoutManager(AddressActivity.this, LinearLayoutManager.VERTICAL, false));
                recyclerView.setAdapter(addressAdapter);
            }

            @Override
            public void onFailure(Call<List<AddressResponse>> call, Throwable t) {

            }
        });


//        btn_address.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(AddressActivity.this, OrderSummary.class);
//                intent.putExtra("Address",btn_radio.getText());
//                startActivity(intent);
//
//            }
//        });
//    }
}}
