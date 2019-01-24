package com.onboarding.ecomm.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.onboarding.ecomm.Adapters.CardViewAdapter;
import com.onboarding.ecomm.Adapters.Icommunicator;
import com.onboarding.ecomm.Login.AppController;
import com.onboarding.ecomm.Login.IApiClass;
import com.onboarding.ecomm.Model.Response.ProductByCategoryResponce;
import com.onboarding.ecomm.ProductDetails.ProductPage;
import com.onboarding.ecomm.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ElectronicsFragment extends Fragment implements Icommunicator {
    List<ProductByCategoryResponce> productByCategoryResponces;
    ArrayList logos = new ArrayList<>(Arrays.asList(R.drawable.splash_icon, R.drawable.splash_icon, R.drawable.splash_icon, R.drawable.splash_icon,
            R.drawable.splash_icon, R.drawable.splash_icon, R.drawable.splash_icon, R.drawable.splash_icon, R.drawable.splash_icon,
            R.drawable.splash_icon));
    ArrayList<String> nameList = new ArrayList(Arrays.asList("10", "11", "12", "13", "14", "15", "DD", "Divanshu", "Anshu", "Srivastava"));
    List<ProductByCategoryResponce> itemList = new ArrayList<>();
    private List<String> productId = new ArrayList<>();
    private RecyclerView recyclerView;
    private IApiClass iApiClass;

    public static ElectronicsFragment getElectronicsFragmentInstance(String categoryId) {
        Bundle args = new Bundle();
        args.putString("categoryId", categoryId);
        ElectronicsFragment fragment = new ElectronicsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_electronics, container, false);
        recyclerView = view.findViewById(R.id.erecyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(recyclerView.getContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        final CardViewAdapter cardViewAdapter = new CardViewAdapter(nameList, logos, itemList);
        recyclerView.setAdapter(cardViewAdapter);
        cardViewAdapter.setIcommunicator(this);

        iApiClass = AppController.retrofitProduct.create(IApiClass.class);
        iApiClass.getByCategory(getArguments().getString("categoryId")).enqueue(new Callback<List<ProductByCategoryResponce>>() {
            @Override
            public void onResponse(Call<List<ProductByCategoryResponce>> call, Response<List<ProductByCategoryResponce>> response) {
                if (response.isSuccessful()) {
                    Log.e("Response", response.body().toString());
                    productByCategoryResponces = response.body();
                    for (ProductByCategoryResponce productByCategoryResponce : productByCategoryResponces) {
                        productId.add(productByCategoryResponce.getProductId());
                    }
                    itemList.clear();
                    itemList.addAll(response.body());
                    cardViewAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<ProductByCategoryResponce>> call, Throwable t) {

            }
        });

        return view;
    }

    @Override
    public void navigate(int position) {
        Log.e("ProductId", productId.get(position));
        Intent intent = new Intent(getContext(), ProductPage.class);
        Log.e("Position", String.valueOf(position));
        intent.putExtra("ProductID", productId.get(position));
        startActivity(intent);
    }
}

