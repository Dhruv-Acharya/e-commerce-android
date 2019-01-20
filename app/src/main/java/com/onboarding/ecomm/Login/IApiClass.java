package com.onboarding.ecomm.Login;

import com.onboarding.ecomm.Login.data.model.LoginResponse;
import com.onboarding.ecomm.Login.data.model.SignUpResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IApiClass {


    @POST("login")
    public Call<LoginResponse> logIn(@Body LoginResponse loginResponse);

    @POST("signup")
    public Call<SignUpResponse> signUp(@Body SignUpResponse signUpResponse);

}
