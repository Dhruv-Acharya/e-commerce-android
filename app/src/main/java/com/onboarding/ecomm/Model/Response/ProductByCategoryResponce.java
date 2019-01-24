package com.onboarding.ecomm.Model.Response;

import com.google.gson.annotations.SerializedName;


public class ProductByCategoryResponce {

    @SerializedName("usp")
    private String usp;

    @SerializedName("productId")
    private String productId;

    @SerializedName("imageUrl")
    private String imageUrl;

    @SerializedName("description")
    private String description;

    @SerializedName("category")
    private Category category;

    @SerializedName("priceRange")
    private String priceRange;

    @SerializedName("productName")
    private String productName;

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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return
                "ProductByCategoryResponce{" +
                        "usp = '" + usp + '\'' +
                        ",productId = '" + productId + '\'' +
                        ",imageUrl = '" + imageUrl + '\'' +
                        ",description = '" + description + '\'' +
                        ",category = '" + category + '\'' +
                        ",priceRange = '" + priceRange + '\'' +
                        ",productName = '" + productName + '\'' +
                        "}";
    }
}