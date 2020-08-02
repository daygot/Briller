package com.goats.briller.main.ui.home.habit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.goats.briller.R;
import com.goats.briller.main.ui.home.stamp_card.StampCard;

public class HabitPhysique extends AppCompatActivity implements View.OnClickListener {

    Intent intent;
    ImageButton backButton, gym, run, pushup, squat;
    String habitChosen;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.habit_physique_choose);
        backButton = findViewById(R.id.back_button);
        gym = findViewById(R.id.habit_gym_button);
        run = findViewById(R.id.habit_run_button);
        pushup = findViewById(R.id.habit_pushup_button);
        squat = findViewById(R.id.habit_squat_button);

        backButton.setOnClickListener(this);
        gym.setOnClickListener(this);
        run.setOnClickListener(this);
        pushup.setOnClickListener(this);
        squat.setOnClickListener(this);
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
