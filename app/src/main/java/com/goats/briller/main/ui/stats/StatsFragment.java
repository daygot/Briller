package com.goats.briller.main.ui.stats;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.ViewModelProviders;
import android.widget.TextView;

import com.goats.briller.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

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
    }

    @Override
    public void onClick(View v) {
        displayStampcard(v.getTag().toString());
    }

    public void displayStampcard(String habit) {
        try {
            File directory = new File(getActivity().getApplicationContext().getFilesDir(), "StampCards");
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

            JSONObject stampcardToCheck = stampcardsJSON.getJSONObject(habit);

            Iterator<String> keys = stampcardToCheck.keys();

            while(keys.hasNext()) {
                String key = keys.next();
                int id = getResources().getIdentifier("stampcard_day" + key, "id", getActivity().getApplicationContext().getPackageName());
                if (android.text.TextUtils.isDigitsOnly(key)) {
                    TextView textView = getView().findViewById(id);

                    switch ((int) stampcardToCheck.get(key)) {
                        case 1:
                            textView.setBackgroundResource(R.drawable.item_completed);
                        case -1:
                            textView.setBackgroundResource(R.drawable.item_failed);
                        case 0:
                            textView.setBackgroundResource(R.drawable.item_stats);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
