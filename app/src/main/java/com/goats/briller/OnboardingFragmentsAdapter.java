package com.goats.briller;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class OnboardingFragmentsAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> OB_fragmentList = new ArrayList<>();
    private final List<String> OB_fragmentListTitles = new ArrayList<>();

    public OnboardingFragmentsAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment fragment, String title){
        OB_fragmentList.add(fragment);
        OB_fragmentListTitles.add(title);
    }

    @Override
    public Fragment getItem(int position) {
        return OB_fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return OB_fragmentList.size();
    }
}
