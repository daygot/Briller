package com.goats.briller;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class OnboardingActivity extends AppCompatActivity {

    private static final String TAG = "OnboardingActivity";

    private ViewPager OBF_ViewPager;

    private int currentFragmentNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onboarding_activity_layout);
        Log.d(TAG, "Onboarding instruction flow started");

        OBF_ViewPager = findViewById(R.id.onboarding_instructions_container);

        // Set Up Pager
        setUpViewPager(OBF_ViewPager);
    }

    private void setUpViewPager(ViewPager viewPager){
        OnboardingFragmentsAdapter OBF_FragmentsAdapter = new OnboardingFragmentsAdapter(getSupportFragmentManager());
        OBF_FragmentsAdapter.addFragment(new ob_instruction_1(), "ob_instruction_1");
        OBF_FragmentsAdapter.addFragment(new ob_instruction_2(), "ob_instruction_2");
        OBF_FragmentsAdapter.addFragment(new ob_instruction_3(), "ob_instruction_3");
        OBF_FragmentsAdapter.addFragment(new ob_instruction_4(), "ob_instruction_4");
        viewPager.setAdapter(OBF_FragmentsAdapter);
    }

    public void setViewPager(int fragmentNumber){
        OBF_ViewPager.setCurrentItem(fragmentNumber);
        currentFragmentNumber = fragmentNumber;
    }

    @Override
    public void onBackPressed() {
        if (currentFragmentNumber == 1) {super.onBackPressed();}
        this.setViewPager(currentFragmentNumber - 1);
    }
}
