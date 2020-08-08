package com.goats.briller.main.ui.stats;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;

import com.goats.briller.R;

import java.io.File;

public class StatsFragment extends Fragment implements View.OnClickListener {

    private StatsViewModel statsViewModel;
    ImageButton gym, run, pushup, squat, meditate, read, journal, study;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        statsViewModel = ViewModelProviders.of(this).get(StatsViewModel.class);
        View root = inflater.inflate(R.layout.main_fragment_stats, container, false);
        return root;

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        gym = getView().findViewById(R.id.stats_gym_button);
        run = getView().findViewById(R.id.stats_run_button);
        pushup = getView().findViewById(R.id.stats_pushup_button);
        squat = getView().findViewById(R.id.stats_squat_button);
        meditate = getView().findViewById(R.id.stats_meditate_button);
        read = getView().findViewById(R.id.stats_read_button);
        journal = getView().findViewById(R.id.stats_journal_button);
        study = getView().findViewById(R.id.stats_study_button);

        gym.setOnClickListener(this);
        run.setOnClickListener(this);
        pushup.setOnClickListener(this);
        squat.setOnClickListener(this);
        meditate.setOnClickListener(this);
        read.setOnClickListener(this);
        journal.setOnClickListener(this);
        study.setOnClickListener(this);

//        progressBarTitle = getView().findViewById(R.id.stats_progress_bar_title);
//        completionPercentage1 = getView().findViewById(R.id.stats_progress_bar_completion_percentage);
//        completionPercentage2 = getView().findViewById(R.id.stats_progress_bar_completion_percentage_2);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.stats_gym_button:
                break;
            case R.id.stats_run_button:
                break;
            case R.id.stats_pushup_button:
                break;
            case R.id.stats_squat_button:
                break;
            case R.id.stats_meditate_button:
                break;
            case R.id.stats_read_button:
                break;
            case R.id.stats_journal_button:
                break;
            case R.id.stats_study_button:
                break;
        }
    }
}
