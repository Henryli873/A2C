package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class EnterGrades extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_grades);

        final Database2 db = new Database2(this);

        EditText hl1target = findViewById(R.id.hl1target);
        EditText hl1actual = findViewById(R.id.hl1actual);
        EditText hl2target = findViewById(R.id.hl2target);
        EditText hl2actual = findViewById(R.id.hl2actual);
        EditText hl3target = findViewById(R.id.hl3target);
        EditText hl3actual = findViewById(R.id.hl3actual);
        EditText sl1target = findViewById(R.id.sl1target);
        EditText sl1actual = findViewById(R.id.sl1actual);
        EditText sl2target = findViewById(R.id.sl2target);
        EditText sl2actual = findViewById(R.id.sl2actual);
        EditText sl3target = findViewById(R.id.sl3target);
        EditText sl3actual = findViewById(R.id.sl3actual);

        ArrayList<Pair<Integer, Integer>> data = db.loadData();
        hl1target.setText(String.valueOf(data.get(0).first));
        hl1actual.setText(String.valueOf(data.get(0).second));
        hl2target.setText(String.valueOf(data.get(1).first));
        hl2actual.setText(String.valueOf(data.get(1).second));
        hl3target.setText(String.valueOf(data.get(2).first));
        hl3actual.setText(String.valueOf(data.get(2).second));

        sl1target.setText(String.valueOf(data.get(3).first));
        sl1actual.setText(String.valueOf(data.get(3).second));
        sl2target.setText(String.valueOf(data.get(4).first));
        sl2actual.setText(String.valueOf(data.get(4).second));
        sl3target.setText(String.valueOf(data.get(5).first));
        sl3actual.setText(String.valueOf(data.get(5).second));

        //Log.e("loaded i think", data.get(0).first + " " + data.get(0).second);

        Button edit = findViewById(R.id.editGradeTable);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                final Database2 db = new Database2(v.getContext());
                ArrayList<Pair<Integer, Integer> > saveData = new ArrayList<>();
                saveData.add(new Pair<>(Integer.valueOf(hl1target.getText().toString()), Integer.valueOf(hl1actual.getText().toString())));
                saveData.add(new Pair<>(Integer.valueOf(hl2target.getText().toString()), Integer.valueOf(hl2actual.getText().toString())));
                saveData.add(new Pair<>(Integer.valueOf(hl3target.getText().toString()), Integer.valueOf(hl3actual.getText().toString())));
                saveData.add(new Pair<>(Integer.valueOf(sl1target.getText().toString()), Integer.valueOf(sl1actual.getText().toString())));
                saveData.add(new Pair<>(Integer.valueOf(sl2target.getText().toString()), Integer.valueOf(sl2actual.getText().toString())));
                saveData.add(new Pair<>(Integer.valueOf(sl3target.getText().toString()), Integer.valueOf(sl3actual.getText().toString())));
                db.updateData(saveData);
                //Log.e("saved", hl1target.getText().toString() + " " + hl1actual.getText().toString());
            }
        });



    }


}