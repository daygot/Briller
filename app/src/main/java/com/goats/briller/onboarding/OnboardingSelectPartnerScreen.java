package com.goats.briller.onboarding;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.goats.briller.R;

public class OnboardingSelectPartnerScreen extends AppCompatActivity implements View.OnClickListener {

    ImageButton dog_button;
    ImageButton cat_button;
    String partnerChose, partnerDefaultName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ob_select_partner_screen);

        dog_button = findViewById(R.id.onboarding_dog_choose);
        cat_button = findViewById(R.id.onboarding_cat_choose);

        dog_button.setOnClickListener(this);
        cat_button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), OnboardingSelectedPartnerScreen.class);

        switch (v.getId()) {
            case R.id.onboarding_dog_choose:
                partnerChose = "dog";
                partnerDefaultName = getResources().getString(R.string.dog_name);
                break;
            case R.id.onboarding_cat_choose:
                partnerChose = "cat";
                partnerDefaultName = getResources().getString(R.string.cat_name);
                break;
            default:
                partnerChose = "pet";
        }

        intent.putExtra("partnerChose", partnerChose);
        intent.putExtra("partnerDefaultName", partnerDefaultName);
        startActivity(intent);
    }
}
