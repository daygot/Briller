package com.goats.briller.onboarding;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.goats.briller.R;;
import com.goats.briller.main.ui.stats.StampCardObject;
import com.goats.briller.partner.Partner;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class OnboardingSelectedPartnerScreen extends AppCompatActivity {

    Button enterButton;
    String partnerChose, partnerDefaultName;
    ArrayList<StampCardObject> all_stampCards = new ArrayList<>();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ob_selected_partner);
        partnerChose = getIntent().getStringExtra("partnerChose");
        partnerDefaultName = getIntent().getStringExtra("partnerDefaultName");

        final EditText enteredText = findViewById(R.id.partner_name);
        enteredText.setText(partnerDefaultName);
        enterButton = findViewById(R.id.partner_name_submit);

        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!enteredText.getText().toString().isEmpty()) {
                    File directory = new File(getApplicationContext().getFilesDir(), "Onboarding_Info");
                    if (!directory.exists()) {
                        directory.mkdir();
                    }
                    try {
                        File onboardingInfo = new File(directory, "Pet_Data.json");
                        FileWriter writer = new FileWriter(onboardingInfo);

                        JSONObject storeData = new JSONObject();
                        storeData.put("PartnerChosen", "Y");
                        storeData.put("PartnerType", partnerChose);
                        storeData.put("PartnerName", enteredText.getText().toString());

                        writer.append(storeData.toString());
                        writer.flush();
                        writer.close();
                    } catch (Exception e) { System.out.println(e.toString()); }
                }

                Partner partner = new Partner(partnerChose, enteredText.getText().toString());

                Intent intent = new Intent(getApplicationContext(), OnboardingInstruction.class);
                intent.putExtra("partner", partner);
                startActivity(intent);
                finish();
            }
        });

        JSONObject jsonObject = new JSONObject();

        try {
            StampCardObject gym_stampCard = new StampCardObject(getResources().getString(R.string.habit_physique_gym));

            StampCardObject run_stampCard = new StampCardObject(getResources().getString(R.string.habit_physique_run));

            StampCardObject pushUps_stampCard = new StampCardObject(getResources().getString(R.string.habit_physique_pushup));

            StampCardObject squats_stampCard = new StampCardObject(getResources().getString(R.string.habit_physique_squat));

            StampCardObject meditation_stampCard = new StampCardObject(getResources().getString(R.string.habit_mind_meditate));

            StampCardObject Reading_stampCard = new StampCardObject(getResources().getString(R.string.habit_mind_read));

            StampCardObject Journal_stampCard = new StampCardObject(getResources().getString(R.string.habit_mind_journal));

            StampCardObject Study_stampCard = new StampCardObject(getResources().getString(R.string.habit_mind_study));

            all_stampCards.add(gym_stampCard);
            all_stampCards.add(run_stampCard);
            all_stampCards.add(pushUps_stampCard);
            all_stampCards.add(squats_stampCard);
            all_stampCards.add(meditation_stampCard);
            all_stampCards.add(Reading_stampCard);
            all_stampCards.add(Journal_stampCard);
            all_stampCards.add(Study_stampCard);

            for (int i = 0; i < all_stampCards.size(); i++) {
                try {
                    jsonObject.put(all_stampCards.get(i).getHabit(), all_stampCards.get(i).getStampcardData());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        File directory = new File(getApplicationContext().getFilesDir(), "StampCards");

        directory.mkdir();

        try {
            File StampCardInfo = new File(directory, "StampCards.json");
            FileWriter writer = new FileWriter(StampCardInfo);
            writer.append(jsonObject.toString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
