package com.onboarding.ecomm.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.onboarding.ecomm.Model.Response.AddressResponse;
import com.onboarding.ecomm.R;
import com.onboarding.ecomm.viewholder.MyAddressViewHolder;

import java.util.List;

public class AddressAdapter extends RecyclerView.Adapter {
    private List<AddressResponse> addressList;

    public AddressAdapter(List<AddressResponse> addressList) {
        this.addressList = addressList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_address, viewGroup, false);
        return new MyAddressViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((MyAddressViewHolder) viewHolder).bind(addressList.get(i).getAddress());

    }

    @Override
    public int getItemCount() {
        return addressList.size();
    }
}
