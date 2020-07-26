package com.goats.briller.main.ui.pethouse;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;

import com.goats.briller.R;

public class PethouseFragment extends Fragment {

    private PethouseViewModel pethouseViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        pethouseViewModel =
                ViewModelProviders.of(this).get(PethouseViewModel.class);
        View root = inflater.inflate(R.layout.main_fragment_pethouse, container, false);
        final TextView textView = root.findViewById(R.id.text_notifications);
        pethouseViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}
