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

public class ob_instruction_3 extends Fragment {

    private final int FLOW_NUMBER = 3;
    private Button forward_button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ob_instruction_3, container, false);

        forward_button = (Button) view.findViewById(R.id.complete_registration);

        forward_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Going to Fragment 2!", Toast.LENGTH_SHORT).show();

                ((OnboardingActivity)getActivity()).setViewPager(FLOW_NUMBER);
            }
        });

        return view;
    }
}
