package com.onboarding.ecomm.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.onboarding.ecomm.Adapters.CardViewAdapter;
import com.onboarding.ecomm.Adapters.Icommunicator;
import com.onboarding.ecomm.Main.MainActivity;
import com.onboarding.ecomm.ProductDetails.ProductPage;
import com.onboarding.ecomm.R;

import java.util.ArrayList;
import java.util.Arrays;

public class BBPFragment extends Fragment implements Icommunicator{
    ArrayList logos = new ArrayList<>(Arrays.asList(R.drawable.splash_icon, R.drawable.splash_icon, R.drawable.splash_icon, R.drawable.splash_icon,
            R.drawable.splash_icon, R.drawable.splash_icon, R.drawable.splash_icon, R.drawable.splash_icon, R.drawable.splash_icon,
            R.drawable.splash_icon));
    ArrayList<String> nameList = new ArrayList(Arrays.asList("4", "5", "6", "7", "8", "9", "DD", "Divanshu", "Anshu", "Srivastava"));
    private RecyclerView recyclerView;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bbp, container, false);
        recyclerView = view.findViewById(R.id.bbprecyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(recyclerView.getContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        CardViewAdapter cardViewAdapter = new CardViewAdapter(nameList, logos);
        recyclerView.setAdapter(cardViewAdapter);
        cardViewAdapter.setIcommunicator(this);
        return view;
    }


    @Override
    public void navigate(int position) {
    Intent intent=new Intent(getContext(),ProductPage.class);
    startActivity(intent);

    }
}

