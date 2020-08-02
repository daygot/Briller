package com.goats.briller.main.ui.home.habit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.goats.briller.R;
import com.goats.briller.main.ui.home.stamp_card.StampCard;

public class HabitMind extends AppCompatActivity implements View.OnClickListener {

    Intent intent;
    ImageButton backButton, meditate, read, journal, study;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.habit_physique_choose);
        backButton = findViewById(R.id.back_button);
        meditate = findViewById(R.id.habit_gym_button);
        read = findViewById(R.id.habit_run_button);
        journal = findViewById(R.id.habit_pushup_button);
        study = findViewById(R.id.habit_squat_button);

        backButton.setOnClickListener(this);
        meditate.setOnClickListener(this);
        read.setOnClickListener(this);
        journal.setOnClickListener(this);
        study.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()) {
            case R.id.back_button:
                onBackPressed();
                break;

            case R.id.habit_meditate_button:
                break;

            case R.id.habit_read_button:
                break;

            case R.id.habit_journal_button:
                break;

            case R.id.habit_study_button:
                break;
        }

        intent = new Intent(this, StampCard.class);
        startActivity(intent);
    }
}
