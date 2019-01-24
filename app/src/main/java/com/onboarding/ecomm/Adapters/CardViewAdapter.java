package com.onboarding.ecomm.Adapters;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.onboarding.ecomm.Model.Response.ProductByCategoryResponce;
import com.onboarding.ecomm.R;

import java.util.ArrayList;
import java.util.List;

public class CardViewAdapter extends RecyclerView.Adapter {

    ArrayList images, nameList;
    Icommunicator icommunicator;
    List<ProductByCategoryResponce> productList;

    public CardViewAdapter(ArrayList nameList, ArrayList images, List<ProductByCategoryResponce> productList) {
        this.nameList = nameList;
        this.images = images;
        this.productList = productList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_item, viewGroup, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((MyViewHolder) viewHolder).bind(productList.get(i).getProductName(), productList.get(i).getImageUrl(), icommunicator);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public void setIcommunicator(Icommunicator icommunicator) {
        this.icommunicator = icommunicator;
    }


}

class MyViewHolder extends RecyclerView.ViewHolder {
    TextView name;
    TextView price;
    ImageView image;

    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        name = itemView.findViewById(R.id.name);
        image = itemView.findViewById(R.id.cardimage);
        price = itemView.findViewById(R.id.price);
    }

    void bind(String item, String imageUrl, final Icommunicator icommunicator) {
        name.setText(item);
        // use Glide
        Glide.with(image.getContext()).load(imageUrl).into(image);
        //image.setImageResource(imageItem);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                icommunicator.navigate(getAdapterPosition());
            }
        });
    }

}




