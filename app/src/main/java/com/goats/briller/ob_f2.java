package com.goats.briller;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class ob_f2 extends Fragment {

    private Button DOG_BUTTON;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ob_f2, container, false);

        DOG_BUTTON = (Button) view.findViewById(R.id.f2_dog_button);

        DOG_BUTTON.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Going to Fragment 3!", Toast.LENGTH_SHORT).show();

                ((OnboardingActivity)getActivity()).setViewPager(2);
            }
        });

        return view;
    }

}
