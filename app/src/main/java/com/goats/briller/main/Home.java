package com.goats.briller.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.goats.briller.R;
import com.goats.briller.main.ui.home.HomeFragment;
import com.goats.briller.main.ui.pethouse.PethouseFragment;
import com.goats.briller.main.ui.stats.StatsFragment;
import com.goats.briller.partner.Partner;

public class Home extends AppCompatActivity {

    public Partner partner;
    boolean habitCompleted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        BottomNavigationView mainNavView = findViewById(R.id.main_nav_view);
        mainNavView.setItemIconTintList(null);
        mainNavView.setSelectedItemId(R.id.main_navigation_home);

        partner = getIntent().getParcelableExtra("partner");
        habitCompleted = getIntent().getBooleanExtra("habitCompleted", false);

        final Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);

        mainNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                Fragment selectedFragment = null;

                switch (menuItem.getItemId()) {
                    case R.id.main_navigation_home:
                        selectedFragment = new HomeFragment();
                        break;
                    case R.id.main_navigation_stats:
                        selectedFragment = new StatsFragment();
                        break;
                    case R.id.main_navigation_pethouse:
                        selectedFragment = new PethouseFragment();
                        break;
                }

                getSupportFragmentManager().beginTransaction().remove(currentFragment).commit();
                getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, selectedFragment).commit();
                return true;
            }
        });
    }

    public Partner getPartner() { return partner; }

    @Override
    public void onBackPressed() {
    }
}
