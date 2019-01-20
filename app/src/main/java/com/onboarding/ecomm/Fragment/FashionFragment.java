package com.onboarding.ecomm.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.onboarding.ecomm.Adapters.CardViewAdapter;
import com.onboarding.ecomm.R;

import java.util.ArrayList;
import java.util.Arrays;

import static com.onboarding.ecomm.R.drawable;
import static com.onboarding.ecomm.R.layout;

public class FashionFragment extends Fragment {
    ArrayList logos = new ArrayList<>(Arrays.asList(drawable.splash_icon, drawable.splash_icon, drawable.splash_icon, drawable.splash_icon,
            drawable.splash_icon, drawable.splash_icon, drawable.splash_icon, drawable.splash_icon, drawable.splash_icon,
            drawable.splash_icon));
    ArrayList<String> nameList = new ArrayList(Arrays.asList("1", "2", "3", "4", "5", "6", "DD", "Divanshu", "Anshu", "Srivastava"));
    private RecyclerView recyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(layout.fragment_fashion, container, false);
        recyclerView = view.findViewById(R.id.frecyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(recyclerView.getContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);
        CardViewAdapter cardViewAdapter = new CardViewAdapter(nameList, logos);
        recyclerView.setAdapter(cardViewAdapter);
        return view;
    }


}
