package com.example.designer2.moviesapp.uisViews;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.example.designer2.moviesapp.R;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
    private static String TAG = SplashScreen.class.getSimpleName();
    private int SPLASH_TIMER = 2500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent streamPlayerHome = new Intent(SplashScreen.this,WeolcomeScreen.class);
                startActivity(streamPlayerHome);
                finish();
            }
        }, SPLASH_TIMER);
    }
}






