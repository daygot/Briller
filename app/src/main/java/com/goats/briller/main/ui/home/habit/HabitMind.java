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
    String habitChosen;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.habit_mind_choose);
        backButton = findViewById(R.id.back_button);
        meditate = findViewById(R.id.habit_meditate_button);
        read = findViewById(R.id.habit_read_button);
        journal = findViewById(R.id.habit_journal_button);
        study = findViewById(R.id.habit_study_button);

        backButton.setOnClickListener(this);
        meditate.setOnClickListener(this);
        read.setOnClickListener(this);
        journal.setOnClickListener(this);
        study.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.back_button) {
            onBackPressed();
            finish();
            return;
        }

        habitChosen = v.getTag().toString();

        intent = new Intent(this, StampCard.class);
        intent.putExtra("habitTitle", habitChosen);
        startActivity(intent);
    }
}
