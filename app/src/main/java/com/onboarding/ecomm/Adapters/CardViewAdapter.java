package com.onboarding.ecomm.Adapters;


import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
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
    Icommunicator icommunicator;

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
    public void onBindViewHolder(@NonNull  RecyclerView.ViewHolder viewHolder, int i) {
        ((MyViewHolder) viewHolder).bind((String) nameList.get(i), (int) images.get(i), icommunicator);
    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }

    public void setIcommunicator(Icommunicator icommunicator) {
        this.icommunicator = icommunicator;
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

    void bind(String item, int imageItem, final Icommunicator icommunicator) {
        name.setText(item);
        image.setImageResource(imageItem);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icommunicator.navigate(getAdapterPosition());
            }
        });
    }

}




