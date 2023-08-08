package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EssayActivity extends AppCompatActivity {

    public static boolean essayStatus = false;
    public static int essayCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_essay);


        final Database3 db = new Database3(this);

        Button editEssayButton = findViewById(R.id.editEssayButton);

        editEssayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EssayActivity.this, EnterEssay.class));
            }
        });

        essayCount = db.getAllNames().size();

        RecyclerView rvEssays = findViewById(R.id.rvEssays);
        rvEssays.setLayoutManager(new LinearLayoutManager(this));
        rvEssays.setAdapter(new rvessayadapter(this));

    }
}