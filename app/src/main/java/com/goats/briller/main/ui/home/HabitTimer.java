package com.goats.briller.main.ui.home;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;

import android.widget.TextView;

import com.goats.briller.R;


public class HabitTimer extends AppCompatActivity {
    private TextView countdownText;

    CountDownTimer countDownTimer;

    long timeLeftinMilliseconds;
    boolean timerRunning;

    protected void onCreate(Bundle savedInstanceState) {

        System.out.println("onCreate");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.habit_timer);

        timeLeftinMilliseconds = getIntent().getIntExtra("timer", 0) * 60000;
        countdownText = findViewById(R.id.countdown_text);

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

            }
        }.start();

    timerRunning = true;

    }

    public void stop() {

        countDownTimer.cancel();

    }

    public void updateTimer(){
        int minutes = (int) timeLeftinMilliseconds/60000;
        int seconds = (int) timeLeftinMilliseconds % 60000 / 1000;

        String timeLeftText;

        timeLeftText = "" + minutes;
        timeLeftText += ":";

        if (seconds < 10) timeLeftText += "0";
        timeLeftText += seconds;

        countdownText.setText(timeLeftText);
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

            countdownText.setTextSize(50);

            countdownText.setText("You Failed!");


        }


    }


    public void onRestart() {

        super.onRestart();



    }

}
