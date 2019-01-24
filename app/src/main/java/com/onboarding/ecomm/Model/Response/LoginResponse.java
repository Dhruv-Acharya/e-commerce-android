package com.onboarding.ecomm.Model.Response;


import com.google.gson.annotations.SerializedName;


public class LoginResponse {

    @SerializedName("customerId")
    private String customerId;

    @SerializedName("name")
    private String name;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return
                "LoginResponse{" +
                        "customerId = '" + customerId + '\'' +
                        ",name = '" + name + '\'' +
                        "}";
    }
}