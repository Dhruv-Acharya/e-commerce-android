package com.onboarding.ecomm.Adapters;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.onboarding.ecomm.R;

import java.util.ArrayList;

public class CardViewAdapter extends RecyclerView.Adapter {

    ArrayList images, nameList;

    public CardViewAdapter(ArrayList nameList, ArrayList images) {
        this.nameList = nameList;
        this.images = images;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_item, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((MyViewHolder) viewHolder).name.setText((String) nameList.get(i));
        ((MyViewHolder) viewHolder).image.setImageResource((int) images.get(i));
    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }
}

class MyViewHolder extends RecyclerView.ViewHolder {
    TextView name;
    ImageView image;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        image = itemView.findViewById(R.id.cardimage);
    }

    public void bind(String dataString) {
        name.setText(dataString);
    }
}




