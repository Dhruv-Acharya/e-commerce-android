package com.onboarding.ecomm.Login;

import com.onboarding.ecomm.Login.data.model.Request.LoginRequest;
import com.onboarding.ecomm.Login.data.model.Request.SignUpRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IApiClass {


    @POST("/customer/login")
    public Call<Void> logIn(@Body LoginRequest loginRequest);

    @POST("customer/add")
    public Call<Void> signUp(@Body SignUpRequest signUpRequest);


}
