package com.goats.briller.main.ui.pethouse;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.goats.briller.R;

public class PethouseStore extends AppCompatActivity {

    ImageButton petStore, islandStore;
    Boolean displayingPets = true;
    ImageView petHouseStoreItem1, petHouseStoreItem2, petHouseStoreItem3, petHouseStoreItem4,
            petHouseStoreItem5, petHouseStoreItem6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pethouse_store);

        petStore = findViewById(R.id.pethouse_store_pets);
        islandStore = findViewById(R.id.pethouse_store_islands);

        petStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!displayingPets) {
                    displayingPets = true;
                    petHouseStoreItem1.setImageResource(R.drawable.premium_pet_bear);
                    petHouseStoreItem2.setImageResource(R.drawable.premium_pet_tiger);
                    petHouseStoreItem3.setImageResource(R.drawable.premium_pet_grey_cat);
                    petHouseStoreItem4.setImageResource(R.drawable.premium_pet_deer);
                    petHouseStoreItem5.setImageResource(R.drawable.premium_pet_pig);
                    petHouseStoreItem6.setImageResource(R.drawable.premium_pet_orange_cat);
                }
            }
        });

        islandStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (displayingPets) {
                    displayingPets = false;
                    petHouseStoreItem1.setImageResource(R.drawable.premium_island_glacier);
                    petHouseStoreItem2.setImageResource(R.drawable.premium_island_hill);
                    petHouseStoreItem3.setImageResource(R.drawable.premium_island_snow_mountain);
                    petHouseStoreItem4.setImageResource(R.drawable.premium_island_stonehenge);
//                    petHouseStoreItem5.setImageResource(R.drawable.premium_pet_pig);
//                    petHouseStoreItem6.setImageResource(R.drawable.premium_pet_orange_cat);
                }
            }
        });
    }

}
