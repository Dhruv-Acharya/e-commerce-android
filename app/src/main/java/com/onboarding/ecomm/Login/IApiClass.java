package com.onboarding.ecomm.Login;

import com.onboarding.ecomm.Main.CartListActivity;
import com.onboarding.ecomm.Model.Request.LoginRequest;
import com.onboarding.ecomm.Model.Request.SignUpRequest;
import com.onboarding.ecomm.Model.Response.CartResponse;
import com.onboarding.ecomm.Model.Response.LoginResponse;
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
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface IApiClass {


    @POST("/customer/login")
    public Call<LoginResponse> logIn(@Body LoginRequest loginRequest);

    @POST("/customer/add")
    public Call<Void> signUp(@Body SignUpRequest signUpRequest);

    @POST("cart/{customerId}/{productId}/{merchantId}")
    public Call<Void> addToCart(@Path("customerId")String customerId,@Path("productId")String productId, @Path("merchantId")String merchantId);

    @PUT("/cart/update/{customerId}/{productId}/{merchantId}")
    public Call<Void> updateToCart(@Path("customerId")String customerId,@Path("productId")String productId, @Path("merchantId")String merchantId);

    @GET("/product/get/{product_id}")
    public Call<ProductResponse> getProductReponse(@Path("product_id")String product_id);

    @GET("/product/{name}")
    public  Call<SearchResponse> getSearchResponse(@Path("name")String name);

    @GET("/category/getAll")
    public Call<List<Category> >getAllCategory();

    @GET("/product/getByCategory/{categoryId}")
    public Call<List<ProductByCategoryResponce>> getByCategory(@Path("categoryId") String categoryId);

    @GET("/product/getMerchants/{productId}")
    public Call<List<MerchantResponse>> getMerchants(@Path("productId")String productId);

    @GET("/order/get/{order_id}")
    public Call<List<OrderItemResponse>>getOrderItems(@Path("order_id")String order_id);

    @GET("/cart/{customerId}")
    public Call<List<CartResponse>>getCartItems(@Path("customerId")String customerId);
}
