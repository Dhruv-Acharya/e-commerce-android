package com.onboarding.ecomm.Model.Response;

//import javax.annotation.Generated;

import com.google.gson.annotations.SerializedName;

//@Generated("com.robohorse.robopojogenerator")
public class MerchantResponse {

    @SerializedName("qunatity")
    private int qunatity;

    @SerializedName("merchantId")
    private String merchantId;

    @SerializedName("price")
    private int price;

    @SerializedName("name")
    private String name;

    @SerializedName("rating")
    private double rating;

    @SerializedName("discount")
    private int discount;

    @SerializedName("emailId")
    private Object emailId;

    public int getQunatity() {
        return qunatity;
    }

    public void setQunatity(int qunatity) {
        this.qunatity = qunatity;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public Object getEmailId() {
        return emailId;
    }

    public void setEmailId(Object emailId) {
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        return
                "MerchantResponse{" +
                        "qunatity = '" + qunatity + '\'' +
                        ",merchantId = '" + merchantId + '\'' +
                        ",price = '" + price + '\'' +
                        ",name = '" + name + '\'' +
                        ",rating = '" + rating + '\'' +
                        ",discount = '" + discount + '\'' +
                        ",emailId = '" + emailId + '\'' +
                        "}";
    }
}