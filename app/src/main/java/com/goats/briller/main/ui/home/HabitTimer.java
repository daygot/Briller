package com.goats.briller.main.ui.home;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.goats.briller.R;

public class HabitTimer extends AppCompatActivity {
    private TextView countdownText;

    private CountDownTimer countDownTimer;

    private long timeLeftinMilliseconds = 600000; // 10 mins in ms.
    private boolean timerRunning;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.habit_timer);

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


}
