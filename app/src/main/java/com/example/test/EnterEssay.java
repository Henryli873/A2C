package com.example.test;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EnterEssay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_essay);

        EditText enter = findViewById(R.id.enterEssayTitleEditText);
        EditText description = findViewById(R.id.enterEssayEditText);
        Button confirmButton = findViewById(R.id.confirmEssayButton);
        String EcName;
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database3 db = new Database3(EnterEssay.this);
                String EcName = enter.getText().toString();
                String EcDescription = description.getText().toString();
                db.insert(EcName, EcDescription);
                Intent intent = new Intent(EnterEssay.this, EssayActivity.class);
                Context context = EnterEssay.this;
                context.startActivity(intent);
                finish();
            }
        });





    }
}