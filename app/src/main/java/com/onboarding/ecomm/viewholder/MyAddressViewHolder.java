package com.onboarding.ecomm.viewholder;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.onboarding.ecomm.OrderSummary;
import com.onboarding.ecomm.R;

public class MyAddressViewHolder extends RecyclerView.ViewHolder {
    private TextView address;
    private CardView cardView;

    public MyAddressViewHolder(@NonNull View itemView) {
        super(itemView);
        cardView=itemView.findViewById(R.id.CardAddress);
        address = itemView.findViewById(R.id.clientaddress);

    }

    public void bind(String clientAddress) {
        address.setText(clientAddress);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(cardView.getContext(),OrderSummary.class);
                intent.putExtra("Address",address.getText().toString());
                cardView.getContext().startActivity(intent);
            }
        });
    }

}
