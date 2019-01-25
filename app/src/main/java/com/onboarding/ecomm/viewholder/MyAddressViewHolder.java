package com.onboarding.ecomm.viewholder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.onboarding.ecomm.R;

public class MyAddressViewHolder extends RecyclerView.ViewHolder {
    private TextView address;

    public MyAddressViewHolder(@NonNull View itemView) {
        super(itemView);
        address = itemView.findViewById(R.id.clientaddress);
    }

    public void bind(String clientAddress) {
        address.setText(clientAddress);
    }

}
