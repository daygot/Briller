package com.goats.briller.onboarding;

import android.content.Intent;
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
import com.goats.briller.main.Home;
import com.goats.briller.partner.Partner;

public class OnboardingInstruction4 extends Fragment {

    private Button continueButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.ob_instruction_4, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        continueButton = getView().findViewById(R.id.onboarding_instruction_finish);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Home.class);

                OnboardingInstruction onboardingInstruction = (OnboardingInstruction) getActivity();
                Partner partner = onboardingInstruction.getPartner();

                intent.putExtra("partner", partner);
                startActivity(intent);
                getActivity().finish();
            }
        });
    }
}
