package com.example.leadscreenguide.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.leadscreenguide.HomeActivity;
import com.example.leadscreenguide.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    private Button firstButton= null;
    private Button secondButton= null;
    private Button thirdButton= null;
    private Button fourthButton= null;
    private Button fifthButton= null;
    private Button sixthButton= null;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        firstButton = root.findViewById(R.id.first);
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeActivity.setChoice(1);
                Intent intent= new Intent(view.getContext(), HomeActivity.class);
                startActivity(intent);
            }
        });

        secondButton = root.findViewById(R.id.second);
        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeActivity.setChoice(2);
                Intent intent= new Intent(view.getContext(), HomeActivity.class);
                startActivity(intent);
            }
        });

        thirdButton = root.findViewById(R.id.third);
        thirdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeActivity.setChoice(3);
                Intent intent= new Intent(view.getContext(), HomeActivity.class);
                startActivity(intent);
            }
        });

        fourthButton = root.findViewById(R.id.fourth);
        fourthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeActivity.setChoice(4);
                Intent intent= new Intent(view.getContext(), HomeActivity.class);
                startActivity(intent);
            }
        });

        fifthButton = root.findViewById(R.id.fifth);
        fifthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeActivity.setChoice(5);
                Intent intent= new Intent(view.getContext(), HomeActivity.class);
                startActivity(intent);
            }
        });

        sixthButton = root.findViewById(R.id.sixth);
        sixthButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HomeActivity.setChoice(6);
                Intent intent= new Intent(view.getContext(), HomeActivity.class);
                startActivity(intent);
            }
        });

        return root;
    }
}