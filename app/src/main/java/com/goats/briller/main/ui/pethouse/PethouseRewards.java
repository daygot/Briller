package com.goats.briller.main.ui.pethouse;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import com.goats.briller.R;
import com.goats.briller.main.Home;
import com.goats.briller.onboarding.OnboardingWelcomeScreen;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class PethouseRewards extends AppCompatActivity {

    private ImageButton previous, next;
    private ImageSwitcher imageSwitcher;
    private int[] skins;
    private int imagePosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pethouse_store);

        try {
            File directory = new File(getApplicationContext().getFilesDir(), "Onboarding_Info");
            File onboardingInfo = new File(directory, "Pet_Data.json");

            FileReader fileReader = new FileReader(onboardingInfo);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder stringBuilder = new StringBuilder();
            String line = bufferedReader.readLine();
            while (line != null){
                stringBuilder.append(line).append("\n");
                line = bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();

            String onboardingData = stringBuilder.toString();
            JSONObject onboardingDataJSON  = new JSONObject(onboardingData);

            if (onboardingDataJSON.get("PartnerType").equals("Dog")) {
                skins = new int[]{R.drawable.onboarding_dog, R.drawable.onboarding_dog_skinned};
            } else {
                skins = new int[]{R.drawable.onboarding_cat, R.drawable.onboarding_cat_skinned};
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        imageSwitcher = findViewById(R.id.pethouse_skin_switcher);
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(PethouseRewards.this);
                imageView.setImageResource(skins[imagePosition]);
                return imageView;
            }
        });

        imageSwitcher.setInAnimation(this, android.R.anim.slide_in_left);
        imageSwitcher.setOutAnimation(this, android.R.anim.slide_out_right);

        previous = findViewById(R.id.pethouse_skin_previous);
        next = findViewById(R.id.pethouse_skin_next);

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imagePosition > 0) imagePosition--;
                imageSwitcher.setImageResource(skins[imagePosition]);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imagePosition < skins.length - 1) imagePosition++;
                imageSwitcher.setImageResource(skins[imagePosition]);
            }
        });
    }

}
