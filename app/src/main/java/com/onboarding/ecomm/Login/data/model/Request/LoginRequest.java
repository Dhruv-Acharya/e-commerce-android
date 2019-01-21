package com.onboarding.ecomm.Login.data.model.Request;

import com.google.gson.annotations.SerializedName;

//import javax.annotation.Generated;

//@Generated("com.robohorse.robopojogenerator")
public class LoginRequest {

    @SerializedName("password")
    private String password;

    @SerializedName("email")
    private String email;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return
                "LoginRequest{" +
                        "password = '" + password + '\'' +
                        ",email = '" + email + '\'' +
                        "}";
    }
}