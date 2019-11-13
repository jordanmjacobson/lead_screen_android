package com.example.leadscreenguide;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Stack;


public class HomeActivity extends AppCompatActivity {

    private static int choice= 0;

    private static Stack<Integer> stk= new Stack<>();

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

    private Button button9;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
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
                    setChoice(7);
                    doChoice(choice);
                }
                else if (choice== 2) {
                    //open capillary test
                    setChoice(8);
                    doChoice(choice);
                }
                else if (choice ==8) {
                    //do less than 5 ug for capillary test
                    setChoice(10);
                    doChoice(10);
                }
                else if (choice ==9) {
                    //do less than 5 ug for venous test
                    setChoice(18);
                    doChoice(18);
                }
                //if any other choices do nothing

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (choice == 2) {
                    //open venous test
                    setChoice(9);
                    doChoice(choice);
                }
                else if (choice ==8) {
                    //do 5-9 ug for capillary test
                    setChoice(11);
                    doChoice(choice);
                }
                else if (choice ==9) {
                    //do 5-9 ug for venous test
                    setChoice(19);
                    doChoice(choice);
                }
                //if any other choices do nothing
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (choice ==8) {
                    //do 10-14 ug for capillary test
                    setChoice(12);
                    doChoice(choice);
                }
                else if (choice ==9) {
                    //do 10-14 ug for venous test
                    setChoice(20);
                    doChoice(choice);
                }
                //if any other choices do nothing
            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (choice ==8) {
                    //do 15-24 ug for capillary test
                    setChoice(13);
                    doChoice(choice);
                }
                else if (choice ==9) {
                    //do 15-24 ug for venous test
                    setChoice(21);
                    doChoice(choice);
                }
                //if any other choices do nothing
            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (choice ==8) {
                    //do 25-44 ug for capillary test
                    setChoice(14);
                    doChoice(choice);
                }
                else if (choice ==9) {
                    //do 25-44 ug for venous test
                    setChoice(22);
                    doChoice(choice);
                }
                //if any other choices do nothing
            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (choice ==8) {
                    //do 45-59 ug for capillary test
                    setChoice(15);
                    doChoice(choice);
                }
                else if (choice ==9) {
                    //do 45-59 ug for venous test
                    setChoice(23);
                    doChoice(choice);
                }
                //if any other choices do nothing
            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (choice ==8) {
                    //do 60-69 ug for capillary test
                    setChoice(16);
                    doChoice(choice);
                }
                else if (choice ==9) {
                    //do 60-69 ug for venous test
                    setChoice(24);
                    doChoice(choice);
                }
                //if any other choices do nothing
            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (choice ==8) {
                    //do >= 70 ug for capillary test
                    setChoice(17);
                    doChoice(choice);
                }
                else if (choice ==9) {
                    //do >= 70 ug for venous test
                    setChoice(25);
                    doChoice(choice);
                }
                //if any other choices do nothing
            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stk.pop();
                if (stk.empty()) {
                    Intent intent= new Intent(view.getContext(), MainActivity.class);
                    startActivity(intent);
                }
                else {
                    choice=stk.peek();
                    doChoice(choice);

                }
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
        if (button9==null){
            button9= findViewById(R.id.button9);
        }
    }

    public static void setChoice(int num) {
        stk.push(num);
        choice= num;
    }

    public void doChoice(int num) {

        //first choice is text and one button that leads to text (choice 7)
        if (num==1) {
            doChoice1();
        }
        //second choice has 2 textviews and 2 buttons that each lead to cap (ch8) and vein test(ch9)
        //ch8 leads to 8 choices based on capillary levels(ch10-17) and ch9 leads to 8 choices
        // on venous levels(ch18-25) which are all just text
        else if (num==2) {
            doChoice2();
        }
        //choices 3-6 are easy cause they are just text
        else if (num==3) {
            doChoice3();
        }
        else if (num==4) {
            doChoice4();
        }
        else if (num==5) {
            doChoice5();
        }
        else if (num==6) {
            doChoice6();
        }
        //choice 7 is the survey
        else if (num==7) {
            doChoice7();
        }
        else if (num==8) {
            doChoice8();
        }
        else if (num==9) {
            doChoice9();
        }
        else if (num==10) {
            doChoice10();
        }
        else if (num==11) {
            doChoice11();
        }
        else if (num==12) {
            doChoice12();
        }
        else if (num==13) {
            doChoice13();
        }
        else if (num==14) {
            doChoice14();
        }
        else if (num==15) {
            doChoice15();
        }
        else if (num==16) {
            doChoice16();
        }
        else if (num==17) {
            doChoice17();
        }
        else if (num==18) {
            doChoice18();
        }
        else if (num==19) {
            doChoice19();
        }
        else if (num==20) {
            doChoice20();
        }
        else if (num==21) {
            doChoice21();
        }
        else if (num==22) {
            doChoice22();
        }
        else if (num==23) {
            doChoice23();
        }
        else if (num==24) {
            doChoice24();
        }
        else if (num==25) {
            doChoice25();
        }
    }
    public void doChoice1() {
        getSupportActionBar().setTitle("Who,How,When to Screen");

        holder1.setVisibility(View.VISIBLE);
        holder2.setVisibility(View.GONE);
        button1.setVisibility(View.VISIBLE);
        button2.setVisibility(View.GONE);
        button3.setVisibility(View.GONE);
        button4.setVisibility(View.GONE);
        button5.setVisibility(View.GONE);
        button6.setVisibility(View.GONE);
        button7.setVisibility(View.GONE);
        button8.setVisibility(View.GONE);


        holder1.setText("it worked way1");
        button1.setText("Lead Exposure Risk Survey");
    }
    public void doChoice2() {
        getSupportActionBar().setTitle("How To Manage Lead Levels");

        holder1.setVisibility(View.VISIBLE);
        holder2.setVisibility(View.VISIBLE);
        button1.setVisibility(View.VISIBLE);
        button2.setVisibility(View.VISIBLE);
        button3.setVisibility(View.GONE);
        button4.setVisibility(View.GONE);
        button5.setVisibility(View.GONE);
        button6.setVisibility(View.GONE);
        button7.setVisibility(View.GONE);
        button8.setVisibility(View.GONE);

        holder1.setText("Is the sample from venous phlebotomy or from capillary fingerstick?");
        button1.setText("Capillary Test");
        button2.setText("Venous Test");
        holder2.setText("*Subsequently, Blood Lead Level frequently abbreviated BLL");
    }
    public void doChoice3() {
        getSupportActionBar().setTitle("Signs/Symptoms of Lead Poisoning");
        doJustText("it worked way 3");

    }
    public void doChoice4() {
        getSupportActionBar().setTitle("Lead Exposure Risk Survey");
        doJustText("it worked way 4");

    }
    public void doChoice5() {
        getSupportActionBar().setTitle("High Lead Level Evaluation");
        doJustText("it worked way 5");

    }
    public void doChoice6() {
        getSupportActionBar().setTitle("Differing Guidelines");
        doJustText("it worked way 6");

    }

    public void doChoice7(){
        getSupportActionBar().setTitle("Lead Exposure Risk Survey");
        doJustText("survey stuff would go here");
    }

    public void doChoice8(){
        doTest();
    }

    public void doChoice9(){
        doTest();
    }

    public void doChoice10(){
        doJustText("do less than 5 ug for capillary test\n");
    }

    public void doChoice11(){
        doJustText("do 5-9 ug for capillary test\n");
    }

    public void doChoice12(){
        doJustText("do 10-14 ug for capillary test\n");
    }

    public void doChoice13(){
        doJustText("do 15-24 ug for capillary test\n");
    }

    public void doChoice14(){
        doJustText("do 25-44 ug for capillary test\n");
    }

    public void doChoice15(){
        doJustText("do 45-59 ug for capillary test\n");
    }

    public void doChoice16(){
        doJustText("do 60-69 ug for capillary test\n");
    }

    public void doChoice17(){
        doJustText("do >=70ug for capillary test\n");
    }

    public void doChoice18(){
        doJustText("do less than 5 ug for venous test\n");
    }

    public void doChoice19(){
        doJustText("do 5-9 ug for venous test\n");
    }

    public void doChoice20(){
        doJustText("do 10-14 ug for venous test\n");
    }

    public void doChoice21(){
        doJustText("do 15-24 ug for venous test\n");
    }

    public void doChoice22(){
        doJustText("do 25-44 ug for venous test\n");
    }

    public void doChoice23(){
        doJustText("do 45-59 ug for venous test\n");
    }

    public void doChoice24(){
        doJustText("do 60-69 ug for venous test\n");
    }

    public void doChoice25(){
        doJustText("do >=70ug for venous test\n");
    }


    public void doTest() {
        if (choice==8) {
            getSupportActionBar().setTitle("Capillary Sample");
        }
        else if (choice==9) {
            getSupportActionBar().setTitle("Venous Sample");
        }
        holder1.setVisibility(View.VISIBLE);
        holder2.setVisibility(View.GONE);
        button3.setVisibility(View.VISIBLE);
        button4.setVisibility(View.VISIBLE);
        button5.setVisibility(View.VISIBLE);
        button6.setVisibility(View.VISIBLE);
        button7.setVisibility(View.VISIBLE);
        button8.setVisibility(View.VISIBLE);

        holder1.setText("Select the lead level result(ug/dL): ");
        button1.setText("<5 ug/dL");
        button2.setText("5-9");
        button3.setText("10-14");
        button4.setText("15-24");
        button5.setText("25-44");
        button6.setText("45-59");
        button7.setText("60-69");
        button8.setText(">= 70");

    }

    public void doJustText(String text) {
        holder1.setVisibility(View.VISIBLE);
        holder1.setText(text);
        holder2.setVisibility(View.GONE);
        button1.setVisibility(View.GONE);
        button2.setVisibility(View.GONE);
        button3.setVisibility(View.GONE);
        button4.setVisibility(View.GONE);
        button5.setVisibility(View.GONE);
        button6.setVisibility(View.GONE);
        button7.setVisibility(View.GONE);
        button8.setVisibility(View.GONE);
    }

}
