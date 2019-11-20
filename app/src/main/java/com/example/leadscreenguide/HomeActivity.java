package com.example.leadscreenguide;

import android.content.Intent;
import android.os.Build;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.drawable.left1);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimary));
        }
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stk.pop();
                if (stk.empty()) {
                    Intent intent= new Intent(v.getContext(), MainActivity.class);
                    startActivity(intent);
                }
                else {
                    choice=stk.peek();
                    doChoice(choice);

                }
            }
        });

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
        getSupportActionBar().setTitle("Who, How, When to Screen");

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


        holder1.setText("\nNYS Public Health Law and Regulations Require Health Care Providers to:\n" +
                "• Test all children at age 1 year and again at age 2 with a blood lead test.\n" +
                "• Assess all children ages 6 months to 6 years at every well child visit for risk of lead exposure and obtain a blood lead test if there is\n" +
                "a positive response to ANY of the questions below in Clinical Lead Risk Assessment Questions for All Children Less than 6 Years. \n• Report point-of-care blood lead test results to the New York State Department of Health in accordance with guidance:\n" +
                "www.health.ny.gov/environmental/lead/laboratories.htm.\n" +
                "• Provide parent or guardian of the child the result of the blood lead test. What Your Child’s Blood Lead Test Means: www.health.ny.gov/publications/2526.pdf provides helpful information to provide with the test results.\n" +
                "• Provide anticipatory guidance to all parents or guardians of children as part of routine care, which may include the Lead Poisoning is a Danger for Every Baby and Child: www.health.ny.gov/publications/2594.pdf."+
                "\nAdditional Testing Recommendations:\n• For capillary blood samples, ensure the child’s hands are washed thoroughly with soap and water. Dry with a clean, low-lint/dust- proof towel or air dry. Once washed, the clean finger must not be allowed to touch any surface, including the child’s other fingers. Any amount of lead present on the finger will contaminate the sample. An alcohol swab is not sufficient for removing contamination from the finger.\n" +
                "• Test all children born outside of the U.S. up to age 16 years old, particularly refugee and internationally adopted children, upon arrival in the U.S. and again 3-6 months after they obtain permanent residences.\n" +
                "• Test children of any age if lead exposure is suspected. All children found to have elevated blood lead levels regardless of age require follow-up services (see Management of Children According to Blood Lead Level p 2).\n" +
                "• Ask the parent or guardian whether they plan to enroll, or if the child is already enrolled, in Medicaid, WIC, preschool/day care, an Early Intervention Program, Head Start, or kindergarten. These programs require blood lead testing documentation, which should be provided.");
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
        doJustText("Clinical Lead Risk Assessment Questions for All Children Less than 6 Years:+\n"+
                "These questions correspond with Does Your Child Need A Lead Test?, which should be used with parents/guardians at child\n" +
                "visits between six months and six years of age. See www.health.ny.gov/publications/6670.pdf.\n" +
                "1. Does your child live in or regularly visit a building with potential lead exposure, such as peeling or chipping paint; recent or ongoing renovation or remodeling; or high levels of lead in the drinking water? Older dwellings (built before 1978) may have lead- based paint. Consider day care, preschool, school, and homes of babysitters or relatives. Children with Medicaid, those entering foster care, and recently arrived refugees are at higher risk for lead poisoning. The risk to a child from past exposure to elevated lead in drinking water depends on many factors including a child’s age, weight, amount of water consumed, and the amount of lead in the water.\n" +
                "2. Has your child spent any significant time outside the U.S. in the past year? All children born outside the U.S. and children visiting other countries for extended periods of time should be tested upon arrival or return to the U.S. due to higher lead risk in many countries.\n" +
                "3. Does your child currently have a sibling, housemate, or playmate with an elevated blood lead level and your child has not been tested?\n" +
                "4. Does your child have developmental disabilities and/or exhibit behaviors that puts him/her at higher risk for lead exposure?\n" +
                "Young children and children with developmental disabilities (autism spectrum disorder and Down syndrome) may have behaviors that place them at higher risk for lead exposure. These may include: pica; putting nonfood items (e.g., fingers, toys, jewelry, keys, or soil) in their mouth; mouthing painted surfaces; any behaviors that disturb painted surfaces.\n" +
                "5. Does your child have frequent contact with an adult whose job or hobby involves exposure to lead? An adult may bring home lead from a job or hobby, such as house painting; plumbing; construction; auto repair; welding; battery recycling; lead smelting; jewelry, stained glass or pottery making; fishing (lead in sinkers); making or shooting firearms; and collecting lead or pewter figurines.\n" +
                "6. Does your family use traditional medicine, health remedies, cosmetics, powders, spices, or food from other countries? Lead can be in items such as Ayurvedic medicines, alkohl, azarcon (Alarcon, luiga, rueda, coral), greta, litargirio, ghasard, pay-loo-ah, bala goli, Daw Tway, and Daw Kyin; cosmetics including kohl, surma, and sindoor; and some candies and products from other countries, particularly Mexico. See www.health.ny.gov/publications/6517.pdf.\n" +
                "7. Does your family cook, store, or serve food in crystal, pewter, or pottery from other countries? Lead exposure risk from pottery is higher with old, cracked/chipped, and painted china and in pottery from other countries particularly from Latin America or Asia. Also, imported samovars, urns, and kettles could be soldered with lead. See www.health.ny.gov/publications/6517.pdf.");

    }
    public void doChoice5() {
        getSupportActionBar().setTitle("High Lead Level Evaluation");
        doJustText("HISTORY:\n"+"\nCurrent Status: Symptoms of lead exposure; previous blood lead test results; family history of lead poisoning; dietary history; development; country of birth; extended travel outside the U.S.; recent immigrant, refugee or adoptee.\n" +
                "Child Behaviors: Pica; degree of hand-to-mouth activity; mouthing/chewing on window sills, furniture, keys, and toys; frequent playing in soil; inadequate hand washing before eating.\n" +
                "Potential Paint Sources: Age and condition of home and other places child spends time (day care, relatives); evidence of chewed or peeling paint on woodwork, furniture, or toys; recent renovations; condition of windows; methods used to control dust and dirt (wet mopping vs. sweeping, use of door mats).\n" +
                "Potential Non-Paint Sources: Use of imported cosmetics, health remedies, spices, or children’s jewelry; food served, stored, or prepared in pottery from other countries particularly from Latin America or Asia, painted china, pewter, or leaded crystal; bare soil in outdoor play areas.\n" +
                "Caregiver Exposures and Behaviors: Occupations and hobbies of household members; painted or unusual materials burned in fireplaces or near home.\n" +
                "    PHYSICAL EXAM: Include complete neurologic exam.\n" +
                "NUTRITIONAL ASSESSMENT: Evaluate growth and adequacy of diet, including iron, vitamin C, and calcium intake with follow-up anticipatory\n" +
                "nutritional counseling.\n" +
                "DEVELOPMENTAL ASSESSMENT: Evaluate achievement of, or regression from, milestones, particularly in psychosocial and language domains. This should include use of a standardized developmental screening tool8 and follow-up anticipatory developmental counseling.\n" +
                "LABORATORY TESTS: Evaluate iron status and hemoglobin or hematocrit. Arrange follow-up blood lead testing per the Management of Children According to Blood Lead Level p.2.\n" +
                "REFER TO: For suspected developmental delays, refer to Early Intervention Program for children less than three years old or the child’s school district for children three years or older, and, if appropriate, a pediatric developmental specialist. For nutritional assistance, refer to/for WIC and SNAP Benefits.");

    }
    public void doChoice6() {
        getSupportActionBar().setTitle("Differing Guidelines");
        doJustText("it worked way 6");

    }

    public void doChoice7(){
        getSupportActionBar().setTitle("Lead Exposure Risk Survey");
        doJustText("Clinical Lead Risk Assessment Questions for All Children Less than 6 Years:+\n"+
                "These questions correspond with Does Your Child Need A Lead Test?, which should be used with parents/guardians at child\n" +
                "visits between six months and six years of age. See www.health.ny.gov/publications/6670.pdf.\n" +
                "1. Does your child live in or regularly visit a building with potential lead exposure, such as peeling or chipping paint; recent or ongoing renovation or remodeling; or high levels of lead in the drinking water? Older dwellings (built before 1978) may have lead- based paint. Consider day care, preschool, school, and homes of babysitters or relatives. Children with Medicaid, those entering foster care, and recently arrived refugees are at higher risk for lead poisoning. The risk to a child from past exposure to elevated lead in drinking water depends on many factors including a child’s age, weight, amount of water consumed, and the amount of lead in the water.\n" +
                "2. Has your child spent any significant time outside the U.S. in the past year? All children born outside the U.S. and children visiting other countries for extended periods of time should be tested upon arrival or return to the U.S. due to higher lead risk in many countries.\n" +
                "3. Does your child currently have a sibling, housemate, or playmate with an elevated blood lead level and your child has not been tested?\n" +
                "4. Does your child have developmental disabilities and/or exhibit behaviors that puts him/her at higher risk for lead exposure?\n" +
                "Young children and children with developmental disabilities (autism spectrum disorder and Down syndrome) may have behaviors that place them at higher risk for lead exposure. These may include: pica; putting nonfood items (e.g., fingers, toys, jewelry, keys, or soil) in their mouth; mouthing painted surfaces; any behaviors that disturb painted surfaces.\n" +
                "5. Does your child have frequent contact with an adult whose job or hobby involves exposure to lead? An adult may bring home lead from a job or hobby, such as house painting; plumbing; construction; auto repair; welding; battery recycling; lead smelting; jewelry, stained glass or pottery making; fishing (lead in sinkers); making or shooting firearms; and collecting lead or pewter figurines.\n" +
                "6. Does your family use traditional medicine, health remedies, cosmetics, powders, spices, or food from other countries? Lead can be in items such as Ayurvedic medicines, alkohl, azarcon (Alarcon, luiga, rueda, coral), greta, litargirio, ghasard, pay-loo-ah, bala goli, Daw Tway, and Daw Kyin; cosmetics including kohl, surma, and sindoor; and some candies and products from other countries, particularly Mexico. See www.health.ny.gov/publications/6517.pdf.\n" +
                "7. Does your family cook, store, or serve food in crystal, pewter, or pottery from other countries? Lead exposure risk from pottery is higher with old, cracked/chipped, and painted china and in pottery from other countries particularly from Latin America or Asia. Also, imported samovars, urns, and kettles could be soldered with lead. See www.health.ny.gov/publications/6517.pdf.");

    }

    public void doChoice8(){
        doTest();
    }

    public void doChoice9(){
        doTest();
    }

    public void doChoice10(){
        doJustText("When to confirm with venous testing: \n- No confirmation needed. Average BLL for U.S. children ages 1-5 years is 1.4 μg/dL");
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
