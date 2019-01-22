package com.onboarding.ecomm.Main;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.onboarding.ecomm.R;

public class SplashScreenActivity extends AppCompatActivity implements Animation.AnimationListener {

    Animation animFadeIn;
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);

        } else {
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
            animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),
                    R.anim.animation_fade_in);
            animFadeIn.setAnimationListener(this);
            constraintLayout = findViewById(R.id.layout_constraint);
            constraintLayout.setVisibility(View.VISIBLE);
            constraintLayout.startAnimation(animFadeIn);
        }
    }


    @Override
    public void onBackPressed() {
        this.finish();
        super.onBackPressed();
    }

    @Override
    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        Intent i = new Intent(SplashScreenActivity.this, WelcomeActivity.class);
        startActivity(i);
        this.finish();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
    }
}

