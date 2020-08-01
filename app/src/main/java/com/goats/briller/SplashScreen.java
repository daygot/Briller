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

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        // onboarding check
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
                Intent intent = new Intent(this, Home.class);
                startActivity(intent);
                finish();
            }
        } catch (FileNotFoundException e) {
            Intent intent = new Intent(this, OnboardingWelcomeScreen.class);
            startActivity(intent);
            finish();
        } catch (IOException e) {
            System.out.println("IO");
            e.printStackTrace();
        } catch (JSONException e) {
            System.out.println("JSON");
            e.printStackTrace();
        }
    }
}
