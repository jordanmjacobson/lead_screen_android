package com.example.leadscreenguide;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    private static int choice= 0;

    private TextView holder1;

    private TextView holder2;

    private Button button1;

    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initControls();
        doChoice(choice);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (choice== 1) {
                    //open lead exposure risk survey
                    doSurvey();
                }

                if (choice== 2) {
                    //open capillary test

                }

                //if any other choices do nothing

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (choice == 2) {
                    //open venous test
                }
                //if any other choices do nothing
            }
        });

    }

    public void initControls(){
        if (holder1==null){
            holder1= findViewById(R.id.holder1);
        }
        if (holder2==null){
            holder2= findViewById(R.id.holder2);
        }
        if (button1==null){
            button1= findViewById(R.id.button1);
        }
        if (button2==null){
            button2= findViewById(R.id.button2);
        }
    }

    public void doChoice(int num) {
        if (num==1) {
            doFirstChoice();
        }
        if (num==2) {
            doSecondChoice();
        }
        if (num==3) {
            doThirdChoice();
        }
        if (num==4) {
            doFourthChoice();
        }
        if (num==5) {
            doFifthChoice();
        }
        if (num==6) {
            doSixthChoice();
        }

    }
    public void doFirstChoice() {
        getSupportActionBar().setTitle("Who,How,When to Screen");

        button2.setVisibility(View.GONE);
        holder2.setVisibility(View.GONE);

        holder1.setText("it worked way1");
        button1.setText("Lead Exposure Risk Survey");
    }
    public void doSecondChoice() {
        getSupportActionBar().setTitle("How To Manage Lead Levels");

        holder1.setText("Is the sample from venous phlebotomy or from capillary fingerstick?");
        button1.setText("Capillary Test");
        button2.setText("Venous Test");
        holder2.setText("*Subsequently, Blood Lead Level frequently abbreviated BLL");
    }
    public void doThirdChoice() {
        getSupportActionBar().setTitle("Signs/Symptoms of Lead Poisoning");

        button1.setVisibility(View.GONE);
        button2.setVisibility(View.GONE);
        holder2.setVisibility(View.GONE);

        holder1.setText("it worked way 3");
    }
    public void doFourthChoice() {
        getSupportActionBar().setTitle("Lead Exposure Risk Survey");

        button1.setVisibility(View.GONE);
        button2.setVisibility(View.GONE);
        holder2.setVisibility(View.GONE);

        holder1.setText("it worked way 4");
    }
    public void doFifthChoice() {
        getSupportActionBar().setTitle("High Lead Level Evaluation");

        button1.setVisibility(View.GONE);
        button2.setVisibility(View.GONE);
        holder2.setVisibility(View.GONE);

        holder1.setText("it worked way 5");
    }
    public void doSixthChoice() {
        getSupportActionBar().setTitle("Differing Guidelines");

        button1.setVisibility(View.GONE);
        button2.setVisibility(View.GONE);
        holder2.setVisibility(View.GONE);

        holder1.setText("it worked way 6");
    }

    public void doSurvey() {
        getSupportActionBar().setTitle("Lead Exposure Risk Survey");

        button1.setVisibility(View.GONE);
        button2.setVisibility(View.GONE);
        holder2.setVisibility(View.GONE);

        holder1.setText("survey stuff would go here");
    }
    public static void setChoice(int num) {
        choice= num;
    }

}
