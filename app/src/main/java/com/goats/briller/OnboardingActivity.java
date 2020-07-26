package com.goats.briller;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class OnboardingActivity extends AppCompatActivity {

    private static final String TAG = "OnboardingActivity";

    private WrapContentViewPager onboarding_instruction_ViewPager;

    private int currentFragmentNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onboarding_activity_layout);
        Log.d(TAG, "Onboarding instruction flow started");

        onboarding_instruction_ViewPager = findViewById(R.id.onboarding_instructions_container);

        onboarding_instruction_ViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                onboarding_instruction_ViewPager.reMeasureCurrentPage(onboarding_instruction_ViewPager.getCurrentItem());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        // Set Up Pager
        setUpViewPager(onboarding_instruction_ViewPager);

        System.out.println("pager set up");
    }

    private void setUpViewPager(ViewPager viewPager){
        OnboardingFragmentsAdapter OBF_FragmentsAdapter = new OnboardingFragmentsAdapter(getSupportFragmentManager());
        OBF_FragmentsAdapter.addFragment(new ob_instruction_1(), "ob_instruction_1");
        OBF_FragmentsAdapter.addFragment(new ob_instruction_2(), "ob_instruction_2");
        OBF_FragmentsAdapter.addFragment(new ob_instruction_3(), "ob_instruction_3");
        OBF_FragmentsAdapter.addFragment(new ob_instruction_4(), "ob_instruction_4");
        System.out.println("fragments added");
        viewPager.setAdapter(OBF_FragmentsAdapter);
        System.out.println("fragments adapter set");
    }

    public void setViewPager(int fragmentNumber){
        onboarding_instruction_ViewPager.setCurrentItem(fragmentNumber);
        currentFragmentNumber = fragmentNumber;
    }

    @Override
    public void onBackPressed() {
        if (currentFragmentNumber == 1) {super.onBackPressed();}
        this.setViewPager(currentFragmentNumber - 1);
    }
}
