package com.example.test;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class GradesActivity extends AppCompatActivity {

    public static boolean gradesStatus = false;
    public static int gradesPercentage = 0;
    public static int gradesTarget;
    public static int grades = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades);

        TextView currentGrade = findViewById(R.id.currentGradeText);


        findViewById(R.id.editGradeButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GradesActivity.this, EnterGrades.class));
            }
        });

        SharedPreferences prefs = getSharedPreferences("GRADES_DATA", MODE_PRIVATE);
        gradesTarget = prefs.getInt("gradesTarget", 0);
        TextView gradesGoalText = findViewById(R.id.currentGradePercentageText);
        gradesGoalText.setText("your target:" + gradesTarget);

        findViewById(R.id.editGradeTargetButton).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                AlertDialog.Builder builder = new AlertDialog.Builder(GradesActivity.this);
                builder.setTitle("Grades Target");
                final EditText input = new EditText(GradesActivity.this);
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                builder.setView(input);
                builder.setPositiveButton("Proceed", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        SharedPreferences.Editor editor = getSharedPreferences("GRADES_DATA", MODE_PRIVATE).edit();
                        editor.putInt("gradesTarget", Integer.valueOf(input.getText().toString()));
                        editor.apply();
                        Intent intent = new Intent(GradesActivity.this, GradesActivity.class);
                        Context context = GradesActivity.this;
                        context.startActivity(intent);
                        finish();
                    }
                });
                builder.show();
            }
        });




    }
    }
