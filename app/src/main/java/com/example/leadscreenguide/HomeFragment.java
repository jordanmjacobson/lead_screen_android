package com.example.leadscreenguide;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    private Button firstButton;
    private Button secondButton;
    private Button thirdButton;
    private Button fourthButton;
    private Button fifthButton;
    private Button sixthButton;
    private TextView textView;

        public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View root = inflater.inflate(R.layout.fragment_home, container, false);
            initControls(root);
            MainActivity.setFragOn();
            MainActivity.getAct().setTitle(R.string.app_name);
            MainActivity.getStk().clear();

            firstButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MainActivity.setChoice(1);
                    MainActivity.doChoice(1);
                }
            });

            secondButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MainActivity.setChoice(2);
                    MainActivity.doChoice(2);
                }
            });

            thirdButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MainActivity.setChoice(3);
                    MainActivity.doChoice(3);
                }
            });

            fourthButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MainActivity.setChoice(4);
                    MainActivity.doChoice(4);
                }
            });

            fifthButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MainActivity.setChoice(5);
                    MainActivity.doChoice(5);
                }
            });

            sixthButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MainActivity.setChoice(6);
                    MainActivity.doChoice(6);
                }
            });
            return root;
        }

        public void initControls(View v) {
            if (textView==null){
                textView = v.findViewById(R.id.text_home);
                textView.setText("Choose a Lead Screening Resource");
            }
            if (firstButton==null){
                firstButton = v.findViewById(R.id.first);
            }
            if (secondButton==null){
                secondButton = v.findViewById(R.id.second);
            }
            if (thirdButton==null){
                thirdButton = v.findViewById(R.id.third);
            }
            if (fourthButton==null){
                fourthButton = v.findViewById(R.id.fourth);
            }
            if (fifthButton==null){
                fifthButton = v.findViewById(R.id.fifth);
            }
            if (sixthButton==null){
                sixthButton = v.findViewById(R.id.sixth);
            }
        }
}