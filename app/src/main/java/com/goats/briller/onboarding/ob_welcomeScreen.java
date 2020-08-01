package com.goats.briller.onboarding;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.goats.briller.R;
import com.goats.briller.main.home;



public class ob_welcomeScreen extends AppCompatActivity {

    ImageButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("we got to this activity");
        setContentView(R.layout.ob_welcome_screen);
        System.out.println("checkpoint 1");
        button = findViewById(R.id.welcome_screen_button);
        System.out.println("checkpoint 2");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ob_SelectPartnerScreen.class);

                startActivity(intent);
            }
        });


    }



}
