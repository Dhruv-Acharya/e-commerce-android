package com.onboarding.ecomm.Search;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.onboarding.ecomm.Adapters.SearchAdapter;
import com.onboarding.ecomm.Login.AppController;
import com.onboarding.ecomm.Login.IApiClass;
import com.onboarding.ecomm.Model.Response.SearchResponse;
import com.onboarding.ecomm.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class SearchResultActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    List<SearchResponse> searchResponse = new ArrayList<>();
    private IApiClass iApiClass;
    private String productId = null;
    private EditText name;
    private String usp = null;
    private String description = null;
    private String imageUrl = null;
    private double rating = 0;
    private String priceRange = null;
    private TextView searchProductName;
    private ImageView searchResultImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        iApiClass = AppController.retrofit.create(IApiClass.class);
        searchProductName = findViewById(R.id.searchProductName);
        searchResultImage = findViewById(R.id.searchResultImage);
        name=findViewById(R.id.et);

        recyclerView = findViewById(R.id.recyclerViewSearch);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);


        ((EditText) findViewById(R.id.et)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                iApiClass = AppController.retrofitSearchItem.create(IApiClass.class);
                iApiClass.getSearchResponse(s.toString()).enqueue(new Callback<List<SearchResponse>>() {
                    @Override
                    public void onResponse(Call<List<SearchResponse>> call, retrofit2.Response<List<SearchResponse>> response) {

                        Log.e("response",response.body().toString());
                        searchResponse.clear();
                        List<SearchResponse> temp = response.body();
                        if (temp.size() > 0) {
                            searchResponse.addAll(temp);
                        }
                        final SearchAdapter searchAdapter = new SearchAdapter(searchResponse);
                        recyclerView.setAdapter(searchAdapter);
                        searchAdapter.notifyDataSetChanged();


                    }

                    @Override
                    public void onFailure(Call<List<SearchResponse>>call, Throwable t) {

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
