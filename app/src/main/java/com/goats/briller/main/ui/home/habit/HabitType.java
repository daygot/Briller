package com.goats.briller.main.ui.home.habit;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.goats.briller.R;

public class HabitType extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.habit_type_choose);
    }

    @Override
    public void onClick(View v) {

        Intent intent;

        switch(v.getId()) {

            case R.id.habit_choose_physique:
                intent = new Intent(this, HabitPhysique.class);
                startActivity(intent);
                break;

            case R.id.habit_choose_mind:
                intent = new Intent(this, HabitMind.class);
                startActivity(intent);
                break;

            case R.id.habit_choose_back_button:
                onBackPressed();
                break;
        }
    }
}
