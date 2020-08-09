package com.goats.briller.main.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;

import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.goats.briller.R;
import com.goats.briller.main.Home;
import com.goats.briller.onboarding.OnboardingSelectPartnerScreen;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;


public class HabitTimer extends AppCompatActivity {
    private TextView countdownText;
    private Button go_back_home;


    CountDownTimer countDownTimer;

    long timeLeftinMilliseconds;
    boolean timerRunning;

    String habitTitle;


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.habit_timer);

        timeLeftinMilliseconds = getIntent().getIntExtra("timer", 0) * 60000;
        countdownText = findViewById(R.id.countdown_text);

        habitTitle = getIntent().getStringExtra("habitTitle");

        start();

    }

    public void start() {
        countDownTimer = new CountDownTimer(timeLeftinMilliseconds, 1000) {
            @Override
            public void onTick(long l) {
                timeLeftinMilliseconds = l;
                updateTimer();
            }

            @Override
            public void onFinish() {
                updateStampcard(1);
            }
        }.start();

    timerRunning = true;
    }

    public void stop() {

        countDownTimer.cancel();

    }

    public void updateTimer(){
        int minutes = (int) timeLeftinMilliseconds / 60000;
        int seconds = (int) timeLeftinMilliseconds % 60000 / 1000;

        String timeLeftText;

        timeLeftText = "" + minutes;
        timeLeftText += ":";

        if (seconds < 10) timeLeftText += "0";
        timeLeftText += seconds;

        countdownText.setText(timeLeftText);

        if (timeLeftText.equals("0:00")) {

            countdownText = findViewById(R.id.countdown_text);
            countdownText.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.textview_big_0_size));
            countdownText.setText("Great Work!");


            go_back_home = findViewById(R.id.timer_to_back_home);
            go_back_home.setVisibility(View.VISIBLE);

            go_back_home.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), Home.class);

                    startActivity(intent);
                }
            });
        }

    }


    public void onPause() {

        super.onPause();

        // 1. Turn timer off
        // 2. Update StampCard to score of -1
        timerRunning = false;
        stop();

    }

    public void onResume() {

        super.onResume();


        if (!timerRunning) {

            countdownText = findViewById(R.id.countdown_text);
            countdownText.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.textview_big_0_size));
            countdownText.setText("You Failed!");

            updateStampcard(-1);
        }
    }


    public void onRestart() {

        super.onRestart();

    }

    public void updateStampcard(int completed) {

        long currentTime = System.currentTimeMillis();
        long timeToCheck;

        try {
            File directory = new File(getApplicationContext().getFilesDir(), "StampCards");
            File stampcards = new File(directory, "StampCards.json");
            FileReader fileReader = new FileReader(stampcards);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder stringBuilder = new StringBuilder();
            String line = bufferedReader.readLine();
            while (line != null) {
                stringBuilder.append(line).append("\n");
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();

            String stampcardsData = stringBuilder.toString();

            JSONObject stampcardsJSON = new JSONObject(stampcardsData);

            JSONObject stampcardToCheck = stampcardsJSON.getJSONObject(habitTitle);

            timeToCheck = (long) stampcardToCheck.get("habitStartTime");
            int timeDifferenceInHours = (int) ((currentTime - timeToCheck) / 1000 / 60 / 60);
            String dayToUpdate = String.valueOf(timeDifferenceInHours);

            stampcardToCheck.put(dayToUpdate, completed);

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
    }

}
