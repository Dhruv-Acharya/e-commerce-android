package com.onboarding.ecomm.Adapters;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.onboarding.ecomm.R;

import java.util.ArrayList;
import java.util.List;

public class CardViewAdapter extends RecyclerView.Adapter {
    List nameList;

   public CardViewAdapter(List nameList) {
        this.nameList = nameList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_item, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
       Log.i("Print",(String)nameList.get(i));
        ((MyViewHolder)viewHolder).name.setText((String) nameList.get(i));
    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }
}
    class MyViewHolder extends RecyclerView.ViewHolder {
    TextView name;
    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        name=itemView.findViewById(R.id.name);
    }
    public void bind(String dataString){
        name.setText(dataString);
    }
}




