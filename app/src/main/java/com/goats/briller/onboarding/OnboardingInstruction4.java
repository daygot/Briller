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

public class OnboardingInstruction4 extends Fragment {

    private Button forward_button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ob_instruction_4, container, false);

//        forward_button = view.findViewById(R.id.complete_registration);
//
//        forward_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getActivity(), "Going to Fragment 2!", Toast.LENGTH_SHORT).show();
//
//                ((OnboardingActivity)getActivity()).setViewPager(FLOW_NUMBER);
//            }
//        });

        return view;
    }
}
