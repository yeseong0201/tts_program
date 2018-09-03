package com.jinhyeokfang.appjam.Activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.jinhyeokfang.appjam.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ImageView backgroundImageView = findViewById(R.id.imageView);
        backgroundImageView.setImageBitmap(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.splashbackgroundimage));
        backgroundImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        Handler hd = new Handler();
        hd.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent ShowMainIntent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(ShowMainIntent);
                finish();
            }
        }, 3 * 1000);
    }
}