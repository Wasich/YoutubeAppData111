package com.example.designer2.moviesapp.uisViews;

import android.os.Bundle;

import com.example.designer2.moviesapp.R;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
    private static String TAG = SplashScreen.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
    }

}
