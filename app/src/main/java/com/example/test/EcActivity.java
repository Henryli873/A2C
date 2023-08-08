package com.example.test;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.text.style.TtsSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class EcActivity extends AppCompatActivity {

    public static boolean ecStatus = false;
    public static float ecPercentage = 0;
    public static int ecCount = 0;
    public static int ecTarget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ec);

        final Database1 db = new Database1(this);

        findViewById(R.id.editEcButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EcActivity.this, EnterEc.class));
            }
        });
        RecyclerView rvec = findViewById(R.id.rvECs);
        rvec.setLayoutManager(new LinearLayoutManager(this));
        rvec.setAdapter(new rvecAdapter(this));

        TextView eccount = findViewById(R.id.ecCountText);
        ecCount = db.getAllNames().size();
        eccount.setText("You have " + db.getAllNames().size() + " extracurriculars");

        SharedPreferences prefs = getSharedPreferences("EC_DATA", MODE_PRIVATE);
        ecTarget = prefs.getInt("ecTarget", 0);
        TextView ecGoalText = findViewById(R.id.ecGoalText);
        ecGoalText.setText("" + ecTarget);



        if(ecPercentage>=100){
            ecStatus = true;
        }

        findViewById(R.id.editEcGoalButton).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                AlertDialog.Builder builder = new AlertDialog.Builder(EcActivity.this);
                builder.setTitle("EC Target");
                final EditText input = new EditText(EcActivity.this);
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                builder.setView(input);
                builder.setPositiveButton("Proceed", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        SharedPreferences.Editor editor = getSharedPreferences("EC_DATA", MODE_PRIVATE).edit();
                        editor.putInt("ecTarget", Integer.valueOf(input.getText().toString()));
                        editor.apply();
                        Intent intent = new Intent(EcActivity.this, EcActivity.class);
                        Context context = EcActivity.this;
                        context.startActivity(intent);
                        finish();
                    }
                });
                builder.show();
            }
        });






    }
}