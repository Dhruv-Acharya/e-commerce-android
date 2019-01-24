package com.onboarding.ecomm.Model.Request;


import com.google.gson.annotations.SerializedName;


public class AddToCartRequest {

    @SerializedName("quantity")
    private int quantity;

    @SerializedName("productId")
    private String productId;

    @SerializedName("merchantId")
    private String merchantId;

    @SerializedName("customerId")
    private String customerId;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
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
                "AddToCartRequest{" +
                        "quantity = '" + quantity + '\'' +
                        ",productId = '" + productId + '\'' +
                        ",merchantId = '" + merchantId + '\'' +
                        ",customerId = '" + customerId + '\'' +
                        "}";
    }
}