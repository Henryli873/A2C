package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static boolean readiness = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.gradesButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GradesActivity.class));
            }
        });

        findViewById(R.id.EcButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EcActivity.class));
            }
        });

        findViewById(R.id.essayButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, EssayActivity.class));
            }
        });
        TextView essayReady = findViewById(R.id.essayStatusText);
        essayReady.setText("you have completed"+EssayActivity.essayCount+"essays");

        TextView gradesReady = findViewById(R.id.gradesStatusText);
        gradesReady.setText("you have completed"+GradesActivity.gradesPercentage+"% of your grades goal");

        TextView ecReady = findViewById(R.id.ecStatusText);
        ecReady.setText("you have completed"+EcActivity.ecPercentage+"% of your ec goal");

        TextView ready = findViewById(R.id.readyText);
        if((EcActivity.ecStatus) && (GradesActivity.gradesStatus)){
            readiness = true;
            ready.setText("you are ready for college!");
        }

    }




    }

