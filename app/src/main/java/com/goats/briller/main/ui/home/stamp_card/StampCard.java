package com.goats.briller.main.ui.home.stamp_card;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.goats.briller.R;
import com.goats.briller.main.Home;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StampCard extends AppCompatActivity {

    String habitTitleIntent;

    ImageView partnerIcon, habitIcon;
    TextView habitTitle;

    ImageButton backButton;
    EditText timeInput;
    ToggleButton alarmToggle;
    Button submitButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stamp_card_template);

        partnerIcon = findViewById(R.id.stampcard_partner_icon);
        habitIcon = findViewById(R.id.stampcard_habit_icon);
        habitTitle = findViewById(R.id.stampcard_habit_title);
        submitButton = findViewById(R.id.stampcard_submit_button);
        timeInput = findViewById(R.id.stampcard_time_input);
        alarmToggle = findViewById(R.id.stampcard_alarm_status);

        backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    File directory = new File(getApplicationContext().getFilesDir(), "StampCards");
                    File stampcards = new File(directory, "StampCards.json");

                    FileReader fileReader = new FileReader(stampcards);
                    BufferedReader bufferedReader = new BufferedReader(fileReader);
                    StringBuilder stringBuilder = new StringBuilder();
                    String line = bufferedReader.readLine();
                    while (line != null){
                        stringBuilder.append(line).append("\n");
                        line = bufferedReader.readLine();
                    }
                    bufferedReader.close();
                    fileReader.close();

                    String stampcardsData = stringBuilder.toString();

                    JSONObject stampcardsJSON  = new JSONObject(stampcardsData);

                    JSONObject stampcardToModify = stampcardsJSON.getJSONObject(habitTitle.getText().toString());
                    stampcardToModify.put("alarm", alarmToggle.isChecked());
                    stampcardToModify.put("started", true);
                    stampcardToModify.put("timer", Integer.parseInt(timeInput.getText().toString()));
                    stampcardToModify.put("habitStartTime", System.currentTimeMillis());

                    FileWriter writer = new FileWriter(stampcards);

                    JSONObject newStampcards = stampcardsJSON;

                    writer.append(newStampcards.toString());
                    writer.flush();
                    writer.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Toast.makeText(getApplicationContext(), "Habit stampcard created!", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getApplicationContext(), Home.class);
                startActivity(intent);
                finish();
            }
        });

        setUpScreen();
        setUpCard();
    }

    private void setUpScreen() {
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

            switch (onboardingDataJSON.get("PartnerChosen").toString()) {
                case "dog":
                    partnerIcon.setImageResource(R.drawable.onboarding_dog);
                case "cat":
                    partnerIcon.setImageResource(R.drawable.onboarding_cat);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void setUpCard() {
        habitTitleIntent = getIntent().getStringExtra("habitTitle");
        habitTitle.setText(habitTitleIntent);
        switch (habitTitleIntent) {
            case "Gym":
                habitIcon.setImageResource(R.drawable.habit_physique_gym);
                break;
            case "Run":
                habitIcon.setImageResource(R.drawable.habit_physique_run);
                break;
            case "Pushups":
                habitIcon.setImageResource(R.drawable.habit_physique_pushup);
                break;
            case "Squats":
                habitIcon.setImageResource(R.drawable.habit_physique_squat);
                break;
            case "Meditate":
                habitIcon.setImageResource(R.drawable.habit_mind_meditate);
                break;
            case "Read":
                habitIcon.setImageResource(R.drawable.habit_mind_read);
                break;
            case "Journal":
                habitIcon.setImageResource(R.drawable.habit_mind_journal);
                break;
            case "Study":
                habitIcon.setImageResource(R.drawable.habit_mind_study);
                break;
        }

    }
}
