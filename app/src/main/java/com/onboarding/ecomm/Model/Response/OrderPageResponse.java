package com.onboarding.ecomm.Model.Response;

import com.google.gson.annotations.SerializedName;

public class OrderPageResponse {

    @SerializedName("date")
    private String date;

    @SerializedName("amount")
    private int amount;

    @SerializedName("orderId")
    private String orderId;

    @SerializedName("customerId")
    private String customerId;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return
                "OrderPageResponse{" +
                        "date = '" + date + '\'' +
                        ",amount = '" + amount + '\'' +
                        ",orderId = '" + orderId + '\'' +
                        ",customerId = '" + customerId + '\'' +
                        "}";
    }
}