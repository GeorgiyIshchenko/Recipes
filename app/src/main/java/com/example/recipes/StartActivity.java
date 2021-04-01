package com.example.recipes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.FrameLayout;

import com.example.recipes.auth_fragments.AuthFragment;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        //Связываемся с разметкой SplashScreen
        FrameLayout splashScreen = findViewById(R.id.splash_screen);
        //Задаем таймер для перехода на фрагмент
        CountDownTimer timer = new CountDownTimer(2000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                splashScreen.setVisibility(View.INVISIBLE);
                getSupportFragmentManager().beginTransaction().replace(R.id.activity_start, new AuthFragment()).commit();
            }
        }.start();
    }
}