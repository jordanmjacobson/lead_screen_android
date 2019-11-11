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

    private Button button3;

    private Button button4;

    private Button button5;

    private Button button6;

    private Button button7;

    private Button button8;

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

                else if (choice== 2) {
                    //open capillary test
                    setChoice(7);
                    doTest();
                }
                else if (choice ==7) {
                    //do less than 5 ug for capillary test
                    undoTest();
                    holder1.setText("do less than 5 ug for capillary test\n");
                }
                else if (choice ==8) {
                    //do less than 5 ug for venous test
                    undoTest();
                    holder1.setText("do less than 5 ug for venous test\n");

                }
                //if any other choices do nothing

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (choice == 2) {
                    //open venous test
                    setChoice(8);
                    doTest();
                }
                else if (choice ==7) {
                    //do 5-9 ug for capillary test
                    undoTest();
                    holder1.setText("do 5-9 ug for capillary test\n");
                }
                else if (choice ==8) {
                    //do 5-9 ug for venous test
                    undoTest();
                    holder1.setText("do 5-9 ug for venous test\n");
                }
                //if any other choices do nothing
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (choice ==7) {
                    //do 10-14 ug for capillary test
                    undoTest();
                    holder1.setText("do 10-14 ug for capillary test\n");
                }
                else if (choice ==8) {
                    //do 10-14 ug for venous test
                    undoTest();
                    holder1.setText("do 10-14 ug for venous test\n");
                }
                //if any other choices do nothing
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (choice ==7) {
                    //do 15-24 ug for capillary test
                    undoTest();
                    holder1.setText("do 15-24 ug for capillary test\n");
                }
                else if (choice ==8) {
                    //do 15-24 ug for venous test
                    undoTest();
                    holder1.setText("do 15-24 ug for venous test\n");
                }
                //if any other choices do nothing
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (choice ==7) {
                    //do 25-44 ug for capillary test
                    undoTest();
                    holder1.setText("do 25-44 ug for capillary test\n");
                }
                else if (choice ==8) {
                    //do 25-44 ug for venous test
                    undoTest();
                    holder1.setText("do 25-44 ug for venous test\n");
                }
                //if any other choices do nothing
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (choice ==7) {
                    //do 45-59 ug for capillary test
                    undoTest();
                    holder1.setText("do 45-59 ug for capillary test\n");
                }
                else if (choice ==8) {
                    //do 45-59 ug for venous test
                    undoTest();
                    holder1.setText("do 45-59 ug for venous test\n");
                }
                //if any other choices do nothing
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (choice ==7) {
                    //do 60-69 ug for capillary test
                    undoTest();
                    holder1.setText("do 60-69 ug for capillary test\n");
                }
                else if (choice ==8) {
                    //do 60-69 ug for venous test
                    undoTest();
                    holder1.setText("do 60-69 ug for venous test\n");
                }
                //if any other choices do nothing
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (choice ==7) {
                    //do >= 70 ug for capillary test
                    undoTest();
                    holder1.setText("do >=70ug for capillary test\n");
                }
                else if (choice ==8) {
                    //do >= 70 ug for venous test
                    undoTest();
                    holder1.setText("do >=70ug for venous test\n");
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
        if (button3==null){
            button3= findViewById(R.id.button3);
        }
        if (button4==null){
            button4= findViewById(R.id.button4);
        }
        if (button5==null){
            button5= findViewById(R.id.button5);
        }
        if (button6==null){
            button6= findViewById(R.id.button6);
        }
        if (button7==null){
            button7= findViewById(R.id.button7);
        }
        if (button8==null){
            button8= findViewById(R.id.button8);
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

    public void doTest() {
        if (choice==7) {
            getSupportActionBar().setTitle("Capillary Sample");
        }
        else if (choice==8) {
            getSupportActionBar().setTitle("Venous Sample");
        }
        holder1.setText("Select the lead level result(ug/dL): ");
        holder2.setVisibility(View.GONE);
        button3.setVisibility(View.VISIBLE);
        button4.setVisibility(View.VISIBLE);
        button5.setVisibility(View.VISIBLE);
        button6.setVisibility(View.VISIBLE);
        button7.setVisibility(View.VISIBLE);
        button8.setVisibility(View.VISIBLE);

        button1.setText("<5 ug/dL");
        button2.setText("5-9");
        button3.setText("10-14");
        button4.setText("15-24");
        button5.setText("25-44");
        button6.setText("45-59");
        button7.setText("60-69");
        button8.setText(">= 70");

    }

    public void undoTest() {
        button1.setVisibility(View.GONE);
        button2.setVisibility(View.GONE);
        button3.setVisibility(View.GONE);
        button4.setVisibility(View.GONE);
        button5.setVisibility(View.GONE);
        button6.setVisibility(View.GONE);
        button7.setVisibility(View.GONE);
        button8.setVisibility(View.GONE);
    }

    public static void setChoice(int num) {
        choice= num;
    }



}
