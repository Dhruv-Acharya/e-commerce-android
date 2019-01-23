package com.onboarding.ecomm.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.onboarding.ecomm.Model.Response.SearchResponse;
import com.onboarding.ecomm.R;
import com.onboarding.ecomm.viewholder.MySearchViewHolder;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter {

    List<SearchResponse> searchList;

    public SearchAdapter(List<SearchResponse> searchList) {
        this.searchList = searchList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.search_card, viewGroup, false);
        return new MySearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((MySearchViewHolder) viewHolder).bind(searchList.get(i).getName(),searchList.get(i).getImageUrl());
    }

    @Override
    public int getItemCount() {
        return searchList.size();
    }


}


