package com.goats.briller.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.goats.briller.R;
import com.goats.briller.main.ui.home.HomeFragment;
import com.goats.briller.main.ui.pethouse.PethouseFragment;
import com.goats.briller.main.ui.stats.StatsFragment;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        BottomNavigationView mainNavView = findViewById(R.id.main_nav_view);
        mainNavView.setItemIconTintList(null);
        mainNavView.setSelectedItemId(R.id.main_navigation_home);

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
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
//                .build();
//        System.out.println("appbarconfig");
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        System.out.println("appbarconfignavcontroller");
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        System.out.println("appbarconfigsetup");
//        NavigationUI.setupWithNavController(mainNavView, navController);
//        System.out.println("DONW");
    }

}
