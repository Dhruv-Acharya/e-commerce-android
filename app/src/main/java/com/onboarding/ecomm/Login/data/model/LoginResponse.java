package com.onboarding.ecomm.Login.data.model;

import com.google.gson.annotations.SerializedName;

//import javax.annotation.Generated;

//@Generated("com.robohorse.robopojogenerator")
public class LoginResponse {

    @SerializedName("password")
    private String password;

    @SerializedName("name")
    private String name;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
                        "password = '" + password + '\'' +
                        ",name = '" + name + '\'' +
                        "}";
    }
}