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

public class ob_f1 extends Fragment {

    private Button btnTo_F2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ob_f1, container, false);

        btnTo_F2 = (Button) view.findViewById(R.id.f1_button);

        btnTo_F2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Going to Fragment 2!", Toast.LENGTH_SHORT).show();

                ((OnboardingActivity)getActivity()).setViewPager(1);
            }
        });

        return view;
    }
}
