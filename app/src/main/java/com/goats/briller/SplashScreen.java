package com.goats.briller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.goats.briller.main.home;
import com.goats.briller.onboarding.OnboardingInstruction;
import com.goats.briller.onboarding.ob_welcomeScreen;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

//        Intent intent = new Intent(this, OnboardingInstruction.class);

        System.out.println("checkpoint 1");

        Intent intent = new Intent(this, ob_welcomeScreen.class);

        System.out.println("checkpoint 2");

        startActivity(intent);

        System.out.println("checkpoint 3");

        finish();

        System.out.println("checkpoint 4");
    }
}
