package com.example.leadscreenguide.ui.references;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.leadscreenguide.R;
import com.example.leadscreenguide.ui.dashboard.DashboardViewModel;

public class ReferencesFragment extends Fragment {

    private ReferencesViewModel referencesViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        referencesViewModel =
                ViewModelProviders.of(this).get(ReferencesViewModel.class);
        View root = inflater.inflate(R.layout.references_fragment, container, false);
        final TextView textView = root.findViewById(R.id.text_references);
        referencesViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }



}
