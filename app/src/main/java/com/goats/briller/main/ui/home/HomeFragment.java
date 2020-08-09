package com.goats.briller.main.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.goats.briller.R;
import com.goats.briller.main.Home;
import com.goats.briller.main.ui.home.habit.HabitType;
import com.goats.briller.partner.Partner;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class HomeFragment extends Fragment {

    private Button addHabit;
    private TextView habitCount;
    private ImageView petIcon;
    private int completedHabitCount = 0;
    private int totalHabitCount = 0;
    private Partner partner;

    private int sadPartnerIcon;
    private int happyPartnerIcon;

    LinearLayout habitContainer;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.main_fragment_home, container, false);

        Home home = (Home) getActivity();

        try {
            partner = home.getPartner();

            // code to induce NPE
            System.out.println(partner.getName());
        } catch (NullPointerException npe) {
            File directory = new File(getActivity().getApplicationContext().getFilesDir(), "Onboarding_Info");
            File onboardingInfo = new File(directory, "Pet_Data.json");

            FileReader fileReader = null;
            try {
                fileReader = new FileReader(onboardingInfo);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder stringBuilder = new StringBuilder();
            String line = null;
            try {
                line = bufferedReader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            while (line != null){
                stringBuilder.append(line).append("\n");
                try {
                    line = bufferedReader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            String onboardingData = stringBuilder.toString();
            JSONObject onboardingDataJSON  = null;
            try {
                onboardingDataJSON = new JSONObject(onboardingData);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            try {
                partner = new Partner(onboardingDataJSON.get("PartnerType").toString(), onboardingDataJSON.get("PartnerName").toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }

        sadPartnerIcon = partner.getPartnerSad();
        happyPartnerIcon = partner.getPartnerHappy();

        return root;
    }

    @Override
    public void onViewCreated(final View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        habitContainer = getView().findViewById(R.id.habit_container);

        try {
            File directory = new File(getActivity().getApplicationContext().getFilesDir(), "StampCards");
            final File stampcards = new File(directory, "StampCards.json");

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
            final JSONObject stampcardsJSON  = new JSONObject(stampcardsData);

            Iterator<String> keys = stampcardsJSON.keys();

            while(keys.hasNext()) {
                final String key = keys.next();
                final JSONObject habit = (JSONObject) stampcardsJSON.get(key);
                if (habit.get("started").equals(true)) {

                    //Set up screen according to habit stampcards
                    totalHabitCount++;

                    TableRow habitRow = new TableRow(getActivity());
                    habitRow.setBackgroundResource(R.drawable.item_habit);
                    habitRow.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
                    final TextView habitTitle = new TextView(getActivity());
                    final ImageButton habitTimer = new ImageButton(getActivity());
                    ImageButton habitDelete = new ImageButton(getActivity());

                    habitTitle.setText(key);

                    habitTimer.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
                    habitTimer.setImageResource(R.drawable.stampcard_alarm);
                    habitTimer.setScaleType(ImageView.ScaleType.FIT_XY);
                    habitTimer.setAdjustViewBounds(true);
                    habitTimer.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getActivity().getApplicationContext(), HabitTimer.class);

                            intent.putExtra("habitTitle", key);

                            try {
                                intent.putExtra("timer", Integer.parseInt(habit.get("timer").toString()));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            startActivity(intent);
                            habitTimer.setEnabled(false);
                            new Handler().postDelayed(new Runnable()
                                                      {
                                                          public void run()
                                                          {
                                                              habitTimer.setEnabled(true);
                                                          }
                                                      }, 86400000
                            );

                        }
                    });

                    habitDelete.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT));
                    habitDelete.setImageResource(R.drawable.app_delete_button);
                    habitDelete.setScaleType(ImageView.ScaleType.FIT_XY);
                    habitDelete.setAdjustViewBounds(true);
                    habitDelete.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            totalHabitCount--;

                            try {
                                JSONObject stampcardToModify = stampcardsJSON.getJSONObject(key);
                                stampcardToModify.put("started", false);

                                FileWriter writer = new FileWriter(stampcards);

                                JSONObject newStampcards = stampcardsJSON;

                                writer.append(newStampcards.toString());
                                writer.flush();
                                writer.close();
                            } catch (JSONException | IOException e) {
                                e.printStackTrace();
                            }
                            FragmentTransaction ft = getFragmentManager().beginTransaction();
                            ft.detach(HomeFragment.this).attach(HomeFragment.this).commit();
                        }
                    });

                    habitRow.addView(habitTitle);
                    habitRow.addView(habitTimer);
                    habitRow.addView(habitDelete);
                    habitRow.setGravity(Gravity.CENTER);

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

//        habitCount = getView().findViewById(R.id.main_home_habit_count);
//        habitCount.setText(completedHabitCount + " / " + totalHabitCount);

        petIcon = getView().findViewById(R.id.main_home_pet_icon);
        petIcon.setImageResource(sadPartnerIcon);

        if (completedHabitCount == totalHabitCount) {
//            habitCount.setBackgroundResource(R.drawable.habit_completion_good);
            petIcon.setImageResource(happyPartnerIcon);
        }
    }
}
