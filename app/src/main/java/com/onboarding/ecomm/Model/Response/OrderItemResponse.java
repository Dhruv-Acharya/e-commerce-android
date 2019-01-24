package com.onboarding.ecomm.Model.Response;


import com.google.gson.annotations.SerializedName;

public class OrderItemResponse {

    @SerializedName("productImageUrl")
    private String productImageUrl;

    @SerializedName("productQuantity")
    private int productQuantity;

    @SerializedName("productId")
    private String productId;

    @SerializedName("merchantId")
    private String merchantId;

    @SerializedName("productDescription")
    private String productDescription;

    @SerializedName("productName")
    private String productName;

    @SerializedName("productPrice")
    private int productPrice;

    @SerializedName("merchantName")
    private String merchantName;

    public String getProductImageUrl() {
        return productImageUrl;
    }

    public void setProductImageUrl(String productImageUrl) {
        this.productImageUrl = productImageUrl;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
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

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    @Override
    public String toString() {
        return
                "OrderItemResponse{" +
                        "productImageUrl = '" + productImageUrl + '\'' +
                        ",productQuantity = '" + productQuantity + '\'' +
                        ",productId = '" + productId + '\'' +
                        ",merchantId = '" + merchantId + '\'' +
                        ",productDescription = '" + productDescription + '\'' +
                        ",productName = '" + productName + '\'' +
                        ",productPrice = '" + productPrice + '\'' +
                        ",merchantName = '" + merchantName + '\'' +
                        "}";
    }
}