package com.goats.briller.onboarding;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.goats.briller.R;

import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.util.Hashtable;

public class OnboardingSelectedPartnerScreen extends AppCompatActivity {

    Button enterButton;
    String partnerChose, partnerDefaultName;

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
    }

}
