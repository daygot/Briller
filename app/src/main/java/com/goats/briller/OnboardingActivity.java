package com.goats.briller;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class OnboardingActivity extends AppCompatActivity {

    private static final String TAG = "OnboardingActivity";

    private OnboardingFragmentsAdapter OBF_FragmentsAdapter;

    private ViewPager OBF_ViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.onboarding_activity_layout);
        Log.d(TAG, "Onboarding OnCreate Started");

        OBF_FragmentsAdapter = new OnboardingFragmentsAdapter(getSupportFragmentManager());

        OBF_ViewPager = (ViewPager) findViewById(R.id.container);
        // SetUp Pager
        setUpViewPager(OBF_ViewPager);

    }

    private void setUpViewPager(ViewPager viewPager){
        OnboardingFragmentsAdapter adapter = new OnboardingFragmentsAdapter(getSupportFragmentManager());
        adapter.addFragment(new ob_f1(), "ob_f1");
        adapter.addFragment(new ob_f2(), "ob_f2");
        adapter.addFragment(new ob_f3(), "ob_f3");
        viewPager.setAdapter(adapter);
    }

    public void setViewPager(int fragmentNumber){
        OBF_ViewPager.setCurrentItem(fragmentNumber);
    }

}
