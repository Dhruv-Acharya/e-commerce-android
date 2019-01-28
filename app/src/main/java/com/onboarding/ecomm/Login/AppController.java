package com.onboarding.ecomm.Login;

import android.app.Application;

import com.onboarding.ecomm.session.SessionManager;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AppController extends Application {
    public static Retrofit retrofit = null;
    public static Retrofit retrofitProduct = null;
    public static Retrofit retrofitOrderItem = null;
    public static Retrofit retrofitSearchItem = null;
    public static int quantityInCart=0;

    @Override
    public void onCreate() {
        super.onCreate();

        if (null == retrofit) {

            OkHttpClient client = new OkHttpClient.Builder().build();

            retrofit = new Retrofit.Builder()
                    .baseUrl("https://customer-lelo.herokuapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();

            SessionManager s  = new SessionManager(this);


        }

        if (null == retrofitProduct) {

            OkHttpClient client = new OkHttpClient.Builder().build();

            retrofitProduct = new Retrofit.Builder()
                    .baseUrl("https://product-lelo.herokuapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();

        }


        if (null == retrofitOrderItem) {

            OkHttpClient client = new OkHttpClient.Builder().build();

            retrofitOrderItem = new Retrofit.Builder()
                    .baseUrl("https://order-lelo.herokuapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();

        }

        if (null == retrofitSearchItem) {

            OkHttpClient client = new OkHttpClient.Builder().build();

            retrofitSearchItem = new Retrofit.Builder()
                    .baseUrl("http://26f79b42.ngrok.io/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();

        }



    }


}
