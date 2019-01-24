package com.onboarding.ecomm.session;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.onboarding.ecomm.Login.LoginPage;

import java.util.HashMap;

public class SessionManager {

    public static final String CUSTOMER_ID = "CustomerId";
    private static final String PREF_NAME = "TokenId";
    private static final String IS_LOGIN = "IsLoggedIn";
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;
    int PRIVATE_MODE = 0;

    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    public void createLoginSession(String customerId) {

        editor.putString(CUSTOMER_ID, customerId);
        editor.putBoolean(IS_LOGIN, true);

        editor.commit();
    }

    public void checkLogin(Context context) {

        if (!this.isLoggedIn()) {
            Intent i = new Intent(context, LoginPage.class);

            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            context.startActivity(i);
        }

    }

    public HashMap<String, String> getUserDetails() {

        HashMap<String, String> user = new HashMap<String, String>();

        user.put(CUSTOMER_ID, sharedPreferences.getString(CUSTOMER_ID, null));

        return user;
    }

    public void logoutUser(Context context) {

        editor.clear();
        editor.commit();

        Intent i = new Intent(context, LoginPage.class);

        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        context.startActivity(i);
    }


    public boolean isLoggedIn() {
        return sharedPreferences.getBoolean(IS_LOGIN, false);
    }


}
