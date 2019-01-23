
package com.onboarding.ecomm.Search;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.onboarding.ecomm.Adapters.OrderAdapter;
import com.onboarding.ecomm.Adapters.SearchAdapter;
import com.onboarding.ecomm.Login.AppController;
import com.onboarding.ecomm.Login.IApiClass;
import com.onboarding.ecomm.Model.Response.SearchResponse;
import com.onboarding.ecomm.R;

import java.util.List;

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
    RecyclerView recyclerView;
    List<SearchResponse> searchResponse;




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
                iApiClass = AppController.retrofitProduct.create(IApiClass.class);
                iApiClass.getSearchResponse(name).enqueue(new Callback<SearchResponse>() {
                    @Override
                    public void onResponse(Call<SearchResponse> call, retrofit2.Response<SearchResponse> response) {
                    productId=response.body().getProductId();
                    usp=response.body().getUsp();
                    description=response.body().getDescription();
                    imageUrl=response.body().getImageUrl();
                    rating=response.body().getRating();
                    priceRange=response.body().getPriceRange();
                        recyclerView = findViewById(R.id.recyclerViewSearch);
                        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(recyclerView.getContext());
                        recyclerView.setLayoutManager(linearLayoutManager);
                        SearchAdapter searchAdapter = new SearchAdapter(searchResponse);
                        recyclerView.setAdapter(searchAdapter);



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
