package com.goats.briller.main.ui.pethouse;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.goats.briller.R;

public class PethouseFragment extends Fragment implements View.OnClickListener {

    ImageButton rewards, store;
    ImageView pet;
    Intent intent;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.main_fragment_pethouse, container, false);
        return root;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rewards = getView().findViewById(R.id.pethouse_rewards);
        store = getView().findViewById(R.id.pethouse_store);
        pet = getView().findViewById(R.id.pethouse_pet);

        rewards.setOnClickListener(this);
        store.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pethouse_rewards:
                intent = new Intent(getContext(), PethouseRewards.class);
                break;
            case R.id.pethouse_store:
                intent = new Intent(getContext(), PethouseStore.class);
                break;
        }
        startActivity(intent);
    }
}
