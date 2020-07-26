package com.goats.briller.main;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.goats.briller.R;

public class home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        System.out.println("appbarconfig");
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        System.out.println("appbarconfignavcontroller");
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        System.out.println("appbarconfigsetup");
        NavigationUI.setupWithNavController(navView, navController);
        System.out.println("DONW");
    }

}
