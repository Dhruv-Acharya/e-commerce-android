package com.onboarding.ecomm.Login.data.model.Response;

//import javax.annotation.Generated;

import com.google.gson.annotations.SerializedName;

//@Generated("com.robohorse.robopojogenerator")
public class ProductResponse {

    @SerializedName("quantity")
    private String quantity;

    @SerializedName("usp")
    private String usp;

    @SerializedName("productId")
    private String productId;

    @SerializedName("merchantId")
    private String merchantId;

    @SerializedName("price")
    private String price;

    @SerializedName("imageUrl")
    private String imageUrl;

    @SerializedName("rating")
    private String rating;

    @SerializedName("name")
    private String name;

    @SerializedName("discount")
    private String discount;

    @SerializedName("description")
    private String description;

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUsp() {
        return usp;
    }

    public void setUsp(String usp) {
        this.usp = usp;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return
                "ProductResponse{" +
                        "quantity = '" + quantity + '\'' +
                        ",usp = '" + usp + '\'' +
                        ",productId = '" + productId + '\'' +
                        ",merchantId = '" + merchantId + '\'' +
                        ",price = '" + price + '\'' +
                        ",imageUrl = '" + imageUrl + '\'' +
                        ",rating = '" + rating + '\'' +
                        ",name = '" + name + '\'' +
                        ",discount = '" + discount + '\'' +
                        ",description = '" + description + '\'' +
                        "}";
    }
}