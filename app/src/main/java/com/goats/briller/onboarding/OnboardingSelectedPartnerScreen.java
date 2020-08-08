package com.goats.briller.onboarding;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.goats.briller.R;
import com.goats.briller.main.ui.stats.StampCard;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class OnboardingSelectedPartnerScreen extends AppCompatActivity {

    Button enterButton;
    String partnerChose, partnerDefaultName;
    ArrayList<StampCard> all_stampCards = new ArrayList<>();


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

                Intent intent = new Intent(getApplicationContext(), OnboardingInstruction.class);
                startActivity(intent);
                finish();
            }
        });

        StampCard gym_stampCard = new StampCard("Gym", null,
                null, null,
                null,null, null, null);

        StampCard run_stampCard = new StampCard("Run", null,
                null, null,
                null,null, null, null);

        StampCard pushUps_stampCard = new StampCard("Push Ups", null,
                null, null,
                null,null, null, null);

        StampCard squats_stampCard = new StampCard("Squats", null,
                null, null,
                null,null, null, null);

        StampCard meditation_stampCard = new StampCard("Meditation", null,
                null, null,
                null,null, null, null);

        StampCard Reading_stampCard = new StampCard("Reading", null,
                null, null,
                null,null, null, null);

        StampCard Journal_stampCard = new StampCard("Journal", null,
                null, null,
                null,null, null, null);

        StampCard Study_stampCard = new StampCard("Study", null,
                null, null,
                null,null, null, null);

        System.out.println(all_stampCards);
        System.out.println(gym_stampCard);

        all_stampCards.add(gym_stampCard);
        all_stampCards.add(run_stampCard);
        all_stampCards.add(pushUps_stampCard);
        all_stampCards.add(squats_stampCard);
        all_stampCards.add(meditation_stampCard);
        all_stampCards.add(Reading_stampCard);
        all_stampCards.add(Journal_stampCard);
        all_stampCards.add(Study_stampCard);

        JSONObject hashMap_StampCards_progress = new JSONObject();

        try {
            hashMap_StampCards_progress.put("Monday", 0);
            hashMap_StampCards_progress.put("Tuesday", 0);
            hashMap_StampCards_progress.put("Wednesday", 0);
            hashMap_StampCards_progress.put("Thursday", 0);
            hashMap_StampCards_progress.put("Friday", 0);
            hashMap_StampCards_progress.put("Saturday", 0);
            hashMap_StampCards_progress.put("Sunday", 0);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JSONObject jsonObject = new JSONObject();

        for (int i = 0; i < all_stampCards.size(); i++) {

            JSONObject hashMap_StampCards = new JSONObject();

            try {
                hashMap_StampCards.put(all_stampCards.get(i).getHabit(), hashMap_StampCards_progress);
            } catch (JSONException e) {
                e.printStackTrace();
            }

            try {
                jsonObject.put(String.valueOf(i), hashMap_StampCards);
            } catch (JSONException e) {
                e.printStackTrace();
            }

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
