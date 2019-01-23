package com.onboarding.ecomm.Login;

import com.onboarding.ecomm.Model.Request.LoginRequest;
import com.onboarding.ecomm.Model.Request.SignUpRequest;
import com.onboarding.ecomm.Model.Response.MerchantResponse;
import com.onboarding.ecomm.Model.Response.OrderItemResponse;
import com.onboarding.ecomm.Model.Response.ProductResponse;
import com.onboarding.ecomm.Model.Response.SearchResponse;
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

    @GET("/product/get/{product_id}")
    public Call<ProductResponse> getProductReponse(@Path("product_id")String product_id);

    @GET("product/{name}")
    public  Call<SearchResponse> getSearchResponse(@Path("name")String name);

    @GET("/category/getAll")
    public Call<List<Category> >getAllCategory();

    @GET("/product/getByCategory/{categoryId}")
    public Call<List<ProductByCategoryResponce>> getByCategory(@Path("categoryId") String categoryId);

    @GET("/product/getMerchants/{productId}")
    public Call<List<MerchantResponse>> getMerchants(@Path("productId")String productId);

    @GET("/order/get/{order_id}")
    public Call<List<OrderItemResponse>>getOrderItems(@Path("order_id")String order_id);
}
