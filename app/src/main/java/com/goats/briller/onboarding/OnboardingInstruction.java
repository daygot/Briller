package com.goats.briller.onboarding;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.goats.briller.R;

public class OnboardingInstruction extends AppCompatActivity {

    private static final String TAG = "OnboardingActivity";

    private WrapContentViewPager onboardingInstructionViewPager;
    private ImageView onboardingInstructionProgressBar;
    private TextView onboardingInstructionTitle;

    private int currentFragmentNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onboarding_activity_layout);
        Log.d(TAG, "Onboarding instruction flow started");

        onboardingInstructionViewPager = findViewById(R.id.onboarding_instruction_container);
        onboardingInstructionProgressBar = findViewById(R.id.onboarding_instruction_progress);
        onboardingInstructionTitle = findViewById(R.id.onboarding_instruction_title);

        onboardingInstructionViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                currentFragmentNumber = position;
                onboardingInstructionTitle.setText(getResources().getIdentifier(
                        "onboarding_instruction_title_" + currentFragmentNumber,
                        "string",
                        onboardingInstructionTitle.getContext().getPackageName()));
                onboardingInstructionProgressBar.setImageResource(getResources().getIdentifier(
                        "onboarding_instruction_progress_" + currentFragmentNumber,
                        "drawable",
                        onboardingInstructionProgressBar.getContext().getPackageName()));
            }

            @Override
            public void onPageSelected(int position) {
                onboardingInstructionViewPager.reMeasureCurrentPage(onboardingInstructionViewPager
                        .getCurrentItem());
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        // Set Up Pager
        setUpViewPager(onboardingInstructionViewPager);
    }

    private void setUpViewPager(ViewPager viewPager){
        OnboardingFragmentsAdapter OBF_FragmentsAdapter = new OnboardingFragmentsAdapter(getSupportFragmentManager());
        OBF_FragmentsAdapter.addFragment(new OnboardingInstruction1(), "ob_instruction_1");
        OBF_FragmentsAdapter.addFragment(new OnboardingInstruction2(), "ob_instruction_2");
        OBF_FragmentsAdapter.addFragment(new OnboardingInstruction3(), "ob_instruction_3");
        OBF_FragmentsAdapter.addFragment(new OnboardingInstruction4(), "ob_instruction_4");
        viewPager.setAdapter(OBF_FragmentsAdapter);
    }

//    @Override
//    public void onBackPressed() {
//        if (currentFragmentNumber == 1) {super.onBackPressed();}
//        this.setViewPager(currentFragmentNumber - 1);
//    }
}
