package com.vedant.fragdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import gr.net.maroulis.library.EasySplashScreen;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EasySplashScreen config = new EasySplashScreen(Splash.this)
                .withFullScreen()
                .withTargetActivity(login.class)
                .withSplashTimeOut(4000)
                .withBackgroundColor(Color.parseColor("#1a1b29"))
                .withLogo(R.mipmap.ic_launcher_round)
                .withAfterLogoText("ShopZone");

        config.getAfterLogoTextView().setTextColor(Color.WHITE);
        config.getAfterLogoTextView().setTextSize(25);
        View easysplash = config.create();
        setContentView(easysplash);
    }
}