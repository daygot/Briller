package com.goats.briller.onboarding;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.goats.briller.R;

public class ob_instruction_2 extends Fragment {

    private Button forward_button_dog;
    private Button forward_button_cat;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ob_instruction_2, container, false);

//        forward_button_dog = view.findViewById(R.id.f2_dog_button);
//        forward_button_cat = view.findViewById(R.id.f2_cat_button);
//
//        forward_button_dog.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getActivity(), "Going to Fragment 3!", Toast.LENGTH_SHORT).show();
//
//                ((OnboardingActivity)getActivity()).setViewPager(FLOW_NUMBER);
//            }
//        });
//
//        forward_button_cat.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getActivity(), "Going to Fragment 3!", Toast.LENGTH_SHORT).show();
//
//                ((OnboardingActivity)getActivity()).setViewPager(FLOW_NUMBER);
//            }
//        });

        return view;
    }
}
