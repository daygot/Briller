package com.goats.briller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.goats.briller.main.Home;
import com.goats.briller.onboarding.OnboardingWelcomeScreen;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        // onboarding check

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    File directory = new File(getApplicationContext().getFilesDir(), "Onboarding_Info");
                    File onboardingInfo = new File(directory, "Pet_Data.json");

                    FileReader fileReader = new FileReader(onboardingInfo);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    StringBuilder stringBuilder = new StringBuilder();
                    String line = bufferedReader.readLine();
                    while (line != null){
                        stringBuilder.append(line).append("\n");
                        line = bufferedReader.readLine();
                    }
                    bufferedReader.close();
                    fileReader.close();

                    String onboardingData = stringBuilder.toString();
                    JSONObject onboardingDataJSON  = new JSONObject(onboardingData);

                    if (onboardingDataJSON.get("PartnerChosen").equals("Y")) {
                        Intent intent = new Intent(getApplicationContext(), Home.class);
                        startActivity(intent);
                        finish();
                    }
                } catch (FileNotFoundException e) {
                    Intent intent = new Intent(getApplicationContext(), OnboardingWelcomeScreen.class);
                    startActivity(intent);
                    finish();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, 2000);
    }
}
