package com.onboarding.ecomm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.onboarding.ecomm.Login.LoginPage;
import com.onboarding.ecomm.ProductDetails.ProductPage;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button=findViewById(R.id.basicbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Button Clicked",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(MainActivity.this, LoginPage.class);
                startActivity(intent);
            }
        });

        Button button2=findViewById(R.id.productbutton);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"Button Clicked",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(MainActivity.this, ProductPage.class);
                startActivity(intent);
            }
        });
    }
    }

