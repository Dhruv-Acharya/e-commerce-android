package com.onboarding.ecomm.Login;

import com.onboarding.ecomm.Model.Request.LoginRequest;
import com.onboarding.ecomm.Model.Request.ProductResponse;
import com.onboarding.ecomm.Model.Request.SignUpRequest;
import com.onboarding.ecomm.Model.Response.SearchResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface IApiClass {


    @POST("/customer/login")
    public Call<Void> logIn(@Body LoginRequest loginRequest);

    @POST("customer/add")
    public Call<Void> signUp(@Body SignUpRequest signUpRequest);

    @GET("/product/get/{product_id}/{merchant_id}")
    public Call<ProductResponse> getProductReponse(@Path("product_id")String product_id, @Path("merchant_id")String merchant_id );

    @GET("product/{name}")
    public  Call<SearchResponse> getSearchResponse(@Path("name")String name);


}
