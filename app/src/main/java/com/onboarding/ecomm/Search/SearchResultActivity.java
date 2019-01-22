
package com.onboarding.ecomm.Search;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import com.onboarding.ecomm.Login.AppController;
import com.onboarding.ecomm.Login.IApiClass;
import com.onboarding.ecomm.Model.Request.ProductResponse;
import com.onboarding.ecomm.Model.Response.SearchResponse;
import com.onboarding.ecomm.R;

import retrofit2.Call;
import retrofit2.Callback;

public class SearchResultActivity extends AppCompatActivity {


    private IApiClass iApiClass;
    private String productId=null;
    private String name=null;
    private String usp=null;
    private String description=null;
    private String imageUrl=null;
    private double rating=0;
    private String priceRange=null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        iApiClass = AppController.retrofit.create(IApiClass.class);


        ((EditText)findViewById(R.id.et)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//// TODO: 22/01/19
                iApiClass = AppController.retrofit.create(IApiClass.class);
                iApiClass.getSearchResponse(name).enqueue(new Callback<SearchResponse>() {
                    @Override
                    public void onResponse(Call<SearchResponse> call, retrofit2.Response<SearchResponse> response) {
                    productId=response.body().getProductId();
                    usp=response.body().getUsp();
                    description=response.body().getDescription();
                    imageUrl=response.body().getImageUrl();
                    rating=response.body().getRating();
                    priceRange=response.body().getPriceRange();


            }

                    @Override
                    public void onFailure(Call<SearchResponse> call, Throwable t) {

                    }

        });
    }

            @Override
            public void afterTextChanged(Editable s) {

            }

            //@Override
    //public void onBackPressed() {
    //    finish();
   // }
});

    }
}
