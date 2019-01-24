package com.onboarding.ecomm.Model.Response;


import com.google.gson.annotations.SerializedName;

public class CartResponse {

    @SerializedName("quantity")
    private int quantity;

    @SerializedName("price")
    private int price;

    @SerializedName("imageUrl")
    private String imageUrl;

    @SerializedName("product_id")
    private String productId;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("merchant_id")
    private String merchantId;

    @SerializedName("merchantName")
    private String merchantName;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
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
                "CartResponse{" +
                        "quantity = '" + quantity + '\'' +
                        ",price = '" + price + '\'' +
                        ",imageUrl = '" + imageUrl + '\'' +
                        ",product_id = '" + productId + '\'' +
                        ",name = '" + name + '\'' +
                        ",description = '" + description + '\'' +
                        ",merchant_id = '" + merchantId + '\'' +
                        ",merchantName = '" + merchantName + '\'' +
                        "}";
    }
}