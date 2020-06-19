package com.goats.briller;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class LandingScreen extends AppCompatActivity {

    // Guest checkout
    private ImageButton guestCheckOutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_screen);

        // Designate guest checkout button
        guestCheckOutButton = (ImageButton) findViewById(R.id.guestCheckOut);
        guestCheckOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenSignInScreen();
            }
        });
    }

    public void OpenSignInScreen() {
        Intent signInIntent = new Intent(this, SignInScreen.class);
        startActivity(signInIntent);
    }

}
