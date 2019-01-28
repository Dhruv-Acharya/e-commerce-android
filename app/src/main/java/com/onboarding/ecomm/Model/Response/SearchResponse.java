package com.onboarding.ecomm.Model.Response;

//import javax.annotation.Generated;

import com.google.gson.annotations.SerializedName;

//@Generated("com.robohorse.robopojogenerator")
public class SearchResponse {

    @SerializedName("usp")
    private String usp;

    @SerializedName("productId")
    private String productId;

    @SerializedName("ratingCounter")
    private int ratingCounter;

    @SerializedName("imageUrl")
    private String imageUrl;

    @SerializedName("name")
    private String name;

    @SerializedName("rating")
    private int rating;

    @SerializedName("description")
    private String description;

    @SerializedName("priceLowest")
    private String priceLowest;

    @SerializedName("priceHighest")
    private String priceHighest;

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

    public int getRatingCounter() {
        return ratingCounter;
    }

    public void setRatingCounter(int ratingCounter) {
        this.ratingCounter = ratingCounter;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriceLowest() {
        return priceLowest;
    }

    public void setPriceLowest(String priceLowest) {
        this.priceLowest = priceLowest;
    }

    public String getPriceHighest() {
        return priceHighest;
    }

    public void setPriceHighest(String priceHighest) {
        this.priceHighest = priceHighest;
    }

    @Override
    public String toString() {
        return "SearchResponse{" +
                "usp='" + usp + '\'' +
                ", productId='" + productId + '\'' +
                ", ratingCounter=" + ratingCounter +
                ", imageUrl='" + imageUrl + '\'' +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                ", priceLowest='" + priceLowest + '\'' +
                ", priceHighest='" + priceHighest + '\'' +
                '}';
    }
}