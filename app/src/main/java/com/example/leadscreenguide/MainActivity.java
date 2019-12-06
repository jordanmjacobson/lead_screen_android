package com.example.leadscreenguide;

import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Stack;
import android.text.method.LinkMovementMethod;
import android.text.Html;
import android.text.Spanned;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.LabelVisibilityMode;

public class MainActivity extends AppCompatActivity {

    private static int choice;

    private static Stack<Integer> stk= new Stack<>();

    private static LinearLayout notFrag;

    private static LinearLayout frag;

    private static TextView holder1;

    private static TextView holder2;

    private static Button button1;

    private static Button button2;

    private static Button button3;

    private static Button button4;

    private static Button button5;

    private static Button button6;

    private static ActionBar act;

    private static Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControls();
        setSupportActionBar(toolbar);
        act= getSupportActionBar();
        toolbar.setNavigationIcon(R.drawable.left1);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_disclaimer, R.id.navigation_about, R.id.navigation_references).build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimary));
        }
        doChoice(choice);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (stk.size()>0) {
                    stk.pop();
                    if (stk.empty()) {
                        choice=0;
                        doChoice(choice);
                    }

                    else {
                        choice = stk.peek();
                        doChoice(choice);
                    }

                }
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (choice== 1) {
                    setChoice(7);
                    doChoice(choice);
                }
                else if (choice== 2) {
                    setChoice(8);
                    doChoice(choice);
                }
                else if (choice ==8) {
                    setChoice(10);
                    doChoice(10);
                }
                else if (choice ==9) {
                    setChoice(18);
                    doChoice(18);
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (choice == 2) {
                    setChoice(9);
                    doChoice(choice);
                }
                else if (choice ==8) {
                    setChoice(11);
                    doChoice(choice);
                }
                else if (choice ==9) {
                    setChoice(19);
                    doChoice(choice);
                }
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (choice ==8) {
                    setChoice(12);
                    doChoice(choice);
                }
                else if (choice ==9) {
                    setChoice(20);
                    doChoice(choice);
                }
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (choice ==8) {
                    setChoice(13);
                    doChoice(choice);
                }
                else if (choice ==9) {
                    setChoice(21);
                    doChoice(choice);
                }
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (choice ==8) {
                    setChoice(14);
                    doChoice(choice);
                }
                else if (choice ==9) {
                    setChoice(22);
                    doChoice(choice);
                }
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (choice ==8) {
                    setChoice(15);
                    doChoice(choice);
                }
                else if (choice ==9) {
                    setChoice(23);
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
        if (notFrag==null) {
            notFrag= findViewById(R.id.notFrag);
        }
        if (frag==null) {
            frag= findViewById(R.id.frag);
        }
        if (toolbar==null) {
            toolbar = findViewById(R.id.toolbar);
        }
    }

    public static void setChoice(int num) {
        stk.push(num);
        choice= num;
    }

    public static void doChoice(int num) {
            if (num==0) {
                if (act!=null) {
                    act.setTitle(R.string.app_name);
                }
                setFragOn();
            }
            else {
                setFragOff();
                if (num == 1) {
                    if (act!=null) {
                        act.setTitle("Who, How, When to Screen");
                    }
                    holder1.setVisibility(View.VISIBLE);
                    holder2.setVisibility(View.GONE);
                    button1.setVisibility(View.VISIBLE);
                    button2.setVisibility(View.GONE);
                    button3.setVisibility(View.GONE);
                    button4.setVisibility(View.GONE);
                    button5.setVisibility(View.GONE);
                    button6.setVisibility(View.GONE);
                    holder1.setMovementMethod(LinkMovementMethod.getInstance());
                    holder1.setText(toSpan("<strong><h3>NYS Public Health Law and Regulations Require Health Care Providers to:</h3></strong>"));
                    holder1.append(
                            "• Test all children at age 1 year and again at age 2 with a blood lead test.\n" +
                                    "\n• Assess all children ages 6 months to 6 years at every well child visit for risk of lead exposure and obtain a blood lead test if there is\n" +
                                    "a positive response to ANY of the questions below in Clinical Lead Risk Assessment Questions for All Children Less than 6 Years. \n" +
                                    "\n• Report point-of-care blood lead test results to the New York State Department of Health in accordance with guidance:\n\n");
                    holder1.append(toSpan("<a href=\"https://www.health.ny.gov/environmental/lead/laboratories.htm\">See www.health.ny.gov/environmental/lead/laboratories.htm</a>"));
                    holder1.append(
                            "\n\n• Provide parent or guardian of the child the result of the blood lead test. What Your Child’s Blood Lead Test Means: The link below provides helpful information to provide with the test results.\n\n");
                    holder1.append(toSpan("<a href=\"https://www.health.ny.gov/publications/2526.pdf\">See www.health.ny.gov/publications/2526.pdf</a>"));
                    holder1.append("\n\n• Provide anticipatory guidance to all parents or guardians of children as part of routine care, which may include the Lead Poisoning is a Danger for Every Baby and Child:\n\n");
                    holder1.append(toSpan("<a href=\"https://www.health.ny.gov/publications/2594.pdf\">See www.health.ny.gov/publications/2594.pdf</a>"));
                    holder1.append("\n\n");
                    holder1.append(toSpan("<strong><h3>Additional Testing Recommendations:</h3></strong>"));
                    holder1.append(
                            "• For capillary blood samples, ensure the child’s hands are washed thoroughly with soap and water. Dry with a clean, low-lint/dust- proof towel or air dry. Once washed, the clean finger must not be allowed to touch any surface, including the child’s other fingers. Any amount of lead present on the finger will contaminate the sample. An alcohol swab is not sufficient for removing contamination from the finger.\n" + "\n• Test all children born outside of the U.S. up to age 16 years old, particularly refugee and internationally adopted children, upon arrival in the U.S. and again 3-6 months after they obtain permanent residences.\n" +
                                    "\n• Test children of any age if lead exposure is suspected. All children found to have elevated blood lead levels regardless of age require follow-up services (see Management of Children According to Blood Lead Level p 2).\n" +
                                    "\n• Ask the parent or guardian whether they plan to enroll, or if the child is already enrolled, in Medicaid, WIC, preschool/day care, an Early Intervention Program, Head Start, or kindergarten. These programs require blood lead testing documentation, which should be provided.");
                    button1.setText("Lead Exposure Risk Survey");
                }
                else if (num == 2) {
                    if (act!=null) {
                        act.setTitle("How To Manage Lead Levels");
                    }
                    holder1.setVisibility(View.VISIBLE);
                    holder2.setVisibility(View.VISIBLE);
                    button1.setVisibility(View.VISIBLE);
                    button2.setVisibility(View.VISIBLE);
                    button3.setVisibility(View.GONE);
                    button4.setVisibility(View.GONE);
                    button5.setVisibility(View.GONE);
                    button6.setVisibility(View.GONE);
                    holder1.setText(toSpan("<strong>Is the sample from venous phlebotomy or from capillary fingerstick?</strong>"));
                    button1.setText("Capillary Test");
                    button2.setText("Venous Test");
                    holder2.setText("Note: On May 17th, 2017 the U.S. Food and Drug Administration advised that Magellan Diagnostics’ LeadCare® analyzers should no longer be used with venous blood samples. ");
                    holder2.append(toSpan("<a href=\"https://emergency.cdc.gov/han/han00403.asp\">See https://emergency.cdc.gov/han/han00403.asp </a>"));
                    holder2.append("\n\n• All confirmatory and follow-up venous samples must be analyzed by a New York State approved lab for toxicology-blood lead-comprehensive testing. 1\n" +
                            "\n• The higher the blood lead level, the more urgent the need for confirmatory venous testing and timely follow-up testing.\n" +
                            "\n• If repeated attempts to obtain a venous confirmatory sample are unsuccessful, a second capillary sample may be used to guide follow up actions to avoid significant delays in management. However, as capillary samples can yield frequent false\n" +
                            "positives, a venous confirmatory sample should still be pursued.\n");
                }
                else if (num == 3) {
                    /*gathered from old app*/
                    if (act!=null) {
                        act.setTitle("Signs & Symptoms");
                    }
                    doTextScreen();
                    holder1.setText(toSpan("<strong>Signs and Symptoms of Lead Poisoning</strong>"));
                    holder1.append(
                            "\n\nLead poisoning in children is usually asymptomatic, even at higher levels of exposure. Screening is so important because nothing else may suggest lead poisoning.\n\n"+
                            "When lead exposure does cause clinical signs and symptoms, the following may be observed.\n\n" );
                    holder1.append(toSpan("<i>Lowest Exposure: </i>"));
                    holder1.append("\n- Decreased learning and memory" +
                            "\n- Decreased verbal ability"+
                            "\n- Early signs of hyperactivity/ADHD"+
                            "\n- Lowered IQ"+
                            "\n- Impaired speech and hearing\n\n");
                    holder1.append(toSpan("<i>Low Exposure: </i>"));
                    holder1.append("\n- Myalgia" +
                            "\n- Mild fatigue"+
                            "\n- Irritability"+
                            "\n- Lethargy"+
                            "\n- Occasional abdominal discomfort\n\n");
                    holder1.append(toSpan("<i>Moderate Exposure: </i>"));
                    holder1.append("\n- Arthralgia" +
                            "\n- General fatigue"+
                            "\n- Difficulty concentrating"+
                            "\n- Muscular exhaustibility"+
                            "\n- Tremor"+
                            "\n- Headache"+
                            "\n- Diffuse Abdominal Pain"+
                            "\n- Vomiting"+
                            "\n- Weight loss"+
                            "\n- Constipation\n\n");
                    holder1.append(toSpan("<i>High Exposure: </i>"));
                    holder1.append("\n- Arthralgia" +
                            "\n- Paresis"+
                            "\n- Colic" +
                            "\n- Lead lines (blue-black) on gingiva" +
                            "\n- Paralysis"+
                            "\n- Encephalopathy"+
                            "\n- Seizures"+
                            "\n- Changes in consciousness"+
                            "\n- Coma"+
                            "\n- Death\n\n");
                }
                else if (num == 4) {
                    if (act!=null) {
                        act.setTitle("Lead Exposure Risk Survey");
                    }
                    doTextScreen();
                    holder1.setMovementMethod(LinkMovementMethod.getInstance());
                    holder1.setText(toSpan("<strong><h3>Clinical Lead Risk Assessment Questions for All Children Less than 6 Years:</h3></strong>"));
                    holder1.append(toSpan("<i>These questions correspond with 'Does Your Child Need A Lead Test?' , which should be used with parents/guardians at child visits between six months and six years of age.</i>"));
                    holder1.append("\n\n");
                    holder1.append(toSpan("<a href=\"https:://www.health.ny.gov/publications/6670.pdf\">See www.health.ny.gov/publications/6670.pdf</a>"));
                    holder1.append("\n\n");
                    holder1.append(toSpan("<strong>1. Does your child live in or regularly visit a building with potential lead exposure, such as peeling or chipping paint; recent or ongoing renovation or remodeling; or high levels of lead in the drinking water?</strong>"));
                    holder1.append("\n\nOlder dwellings (built before 1978) may have lead- based paint. Consider day care, preschool, school, and homes of babysitters or relatives. Children with Medicaid, those entering foster care, and recently arrived refugees are at higher risk for lead poisoning. The risk to a child from past exposure to elevated lead in drinking water depends on many factors including a child’s age, weight, amount of water consumed, and the amount of lead in the water.\n\n");
                    holder1.append(toSpan("<strong>2. Has your child spent any significant time outside the U.S. in the past year?</strong>"));
                    holder1.append(" \n\nAll children born outside the U.S. and children visiting other countries for extended periods of time should be tested upon arrival or return to the U.S. due to higher lead risk in many countries.\n\n");
                    holder1.append(toSpan("<strong>3. Does your child currently have a sibling, housemate, or playmate with an elevated blood lead level and your child has not been tested?</strong>"));
                    holder1.append("\n\n");
                    holder1.append(toSpan("<strong>4. Does your child have developmental disabilities and/or exhibit behaviors that puts him/her at higher risk for lead exposure?</strong>"));
                    holder1.append("\n\nYoung children and children with developmental disabilities (autism spectrum disorder and Down syndrome) may have behaviors that place them at higher risk for lead exposure. These may include: pica; putting nonfood items (e.g., fingers, toys, jewelry, keys, or soil) in their mouth; mouthing painted surfaces; any behaviors that disturb painted surfaces.\n\n");
                    holder1.append(toSpan("<strong>5. Does your child have frequent contact with an adult whose job or hobby involves exposure to lead? </strong>"));
                    holder1.append("\n\nAn adult may bring home lead from a job or hobby, such as house painting; plumbing; construction; auto repair; welding; battery recycling; lead smelting; jewelry, stained glass or pottery making; fishing (lead in sinkers); making or shooting firearms; and collecting lead or pewter figurines.\n\n");
                    holder1.append(toSpan("<strong>6. Does your family use traditional medicine, health remedies, cosmetics, powders, spices, or food from other countries? </strong>"));
                    holder1.append("\n\nLead can be in items such as Ayurvedic medicines, alkohl, azarcon (Alarcon, luiga, rueda, coral), greta, litargirio, ghasard, pay-loo-ah, bala goli, Daw Tway, and Daw Kyin; cosmetics including kohl, surma, and sindoor; and some candies and products from other countries, particularly Mexico.\n\n");
                    holder1.append(toSpan("<a href=\"https://www.health.ny.gov/publications/6517.pdf\">See www.health.ny.gov/publications/6517.pdf</a>"));
                    holder1.append("\n\n");
                    holder1.append(toSpan("<strong>7. Does your family cook, store, or serve food in crystal, pewter, or pottery from other countries?</strong>"));
                    holder1.append("\n\n Lead exposure risk from pottery is higher with old, cracked/chipped, and painted china and in pottery from other countries particularly from Latin America or Asia. Also, imported samovars, urns, and kettles could be soldered with lead.)\n\n");
                    holder1.append(toSpan("<a href=\"https://www.health.ny.gov/publications/6517.pdf\">See www.health.ny.gov/publications/6517.pdf</a>"));
                    holder1.append("\n\n");
                }
                else if (num == 5) {
                    if (act!=null) {
                        act.setTitle("High Lead Level Evaluation");
                    }
                    doTextScreen();
                    holder1.setText(toSpan("<strong><h3>High Lead Level Evaluation</h3></strong>"));
                    holder1.append(toSpan("<strong>HISTORY:</strong>"));
                    holder1.append("\n\n");
                    holder1.append(toSpan("<i>Current Status: </i>"));
                    holder1.append("Symptoms of lead exposure; previous blood lead test results; family history of lead poisoning; dietary history; development; country of birth; extended travel outside the U.S.; recent immigrant, refugee or adoptee.\n\n");
                    holder1.append(toSpan("<i>Child Behaviors: </i>"));
                    holder1.append("Pica; degree of hand-to-mouth activity; mouthing/chewing on window sills, furniture, keys, and toys; frequent playing in soil; inadequate hand washing before eating.\n\n");
                    holder1.append(toSpan("<i>Potential Paint Sources: </i>"));
                    holder1.append("Age and condition of home and other places child spends time (day care, relatives); evidence of chewed or peeling paint on woodwork, furniture, or toys; recent renovations; condition of windows; methods used to control dust and dirt (wet mopping vs. sweeping, use of door mats).\n\n");
                    holder1.append(toSpan("<i>Potential Non-Paint Sources: </i>"));
                    holder1.append("Use of imported cosmetics, health remedies, spices, or children’s jewelry; food served, stored, or prepared in pottery from other countries particularly from Latin America or Asia, painted china, pewter, or leaded crystal; bare soil in outdoor play areas.\n\n");
                    holder1.append(toSpan("<i>Caregiver Exposures and Behaviors: </i>"));
                    holder1.append("Occupations and hobbies of household members; painted or unusual materials burned in fireplaces or near home.\n\n");
                    holder1.append(toSpan("<strong>PHYSICAL EXAM: </strong>"));
                    holder1.append("\nInclude complete neurologic exam.\n\n" );
                    holder1.append(toSpan("<strong>NUTRITIONAL ASSESSMENT: </strong>"));
                    holder1.append("\nEvaluate growth and adequacy of diet, including iron, vitamin C, and calcium intake with follow-up anticipatory nutritional counseling.\n\n");
                    holder1.append(toSpan("<strong>DEVELOPMENTAL ASSESSMENT: </strong>"));
                    holder1.append("\nEvaluate achievement of, or regression from, milestones, particularly in psychosocial and language domains. This should include use of a standardized developmental screening tool and follow-up anticipatory developmental counseling.\n\n");
                    holder1.append(toSpan("<strong>LABORATORY TESTS: </strong>"));
                    holder1.append("\nEvaluate iron status and hemoglobin or hematocrit. Arrange follow-up blood lead testing per the Management of Children According to Blood Lead Level p.2.\n\n");
                    holder1.append(toSpan("<strong>REFER TO: </strong>"));
                    holder1.append("\nFor suspected developmental delays, refer to Early Intervention Program for children less than three years old or the child’s school district for children three years or older, and, if appropriate, a pediatric developmental specialist. For nutritional assistance, refer to/for WIC and SNAP Benefits.\n\n");
                }
                else if (num == 6) {
                    if (act!=null) {
                        act.setTitle("Differing Guidelines");
                    }
                    doTextScreen();
                    holder1.setText("this screen still needs text");
                }
                else if (num == 7) {
                    if (act!=null) {
                        act.setTitle("Lead Exposure Risk Survey");
                    }
                    doTextScreen();
                    holder1.setMovementMethod(LinkMovementMethod.getInstance());
                    holder1.setText(toSpan("<strong><h3>Clinical Lead Risk Assessment Questions for All Children Less than 6 Years:</h3></strong>"));
                    holder1.append(toSpan("<i>These questions correspond with 'Does Your Child Need A Lead Test?' , which should be used with parents/guardians at child visits between six months and six years of age.</i>"));
                    holder1.append("\n\n");
                    holder1.append(toSpan("<a href=\"https:://www.health.ny.gov/publications/6670.pdf\">See www.health.ny.gov/publications/6670.pdf</a>"));
                    holder1.append("\n\n");
                    holder1.append(toSpan("<strong>1. Does your child live in or regularly visit a building with potential lead exposure, such as peeling or chipping paint; recent or ongoing renovation or remodeling; or high levels of lead in the drinking water?</strong>"));
                    holder1.append("\n\nOlder dwellings (built before 1978) may have lead- based paint. Consider day care, preschool, school, and homes of babysitters or relatives. Children with Medicaid, those entering foster care, and recently arrived refugees are at higher risk for lead poisoning. The risk to a child from past exposure to elevated lead in drinking water depends on many factors including a child’s age, weight, amount of water consumed, and the amount of lead in the water.\n\n");
                    holder1.append(toSpan("<strong>2. Has your child spent any significant time outside the U.S. in the past year?</strong>"));
                    holder1.append(" \n\nAll children born outside the U.S. and children visiting other countries for extended periods of time should be tested upon arrival or return to the U.S. due to higher lead risk in many countries.\n\n");
                    holder1.append(toSpan("<strong>3. Does your child currently have a sibling, housemate, or playmate with an elevated blood lead level and your child has not been tested?</strong>"));
                    holder1.append("\n\n");
                    holder1.append(toSpan("<strong>4. Does your child have developmental disabilities and/or exhibit behaviors that puts him/her at higher risk for lead exposure?</strong>"));
                    holder1.append("\n\nYoung children and children with developmental disabilities (autism spectrum disorder and Down syndrome) may have behaviors that place them at higher risk for lead exposure. These may include: pica; putting nonfood items (e.g., fingers, toys, jewelry, keys, or soil) in their mouth; mouthing painted surfaces; any behaviors that disturb painted surfaces.\n\n");
                    holder1.append(toSpan("<strong>5. Does your child have frequent contact with an adult whose job or hobby involves exposure to lead? </strong>"));
                    holder1.append("\n\nAn adult may bring home lead from a job or hobby, such as house painting; plumbing; construction; auto repair; welding; battery recycling; lead smelting; jewelry, stained glass or pottery making; fishing (lead in sinkers); making or shooting firearms; and collecting lead or pewter figurines.\n\n");
                    holder1.append(toSpan("<strong>6. Does your family use traditional medicine, health remedies, cosmetics, powders, spices, or food from other countries? </strong>"));
                    holder1.append("\n\nLead can be in items such as Ayurvedic medicines, alkohl, azarcon (Alarcon, luiga, rueda, coral), greta, litargirio, ghasard, pay-loo-ah, bala goli, Daw Tway, and Daw Kyin; cosmetics including kohl, surma, and sindoor; and some candies and products from other countries, particularly Mexico.\n\n");
                    holder1.append(toSpan("<a href=\"https://www.health.ny.gov/publications/6517.pdf\">See www.health.ny.gov/publications/6517.pdf</a>"));
                    holder1.append("\n\n");
                    holder1.append(toSpan("<strong>7. Does your family cook, store, or serve food in crystal, pewter, or pottery from other countries?</strong>"));
                    holder1.append("\n\n Lead exposure risk from pottery is higher with old, cracked/chipped, and painted china and in pottery from other countries particularly from Latin America or Asia. Also, imported samovars, urns, and kettles could be soldered with lead.)\n\n");
                    holder1.append(toSpan("<a href=\"https://www.health.ny.gov/publications/6517.pdf\">See www.health.ny.gov/publications/6517.pdf</a>"));
                    holder1.append("\n\n");
                }
                else if (num == 8 || num == 9) {
                    if (choice==8) {
                        if (act!=null) {
                            act.setTitle("Capillary Sample");
                        }
                    }
                    else {
                        if (act!=null) {
                            act.setTitle("Venous Sample");
                        }
                    }
                    holder1.setVisibility(View.VISIBLE);
                    holder2.setVisibility(View.VISIBLE);
                    button1.setVisibility(View.VISIBLE);
                    button2.setVisibility(View.VISIBLE);
                    button3.setVisibility(View.VISIBLE);
                    button4.setVisibility(View.VISIBLE);
                    button5.setVisibility(View.VISIBLE);
                    button6.setVisibility(View.VISIBLE);
                    holder1.setText(toSpan("<strong>Select the lead level result(ug/dL): </strong>"));
                    button1.setText("<5 ug/dL");
                    button2.setText("5 to <15 ug/dL");
                    button3.setText("15 to <25 ug/dL");
                    button4.setText("25 to <45 ug/dL");
                    button5.setText("45 to <70  ug/dL");
                    button6.setText("≥70 ug/dL");
                    holder2.setText("*Subsequently, Blood Lead Level frequently abbreviated BLL");
                }
                else if (num == 10) {
                    doTextScreen();
                    holder1.setText(toSpan("<strong><h2>BLL Result at < 5 ug/dL: </h2></strong>"));
                    holder1.append(toSpan("<h3>Confirmation of Capillary Sample with a Venous Sample: </h3>"));
                    holder1.append(toSpan("- No confirmation needed. Average BLL for U.S. children ages 1-5 years is 1.4 μg/dL"));
                    holder1.append("\n\n");
                    holder1.append(toSpan("<h3>Follow-Up Venous Testing Schedule AFTER Confirmed Venous BLL (≥5 μg/dL):</h3>"));
                    holder1.append(toSpan("Not applicable. Refer to Management."));
                    holder1.append("\n\n");
                    holder1.append(toSpan("<h3>Management:</h3>"));
                    holder1.append(toSpan("Bolded text indicates NYS Public Health Law and regulation requirement. Unbolded text is based on Centers for Disease Control and Prevention (CDC) and other guidance."));
                    holder1.append("\n\n");
                    holder1.append(toSpan("<strong>•Test all children at age 1 year and again at age 2 years, regardless of initial result</strong>"));
                    holder1.append("\n\n");
                    holder1.append(toSpan("<strong>•If child is less than 6 years, perform a Lead Exposure Risk Assessment (see p. 1) at every well child visit, and test again if lead risk is found.</strong>"));
                    holder1.append("\n\n");
                    holder1.append(toSpan("<strong>•Provide anticipatory guidance to parent or guardian regarding major sources of lead exposure and ways to prevent exposure.</strong>"));
                    holder1.append("\n\n");
                }
                else if (num == 11) {
                    doTextScreen();
                    holder1.setText(toSpan("<strong><h2>BLL at 5 to < 15 ug/dL: </h2></strong>"));
                    holder1.append(toSpan("<h3>Confirmation of Capillary Sample with a Venous Sample: </h3>"));
                    holder1.append(toSpan("- Venous test as soon as possible but no later than 3 months."));
                    holder1.append("\n\n");
                    holder1.append(toSpan("<h3>Follow-Up Venous Testing Schedule AFTER Confirmed Venous BLL (≥5 μg/dL):</h3>"));
                    holder1.append(toSpan("Every 1-3 months until BLLs are confirmed to be < 5 μg/dL based on two tests at least 3 months apart, then proceed as above for < 5 μg/dL."));
                    holder1.append("\n\n");
                    holder1.append(toSpan("<h3>Management:</h3>"));
                    holder1.append(toSpan("Bolded text indicates NYS Public Health Law and regulation requirement. Unbolded text is based on Centers for Disease Control and Prevention (CDC) and other guidance."));
                    holder1.append("\n\n");
                    holder1.append("AFTER CONFIRMED VENOUS TEST, all activities above AND:\n\n");
                    holder1.append(toSpan("<strong>• Perform a Clinical Lead Exposure Assessment (see p. 3)</strong>"));
                    holder1.append("\n\n");
                    holder1.append(toSpan("<strong>• Provide lead exposure risk reduction education</strong>"));
                    holder1.append("\n\n");
                    holder1.append(toSpan("<strong>• Consider the child at risk for developmental delays and behavior concerns and provide ongoing developmental surveillance with prompt referrals for developmental services if needed.</strong>"));
                    holder1.append("\n\n•Test all children who spend time in the home and refer pregnant women in the home for testing.\n\n");
                    holder1.append(toSpan("<strong>• Coordinate care with local or state health department including environmental education and management.</strong>"));
                    holder1.append("\n\n• Notify family of the need for follow-up venous testing on a periodic basis.\n\n" +
                            "• Frequency of follow-up testing for children with previous blood lead level elevations are best guided through consultation with a Regional Lead Resource Center.\n\n");
                }
                else if (num == 12) {
                    doTextScreen();
                    holder1.setText(toSpan("<strong><h2>BLL at 15 to < 25 ug/dL: </h2></strong>"));
                    holder1.append(toSpan("<h3>Confirmation of Capillary Sample with a Venous Sample: </h3>"));
                    holder1.append(toSpan("- Venous test as soon as possible but no later than 1 week."));
                    holder1.append("\n\n");
                    holder1.append(toSpan("<h3>Follow-Up Venous Testing Schedule AFTER Confirmed Venous BLL (≥ 5 μg/dL):</h3>"));
                    holder1.append(toSpan("Every month until BLL is < 15 μg/dL, then proceed as above for BLLs 5 to < 15 μg/dL."));
                    holder1.append("\n\n");
                    holder1.append(toSpan("<h3>Management:</h3>"));
                    holder1.append(toSpan("Bolded text indicates NYS Public Health Law and regulation requirement. Unbolded text is based on Centers for Disease Control and Prevention (CDC) and other guidance."));
                    holder1.append("\n\n");
                    holder1.append("All activities above AND:\n\n");
                    holder1.append("•Consider consulting with a Regional Lead Resource Center.\n\n");
                }
                else if (num == 13) {
                    doTextScreen();
                    holder1.setText(toSpan("<strong><h2>BLL at 25 to < 45 ug/dL: </h2></strong>"));
                    holder1.append(toSpan("<h3>Confirmation of Capillary Sample with a Venous Sample: </h3>"));
                    holder1.append(toSpan("- Venous test as soon as possible but no later than 48 hours."));
                    holder1.append("\n\n");
                    holder1.append(toSpan("<h3>Follow-Up Venous Testing Schedule AFTER Confirmed Venous BLL (≥5 μg/dL):</h3>"));
                    holder1.append(toSpan("Consult with a Regional Lead Resource Center for guidance on a follow-up venous testing schedule until BLL is < 25 μg/dL, then proceed as above for BLLs 15 to < 25 μg/dL."));
                    holder1.append("\n\n");
                    holder1.append(toSpan("<h3>Management:</h3>"));
                    holder1.append(toSpan("Bolded text indicates NYS Public Health Law and regulation requirement. Unbolded text is based on Centers for Disease Control and Prevention (CDC) and other guidance."));
                    holder1.append("\n\n");
                    holder1.append("All activities above AND:\n\n");
                    holder1.append("•Consider consulting with a Regional Lead Resource Center.\n\n");
                }
                else if (num == 14) {
                    doTextScreen();
                    holder1.setText(toSpan("<strong><h2>BLL at 45 to < 70 ug/dL: </h2></strong>"));
                    holder1.append(toSpan("<h3>Confirmation of Capillary Sample with a Venous Sample: </h3>"));
                    holder1.append(toSpan("- Venous test as soon as possible but no later than 24 hours."));
                    holder1.append("\n\n");
                    holder1.append(toSpan("<h3>Follow-Up Venous Testing Schedule AFTER Confirmed Venous BLL (≥5 μg/dL):</h3>"));
                    holder1.append(toSpan(" Consult with a Regional Lead Resource Center (RLRC).6 RLRC may recommend a second venous test before initiating chelation. However, if results of the second test are not readily available, treatment should not be delayed. Follow venous testing schedule as per RLRC instructions until advised to adhere to the testing schedule above."));
                    holder1.append("\n\n");
                    holder1.append(toSpan("<h3>Management:</h3>"));
                    holder1.append(toSpan("Bolded text indicates NYS Public Health Law and regulation requirement. Unbolded text is based on Centers for Disease Control and Prevention (CDC) and other guidance."));
                    holder1.append("\n\n");
                    holder1.append("All activities above AND:\n\n");
                    holder1.append(toSpan("<strong>• Notify local or state health department within 24 hours for environmental investigation and follow-up services.</strong>"));
                    holder1.append("\n\n");
                    holder1.append("• Consult with Regional Lead Resource Center within 24 hours to discuss hospitalization and chelation.\n\n");
                    holder1.append(toSpan("<strong>• Hospital discharge only to housing determined to be lead-safe in consultation with the local or state health department.</strong>"));
                    holder1.append("\n\n");
                }
                else if (num == 15) {
                    doTextScreen();
                    holder1.setText(toSpan("<strong><h2>BLL Result at ≥70 ug/dL: </h2></strong>"));
                    holder1.append(toSpan("<h3>Confirmation of Capillary Sample with a Venous Sample: </h3>"));
                    holder1.append(toSpan("This is a medical emergency. Confirm immediately with a venous test."));
                    holder1.append("\n\n");
                    holder1.append(toSpan("<h3>Follow-Up Venous Testing Schedule AFTER Confirmed Venous BLL (≥5 μg/dL):</h3>"));
                    holder1.append(toSpan(" Consult with a Regional Lead Resource Center (RLRC).6 RLRC may recommend a second venous test before initiating chelation. However, if results of the second test are not readily available, treatment should not be delayed. Follow venous testing schedule as per RLRC instructions until advised to adhere to the testing schedule above."));
                    holder1.append("\n\n");
                    holder1.append(toSpan("<h3>Management:</h3>"));
                    holder1.append(toSpan("Bolded text indicates NYS Public Health Law and regulation requirement. Unbolded text is based on Centers for Disease Control and Prevention (CDC) and other guidance."));
                    holder1.append("\n\n");
                    holder1.append("All activities above AND:\n\n");
                    holder1.append("• Consider consulting with a Regional Lead Resource Center. \n\n• Admit immediately to a hospital for chelation.");
                    holder1.append("\n\n");                }
                else if (num == 18) {
                    doTextScreen();
                    holder1.setText(toSpan("<strong><h2>BLL Result at < 5 ug/dL: </h2></strong>"));
                    holder1.append(toSpan("<h3>Follow-Up Venous Testing Schedule AFTER Confirmed Venous BLL (≥5 μg/dL):</h3>"));
                    holder1.append(toSpan("Not applicable. Refer to Management."));
                    holder1.append("\n\n");
                    holder1.append(toSpan("<h3>Management:</h3>"));
                    holder1.append(toSpan("Bolded text indicates NYS Public Health Law and regulation requirement. Unbolded text is based on Centers for Disease Control and Prevention (CDC) and other guidance."));
                    holder1.append("\n\n");
                    holder1.append(toSpan("<strong>•Test all children at age 1 year and again at age 2 years, regardless of initial result</strong>"));
                    holder1.append("\n\n");
                    holder1.append(toSpan("<strong>•If child is less than 6 years, perform a Lead Exposure Risk Assessment (see p. 1) at every well child visit, and test again if lead risk is found.</strong>"));
                    holder1.append("\n\n");
                    holder1.append(toSpan("<strong>•Provide anticipatory guidance to parent or guardian regarding major sources of lead exposure and ways to prevent exposure.</strong>"));
                    holder1.append("\n\n");
                }
                else if (num == 19) {
                    doTextScreen();
                    holder1.setText(toSpan("<strong><h2>BLL at 5 to < 15 ug/dL: </h2></strong>"));
                    holder1.append(toSpan("<h3>Follow-Up Venous Testing Schedule AFTER Confirmed Venous BLL (≥5 μg/dL):</h3>"));
                    holder1.append(toSpan("Every 1-3 months until BLLs are confirmed to be < 5 μg/dL based on two tests at least 3 months apart, then proceed as above for < 5 μg/dL."));
                    holder1.append("\n\n");
                    holder1.append(toSpan("<h3>Management:</h3>"));
                    holder1.append(toSpan("Bolded text indicates NYS Public Health Law and regulation requirement. Unbolded text is based on Centers for Disease Control and Prevention (CDC) and other guidance."));
                    holder1.append("\n\n");
                    holder1.append("AFTER CONFIRMED VENOUS TEST, all activities above AND:\n\n");
                    holder1.append(toSpan("<strong>• Perform a Clinical Lead Exposure Assessment (see p. 3)</strong>"));
                    holder1.append("\n\n");
                    holder1.append(toSpan("<strong>• Provide lead exposure risk reduction education</strong>"));
                    holder1.append("\n\n");
                    holder1.append(toSpan("<strong>• Consider the child at risk for developmental delays and behavior concerns and provide ongoing developmental surveillance with prompt referrals for developmental services if needed.</strong>"));
                    holder1.append("\n\n•Test all children who spend time in the home and refer pregnant women in the home for testing.\n\n");
                    holder1.append(toSpan("<strong>• Coordinate care with local or state health department including environmental education and management.</strong>"));
                    holder1.append("\n\n• Notify family of the need for follow-up venous testing on a periodic basis.\n\n" +
                            "• Frequency of follow-up testing for children with previous blood lead level elevations are best guided through consultation with a Regional Lead Resource Center.\n\n");
                }
                else if (num == 20) {
                    doTextScreen();
                    holder1.setText(toSpan("<strong><h2>BLL at 15 to < 25 ug/dL: </h2></strong>"));
                    holder1.append(toSpan("<h3>Follow-Up Venous Testing Schedule AFTER Confirmed Venous BLL (≥ 5 μg/dL):</h3>"));
                    holder1.append(toSpan("Every month until BLL is < 15 μg/dL, then proceed as above for BLLs 5 to < 15 μg/dL."));
                    holder1.append("\n\n");
                    holder1.append(toSpan("<h3>Management:</h3>"));
                    holder1.append(toSpan("Bolded text indicates NYS Public Health Law and regulation requirement. Unbolded text is based on Centers for Disease Control and Prevention (CDC) and other guidance."));
                    holder1.append("\n\n");
                    holder1.append("All activities above AND:\n\n");
                    holder1.append("•Consider consulting with a Regional Lead Resource Center.\n\n");
                }
                else if (num == 21) {
                    doTextScreen();
                    holder1.setText(toSpan("<strong><h2>BLL at 25 to < 45 ug/dL: </h2></strong>"));
                    holder1.append(toSpan("<h3>Follow-Up Venous Testing Schedule AFTER Confirmed Venous BLL (≥5 μg/dL):</h3>"));
                    holder1.append(toSpan("Consult with a Regional Lead Resource Center for guidance on a follow-up venous testing schedule until BLL is < 25 μg/dL, then proceed as above for BLLs 15 to < 25 μg/dL."));
                    holder1.append("\n\n");
                    holder1.append(toSpan("<h3>Management:</h3>"));
                    holder1.append(toSpan("Bolded text indicates NYS Public Health Law and regulation requirement. Unbolded text is based on Centers for Disease Control and Prevention (CDC) and other guidance."));
                    holder1.append("\n\n");
                    holder1.append("All activities above AND:\n\n");
                    holder1.append("•Consider consulting with a Regional Lead Resource Center.\n\n");
                }
                else if (num == 22) {
                    doTextScreen();
                    holder1.setText(toSpan("<strong><h2>BLL at 45 to < 70 ug/dL: </h2></strong>"));
                    holder1.append(toSpan("<h3>Follow-Up Venous Testing Schedule AFTER Confirmed Venous BLL (≥5 μg/dL):</h3>"));
                    holder1.append(toSpan(" Consult with a Regional Lead Resource Center (RLRC).6 RLRC may recommend a second venous test before initiating chelation. However, if results of the second test are not readily available, treatment should not be delayed. Follow venous testing schedule as per RLRC instructions until advised to adhere to the testing schedule above."));
                    holder1.append("\n\n");
                    holder1.append(toSpan("<h3>Management:</h3>"));
                    holder1.append(toSpan("Bolded text indicates NYS Public Health Law and regulation requirement. Unbolded text is based on Centers for Disease Control and Prevention (CDC) and other guidance."));
                    holder1.append("\n\n");
                    holder1.append("All activities above AND:\n\n");
                    holder1.append(toSpan("<strong>• Notify local or state health department within 24 hours for environmental investigation and follow-up services.</strong>"));
                    holder1.append("\n\n");
                    holder1.append("• Consult with Regional Lead Resource Center within 24 hours to discuss hospitalization and chelation.\n\n");
                    holder1.append(toSpan("<strong>• Hospital discharge only to housing determined to be lead-safe in consultation with the local or state health department.</strong>"));
                    holder1.append("\n\n");
                }
                else if (num == 23) {
                    doTextScreen();
                    holder1.setText(toSpan("<strong><h2>BLL Result at ≥70 ug/dL: </h2></strong>"));
                    holder1.append(toSpan("<h3>Follow-Up Venous Testing Schedule AFTER Confirmed Venous BLL (≥5 μg/dL):</h3>"));
                    holder1.append(toSpan(" Consult with a Regional Lead Resource Center (RLRC).6 RLRC may recommend a second venous test before initiating chelation. However, if results of the second test are not readily available, treatment should not be delayed. Follow venous testing schedule as per RLRC instructions until advised to adhere to the testing schedule above."));
                    holder1.append("\n\n");
                    holder1.append(toSpan("<h3>Management:</h3>"));
                    holder1.append(toSpan("Bolded text indicates NYS Public Health Law and regulation requirement. Unbolded text is based on Centers for Disease Control and Prevention (CDC) and other guidance."));
                    holder1.append("\n\n");
                    holder1.append("All activities above AND:\n\n");
                    holder1.append("• Consider consulting with a Regional Lead Resource Center. \n\n• Admit immediately to a hospital for chelation.");
                    holder1.append("\n\n");
                }
            }
    }

    public static void doTextScreen() {
        holder1.setVisibility(View.VISIBLE);
        holder2.setVisibility(View.GONE);
        button1.setVisibility(View.GONE);
        button2.setVisibility(View.GONE);
        button3.setVisibility(View.GONE);
        button4.setVisibility(View.GONE);
        button5.setVisibility(View.GONE);
        button6.setVisibility(View.GONE);
    }

    public static void setFragOn() {
        frag.setVisibility(View.VISIBLE);
        notFrag.setVisibility(View.GONE);
        toolbar.setNavigationIcon(null);
    }

    public static void setFragOff() {
        frag.setVisibility(View.GONE);
        notFrag.setVisibility(View.VISIBLE);
        toolbar.setNavigationIcon(R.drawable.left1);
    }

    public static Spanned toSpan(String str){
        Spanned retVal;
        if(android.os.Build.VERSION.SDK_INT>=android.os.Build.VERSION_CODES.N){
            retVal = Html.fromHtml(str,Html.FROM_HTML_MODE_LEGACY);
        }
        else{
            retVal = Html.fromHtml(str);
        }
        return retVal;
    }

    public static Stack<Integer> getStk() {
        return stk;
    }

    public static ActionBar getAct(){
        return act;
    }

}

