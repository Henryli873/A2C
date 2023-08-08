package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EnterEc extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_ec);

        EditText enter = findViewById(R.id.ecNameEditText);
        EditText description = findViewById(R.id.edDescriptionEditText);
        Button confirmButton = findViewById(R.id.confirmEcButton);  
        String EcName;
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Database1 db = new Database1(EnterEc.this);
                String EcName = enter.getText().toString();
                String EcDescription = description.getText().toString();    
                db.insert(EcName, EcDescription);
                Intent intent = new Intent(EnterEc.this, EcActivity.class);
                Context context = EnterEc.this;
                context.startActivity(intent);
                finish();
            }
        });
    }
}