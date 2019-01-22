package com.onboarding.ecomm.Login;

import com.onboarding.ecomm.Model.Request.LoginRequest;
import com.onboarding.ecomm.Model.Request.SignUpRequest;
import com.onboarding.ecomm.Model.Response.Category;
import com.onboarding.ecomm.Model.Response.ProductByCategoryResponce;

import java.util.List;

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

    @GET("/category/getAll")
    public Call<List<Category>> getAllCategory();

    @GET("/product/getByCategory/{categoryId}")
    public Call<List<ProductByCategoryResponce>> getByCategory(@Path("categoryId") String categoryId);
}
