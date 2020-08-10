package com.goats.briller.main.ui.pethouse;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.goats.briller.R;
import com.goats.briller.main.Home;
import com.goats.briller.partner.Partner;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PethouseFragment extends Fragment implements View.OnClickListener {

    ImageButton rewards, store;
    ImageView pet;
    Intent intent;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.main_fragment_pethouse, container, false);
        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rewards = getView().findViewById(R.id.pethouse_rewards);
        store = getView().findViewById(R.id.pethouse_store);
        pet = getView().findViewById(R.id.pethouse_pet);

        rewards.setOnClickListener(this);
        store.setOnClickListener(this);

        Home home = (Home) getActivity();

        Partner partner = null;
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

        pet.setImageResource(partner.getPartnerIsland());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pethouse_rewards:
                intent = new Intent(getContext(), PethouseRewards.class);
                break;
            case R.id.pethouse_store:
                intent = new Intent(getContext(), PethouseStore.class);
                break;
        }
        startActivity(intent);
    }
}
