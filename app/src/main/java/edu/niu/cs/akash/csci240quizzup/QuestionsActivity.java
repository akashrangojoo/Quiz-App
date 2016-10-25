/********************************************************************
 * Project Name: CSCI 240 Quizzup! GRADUATE STUDENT PROJECT
 * Author : Akash Rangojoo
 * Z ID : Z1717009
 * Description: This is the second activity that gets called from main activity. The string
 *              with the week ID is passed based on which questions are decided. When an option is selected, it is
 *              checked against correct answer and feedback is given. when next button is clicked, new quesstion is
 *              displayed. When all questions are done, final stats are displayed.
 *********************************************************************/



package edu.niu.cs.akash.csci240quizzup;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionsActivity extends AppCompatActivity {

    private static TextView headingTV, questionTV, statusTV;
    private static ImageView statusIV;
    private RadioGroup optionRG;
    private RadioButton option1RB, option2RB, option3RB, option4RB;
    private Button checkBtn,exitBtn;
    private Button nextBtn;
    private static int correctCount;
    private static String selectedAns;
    private static int weekID, counter;
    public static Questions questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        // Font
        Typeface externalFont=Typeface.createFromAsset(getAssets(), "fonts/Send me a postcard.ttf");
        // Connecting java variables to screen items
        counter=0;
        correctCount=0;
        headingTV = (TextView) findViewById(R.id.headingTextView);
        questionTV = (TextView) findViewById(R.id.questionTextView);
        optionRG = (RadioGroup) findViewById(R.id.questionRadioGroup);
        option1RB = (RadioButton) findViewById(R.id.option1);
        option2RB = (RadioButton) findViewById(R.id.option2);
        option3RB = (RadioButton) findViewById(R.id.option3);
        option4RB = (RadioButton) findViewById(R.id.option4);
        checkBtn = (Button) findViewById(R.id.checkBtn);
        nextBtn = (Button) findViewById(R.id.nextButton);
        //doneBtn = (Button) findViewById(R.id.doneButton);
        exitBtn = (Button) findViewById(R.id.exitButton);
        statusTV = (TextView) findViewById(R.id.statusTextView);
        statusIV = (ImageView) findViewById(R.id.statusImageView);

        headingTV.setTypeface(externalFont);
        questionTV.setTypeface(externalFont);
        option1RB.setTypeface(externalFont);
        option2RB.setTypeface(externalFont);
        option3RB.setTypeface(externalFont);
        option4RB.setTypeface(externalFont);
        statusTV.setTypeface(externalFont);

        // setting visibility to hide
        nextBtn.setVisibility(View.GONE);
        statusTV.setVisibility(View.GONE);
        statusIV.setVisibility(View.GONE);

        // getting week selected from intent before.
        final String selection = getIntent().getExtras().getString("weekID");
        weekID = Integer.parseInt(selection);



        // passing this week id to initialize a question array
        headingTV.setText("Week " + selection);
        questions = new Questions(weekID);

        //set questions and options from the questions variable
            Log.d("Q activity", "before Q1 ");
            questionTV.setText(counter + 1 + ". " + questions.questionArray[counter]);
            option1RB.setText(questions.options[counter][0]);
            option2RB.setText(questions.options[counter][1]);
            option3RB.setText(questions.options[counter][2]);
            option4RB.setText(questions.options[counter][3]);
            selectedAns = "";
        // set on checked listener when one of the options is selected.
            optionRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    switch (checkedId) {
                        case R.id.option1:
                            selectedAns = questions.options[counter][0];
                            break;
                        case R.id.option2:
                            selectedAns = questions.options[counter][1];
                            break;
                        case R.id.option3:
                            selectedAns = questions.options[counter][2];
                            break;
                        case R.id.option4:
                            selectedAns = questions.options[counter][3];
                            break;
                    }

                    checkBtn = (Button) findViewById(R.id.checkBtn);
                    checkBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(!selectedAns.equals("")){
                            checkBtn.setVisibility(View.GONE);// hide check button
                            nextBtn.setVisibility(View.VISIBLE); // show next button
                            if (selectedAns.equals(questions.answerArray[counter])) {
                                correctCount++;// if selected ans = actual answer, increment correct counter by 1
                                statusIV.setVisibility(View.VISIBLE); // show tick or wrong
                                statusIV.setImageResource(R.drawable.right); // show tick or wrong
                            } else {
                                statusIV.setVisibility(View.VISIBLE); // show tick or wrong
                                statusIV.setImageResource(R.drawable.wrong);// show tick or wrong
                            }}
                            else Toast.makeText(getApplicationContext(),"Select an option",Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            });

            final Button nextBtn = (Button) findViewById(R.id.nextButton);
            nextBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    statusIV.setVisibility(View.GONE);
                    Log.d("Q activity", "after Q1 ");
                    Log.d("Q activity", "before Q2 ");
                    if (counter < 4) { // when next button is clicked, and counter is less than 4 increment counter by 1
                        counter++;
                        optionRG.clearCheck(); // clear the selected answer of the options group
                        nextBtn.setVisibility(View.GONE); // hide next button
                        checkBtn.setVisibility(View.VISIBLE); // show check button
                        questionTV.setText(counter + 1 + ". " + questions.questionArray[counter]); // set questions and options with new counter
                        option1RB.setText(questions.options[counter][0]);
                        option2RB.setText(questions.options[counter][1]);
                        option3RB.setText(questions.options[counter][2]);
                        option4RB.setText(questions.options[counter][3]);
                        selectedAns=""; // clearing answer
                        optionRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(RadioGroup group, int checkedId) {
                                switch (checkedId) {
                                    case R.id.option1:
                                        selectedAns = questions.options[counter][0];
                                        break;
                                    case R.id.option2:
                                        selectedAns = questions.options[counter][1];
                                        break;
                                    case R.id.option3:
                                        selectedAns = questions.options[counter][2];
                                        break;
                                    case R.id.option4:
                                        selectedAns = questions.options[counter][3];
                                        break;
                                }

                                final Button checkBtn = (Button) findViewById(R.id.checkBtn);
                                checkBtn.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if (!selectedAns.equals("")) {
                                            checkBtn.setVisibility(View.GONE);
                                            nextBtn.setVisibility(View.VISIBLE);
                                            if (selectedAns.equals(questions.answerArray[counter])) {
                                                Log.d("Q activity", "checking Q2 ");
                                                correctCount++;
                                                statusIV.setVisibility(View.VISIBLE);
                                                statusIV.setImageResource(R.drawable.right);
                                            } else {
                                                statusIV.setVisibility(View.VISIBLE);
                                                statusIV.setImageResource(R.drawable.wrong);
                                            }
                                        }
                                        else Toast.makeText(getApplicationContext(),"Select an option",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        });

                        final Button nextBtn = (Button) findViewById(R.id.nextButton);
                        nextBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                if (counter < 4) {
                                    Log.d("Q activity", "after Q2 ");
                                    Log.d("Q activity", "before Q3 ");
                                    counter++;
                                    optionRG.clearCheck();
                                    statusIV.setVisibility(View.GONE);
                                    checkBtn.setVisibility(View.VISIBLE);
                                    nextBtn.setVisibility(View.GONE);
                                    questionTV.setText(counter + 1 + ". " + questions.questionArray[counter]);
                                    option1RB.setText(questions.options[counter][0]);
                                    option2RB.setText(questions.options[counter][1]);
                                    option3RB.setText(questions.options[counter][2]);
                                    option4RB.setText(questions.options[counter][3]);
                                    selectedAns = ""; // clearing answer
                                    optionRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                                                            @Override
                                                                            public void onCheckedChanged(RadioGroup group, int checkedId) {
                                                                                switch (checkedId) {
                                                                                    case R.id.option1:
                                                                                        selectedAns = questions.options[counter][0];
                                                                                        break;
                                                                                    case R.id.option2:
                                                                                        selectedAns = questions.options[counter][1];
                                                                                        break;
                                                                                    case R.id.option3:
                                                                                        selectedAns = questions.options[counter][2];
                                                                                        break;
                                                                                    case R.id.option4:
                                                                                        selectedAns = questions.options[counter][3];
                                                                                        break;
                                                                                }

                                                                                final Button checkBtn = (Button) findViewById(R.id.checkBtn);
                                                                                checkBtn.setOnClickListener(new View.OnClickListener() {
                                                                                                                @Override
                                                                                                                public void onClick(View v) {
                                                                                                                    if (!selectedAns.equals("")) {
                                                                                                                        checkBtn.setVisibility(View.GONE);
                                                                                                                        nextBtn.setVisibility(View.VISIBLE);
                                                                                                                        if (selectedAns.equals(questions.answerArray[counter])) {
                                                                                                                            correctCount++;
                                                                                                                            statusIV.setVisibility(View.VISIBLE);
                                                                                                                            statusIV.setImageResource(R.drawable.right);
                                                                                                                        } else {
                                                                                                                            statusIV.setVisibility(View.VISIBLE);
                                                                                                                            statusIV.setImageResource(R.drawable.wrong);
                                                                                                                        }
                                                                                                                    }
                                                                                                                    else Toast.makeText(getApplicationContext(),"Select an option",Toast.LENGTH_SHORT).show();
                                                                                                                }

                                                                                                            }

                                                                                );
                                                                            }
                                                                        }

                                    );

                                        final Button nextBtn = (Button) findViewById(R.id.nextButton);
                                        nextBtn.setOnClickListener(new View.OnClickListener()

                                        {
                                            @Override
                                            public void onClick(View v) {
                                                if (counter < 4) {
                                                    Log.d("Q activity", "after Q3 ");
                                                    Log.d("Q activity", "before Q4 ");
                                                    counter++;
                                                    optionRG.clearCheck();
                                                    statusIV.setVisibility(View.GONE);
                                                    checkBtn.setVisibility(View.VISIBLE);
                                                    nextBtn.setVisibility(View.GONE);
                                                    questionTV.setText(counter + 1 + ". " + questions.questionArray[counter]);
                                                    option1RB.setText(questions.options[counter][0]);
                                                    option2RB.setText(questions.options[counter][1]);
                                                    option3RB.setText(questions.options[counter][2]);
                                                    option4RB.setText(questions.options[counter][3]);
                                                    selectedAns = ""; // clearing answer
                                                    optionRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                                        @Override
                                                        public void onCheckedChanged(RadioGroup group, int checkedId) {
                                                            switch (checkedId) {
                                                                case R.id.option1:
                                                                    selectedAns = questions.options[counter][0];
                                                                    break;
                                                                case R.id.option2:
                                                                    selectedAns = questions.options[counter][1];
                                                                    break;
                                                                case R.id.option3:
                                                                    selectedAns = questions.options[counter][2];
                                                                    break;
                                                                case R.id.option4:
                                                                    selectedAns = questions.options[counter][3];
                                                                    break;
                                                            }

                                                            final Button checkBtn = (Button) findViewById(R.id.checkBtn);
                                                            checkBtn.setOnClickListener(new View.OnClickListener() {
                                                                @Override
                                                                public void onClick(View v) {
                                                                    if (!selectedAns.equals("")) {
                                                                        checkBtn.setVisibility(View.GONE);
                                                                        nextBtn.setVisibility(View.VISIBLE);
                                                                        if (selectedAns.equals(questions.answerArray[counter])) {
                                                                            correctCount++;
                                                                            statusIV.setVisibility(View.VISIBLE);
                                                                            statusIV.setImageResource(R.drawable.right);
                                                                        } else {
                                                                            statusIV.setVisibility(View.VISIBLE);
                                                                            statusIV.setImageResource(R.drawable.wrong);
                                                                        }}
                                                                    else Toast.makeText(getApplicationContext(),"Select an option",Toast.LENGTH_SHORT).show();
                                                                    }
                                                                }

                                                                );
                                                            }
                                                        }

                                                        );

                                                        final Button nextBtn = (Button) findViewById(R.id.nextButton);
                                                        nextBtn.setOnClickListener(new View.OnClickListener()

                                                        {
                                                            @Override
                                                            public void onClick (View v){
                                                            statusIV.setVisibility(View.GONE);
                                                            Log.d("Q activity", "after Q4 ");
                                                            Log.d("Q activity", "before Q5 ");
                                                            if (counter < 4) {
                                                                counter++;
                                                                optionRG.clearCheck();
                                                                nextBtn.setVisibility(View.GONE);
                                                                checkBtn.setVisibility(View.VISIBLE);
                                                                questionTV.setText(counter + 1 + ". " + questions.questionArray[counter]);
                                                                option1RB.setText(questions.options[counter][0]);
                                                                option2RB.setText(questions.options[counter][1]);
                                                                option3RB.setText(questions.options[counter][2]);
                                                                option4RB.setText(questions.options[counter][3]);
                                                                selectedAns = ""; // clearing answer

                                                                optionRG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                                                                    @Override
                                                                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                                                                        switch (checkedId) {
                                                                            case R.id.option1:
                                                                                selectedAns = questions.options[counter][0];
                                                                                break;
                                                                            case R.id.option2:
                                                                                selectedAns = questions.options[counter][1];
                                                                                break;
                                                                            case R.id.option3:
                                                                                selectedAns = questions.options[counter][2];
                                                                                break;
                                                                            case R.id.option4:
                                                                                selectedAns = questions.options[counter][3];
                                                                                break;
                                                                        }

                                                                        final Button checkBtn = (Button) findViewById(R.id.checkBtn);
                                                                        checkBtn.setOnClickListener(new View.OnClickListener() {
                                                                            @Override
                                                                            public void onClick(View v) {
                                                                                if (!selectedAns.equals("")) {
                                                                                    checkBtn.setVisibility(View.GONE);
                                                                                    nextBtn.setVisibility(View.VISIBLE);
                                                                                    if (selectedAns.equals(questions.answerArray[counter])) {
                                                                                        Log.d("Q activity", "checking Q2 ");
                                                                                        correctCount++;
                                                                                        statusIV.setVisibility(View.VISIBLE);
                                                                                        statusIV.setImageResource(R.drawable.right);
                                                                                    } else {
                                                                                        statusIV.setVisibility(View.VISIBLE);
                                                                                        statusIV.setImageResource(R.drawable.wrong);
                                                                                    }
                                                                                }
                                                                                else Toast.makeText(getApplicationContext(),"Select an option",Toast.LENGTH_SHORT).show();
                                                                            }
                                                                        });
                                                                    }
                                                                });
                                                                final Button nextBtn = (Button) findViewById(R.id.nextButton);
                                                                nextBtn.setOnClickListener(new View.OnClickListener() {
                                                                    @Override
                                                                    public void onClick(View v) {
                                                                        statusTV.setVisibility(View.VISIBLE); // set final stats visible
                                                                        statusIV.setVisibility(View.GONE); // Hide status image
                                                                        statusTV.setText("Total Correct Answers : " + String.valueOf(correctCount) + "                                    Total Incorrect Answers : " + String.valueOf(5 - correctCount) + "                                     Correct Answers Percentage : " + String.valueOf((correctCount / 5.0) * 100) + "%");
                                                                        checkBtn.setVisibility(View.GONE); // hide check button
                                                                        nextBtn.setVisibility(View.GONE); // hide next button
                                                                        questionTV.setVisibility(View.GONE); // hide question
                                                                        option1RB.setVisibility(View.GONE); // hide options
                                                                        option2RB.setVisibility(View.GONE); // hide options
                                                                        option3RB.setVisibility(View.GONE);// hide options
                                                                        option4RB.setVisibility(View.GONE);// hide options
                                                                    }
                                                                });
                                                            }
                                                        }
                                                        }

                                                        );
                                                    }
                                                }
                                            }

                                            );
                                    }
                                }
                        });
                    }
                }
            });
    }

    public void done(View View){
        finish();
    }
}