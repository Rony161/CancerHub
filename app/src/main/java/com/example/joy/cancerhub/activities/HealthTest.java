package com.example.joy.cancerhub.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.joy.cancerhub.R;
import com.example.joy.cancerhub.models.Questions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HealthTest extends AppCompatActivity {

    FirebaseDatabase Dbs;
    DatabaseReference DBref_questions;

    TextView textV_question;
    RadioButton radio_1, radio_2, radio_3, radio_4;
    RadioGroup radioG;
    Button btn_next;

    int severityA = 8,severityB = 5,severityC = 3,severityD = 1,severityT = 0;
    int QuestionCounter = 0;
    int QuestionCountTotal = 0;
    int thisQuestion =0;



    // private List<Questions> h_questions;

    private boolean answered;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_test);

        Dbs = FirebaseDatabase.getInstance();
        DBref_questions = Dbs.getReference("Questions");

        textV_question = findViewById(R.id.Question_item);
        radioG = findViewById(R.id.radio_grp);
        radio_1 = findViewById(R.id.radio1);
        radio_2 = findViewById(R.id.radio2);
        radio_3 = findViewById(R.id.radio3);
        radio_4 = findViewById(R.id.radio4);
        btn_next = findViewById(R.id.btn_healthNext);


        //updateQuestion();
        //answered = false;

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!answered) {
                    if (radio_1.isChecked() || radio_2.isChecked() || radio_3.isChecked() || radio_4.isChecked()) {

                        radioG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(RadioGroup group, int checkedId) {
                                // checkedId is the RadioButton selected
                                int id = radioG.getCheckedRadioButtonId();
                                switch (id) {
                                    case R.id.radio1:
                                        severityT += severityA;
                                        updateQuestion();
                                        Toast.makeText(HealthTest.this, "Your severity Level is " +severityT+"%", Toast.LENGTH_SHORT).show();
                                        break;
                                    case R.id.radio2:
                                        severityT += severityB;
                                        updateQuestion();
                                        Toast.makeText(HealthTest.this, "Your severity Level is " +severityT+"%", Toast.LENGTH_SHORT).show();
                                        break;
                                    case R.id.radio3:
                                        severityT += severityC;
                                        updateQuestion();
                                        Toast.makeText(HealthTest.this, "Your severity Level is " +severityT+"%", Toast.LENGTH_SHORT).show();
                                        break;
                                    case R.id.radio4:
                                        severityT += severityD;
                                        updateQuestion();
                                        Toast.makeText(HealthTest.this, "Your severity Level is " +severityT+"%", Toast.LENGTH_SHORT).show();
                                        break;
                                    default:
                                        break;

                                }
                            }
                            });
                        }
                    else{
                            Toast.makeText(HealthTest.this, "Please select an option", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });

        }

        private void updateQuestion () {

            QuestionCounter++;//question index
            radioG.clearCheck();

            if (QuestionCounter > 10) {

                /* todo********************************************** */
                finishQuiz();


            } else {
                DBref_questions = FirebaseDatabase.getInstance().getReference().child("Questions").child(String.valueOf(QuestionCounter));
                severityT++;
                DBref_questions.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        final Questions qstns = dataSnapshot.getValue(Questions.class);
                        textV_question.setText(qstns.getQuestion());
                        radio_1.setText(qstns.getOption1());
                        radio_2.setText(qstns.getOption2());
                        radio_3.setText(qstns.getOption3());
                        radio_4.setText(qstns.getOption4());

                        //answered = false;

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        }

        private void finishQuiz () {
        }
    }
