package com.goats.briller.main.ui.home;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.ViewModelProviders;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.goats.briller.R;
import com.goats.briller.main.ui.home.habit.HabitType;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private Button addHabit;

    LinearLayout habitContainer;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.main_fragment_home, container, false);

        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        habitContainer = getView().findViewById(R.id.habit_container);

        try {
            File directory = new File(getActivity().getApplicationContext().getFilesDir(), "StampCards");
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

            Iterator<String> keys = stampcardsJSON.keys();

            while(keys.hasNext()) {
                String key = keys.next();
                JSONObject habit = (JSONObject) stampcardsJSON.get(key);
                if (habit.get("started").equals(true)) {
                    TableRow habitRow = new TableRow(getActivity());
                    habitRow.setBackgroundResource(R.drawable.item_habit);
                    habitRow.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
                    TextView habitTitle = new TextView(getActivity());
                    ImageButton habitTimer = new ImageButton(getActivity());

                    habitTitle.setText(key);

                    habitTimer.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
                    habitTimer.setImageResource(R.drawable.stampcard_alarm);
                    habitTimer.setScaleType(ImageView.ScaleType.FIT_XY);
                    habitTimer.setAdjustViewBounds(true);
                    habitTimer.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getActivity().getApplicationContext(), HabitTimer.class);
                            startActivity(intent);
                        }
                    });

                    habitRow.addView(habitTitle);
                    habitRow.addView(habitTimer);

                    habitContainer.addView(habitRow, new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        addHabit = getView().findViewById(R.id.add_habit_button);
        addHabit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), HabitType.class));
            }
        });
    }

    public void stampcardMade() {
        return;
    }
}
