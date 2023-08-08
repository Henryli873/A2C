package com.example.test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Pair;

import java.util.ArrayList;

// to do: on button click gettext, feed into array, feed
// array into database.
// for display: fetch data from database
// can enable and disable edittext 

public class Database2 extends SQLiteOpenHelper{

    private final SQLiteDatabase db = this.getWritableDatabase();

    public Database2(Context context){
        super(context, "GradesDatabase", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE GradesDatabaseTable (SUBJECT INTEGER PRIMARY KEY, TARGET_GRADE INTEGER, ACTUAL_GRADE INTEGER);");
        for(int i = 1; i <= 6; i++) {
            ContentValues values = new ContentValues();
            values.put("SUBJECT", i);
            values.put("TARGET_GRADE", 0);
            values.put("ACTUAL_GRADE", 0);
            db.insert("GradesDatabaseTable", null, values);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        return;
    }

    public void updateData(ArrayList<Pair<Integer, Integer> > data){
        for(int i = 1; i <= 6; i++) {
            ContentValues values = new ContentValues();
            values.put("SUBJECT", i);
            values.put("TARGET_GRADE", data.get(i-1).first);
            values.put("ACTUAL_GRADE", data.get(i-1).second);
            db.replace("GradesDatabaseTable", null, values);
        }
    }

    public ArrayList<Pair<Integer, Integer> > loadData(){
        String query = "SELECT TARGET_GRADE, ACTUAL_GRADE FROM GradesDatabaseTable";
        Cursor c = db.rawQuery(query, null);
        ArrayList<Pair<Integer, Integer> > data = new ArrayList<>();
        if(c.moveToFirst()){
            while (!c.isAfterLast()) {
                data.add(new Pair<Integer, Integer>(c.getInt(c.getColumnIndex("TARGET_GRADE")),
                        c.getInt(c.getColumnIndex("ACTUAL_GRADE"))));
                c.moveToNext();
            }
        }
        c.close();
        return data;
    }

    public int totalActualGrades(){
        String query = "SELECT SUM(ACTUAL_GRADE) FROM GradesDatabaseTable";
        Cursor c = db.rawQuery(query, null);
        if(c.moveToFirst()){
            return c.getInt(0);
        }
        return -1;
    }

}
