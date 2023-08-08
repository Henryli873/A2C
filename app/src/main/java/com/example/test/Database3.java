package com.example.test;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

public class Database3 extends SQLiteOpenHelper {

    private final SQLiteDatabase db = this.getWritableDatabase();

    public Database3(Context context){
        super(context, "EssayDatabase", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE EssayDatabaseTable (NAME TEXT PRIMARY KEY, DESCRIPTION TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        return;
    }

    public void insert(String name, String description){
        ContentValues values = new ContentValues();
        values.put("NAME", name);
        values.put("DESCRIPTION", description);
        db.insert("EssayDatabaseTable", null, values);
        Log.e("inserted ", name + " " + description);
    }

    public void delete(String name){
        db.delete("EssayDatabaseTable", "NAME = \"" + name + "\"", null);
    }

    public ArrayList<String> getAllNames(){
        String query = "SELECT NAME FROM EssayDatabaseTable";
        Cursor c = db.rawQuery(query, null);
        ArrayList<String> arrayList = new ArrayList<>();
        if(c.moveToFirst()){
            while (!c.isAfterLast()) {
                arrayList.add(c.getString(c.getColumnIndex("NAME")));
                c.moveToNext();
            }
        }
        return arrayList;
    }

    public ArrayList<String> getAllDescriptions(){
        String query = "SELECT DESCRIPTION FROM EssayDatabaseTable";
        Cursor c = db.rawQuery(query, null);
        ArrayList<String> arrayList = new ArrayList<>();
        if(c.moveToFirst()){
            while (!c.isAfterLast()) {
                arrayList.add(c.getString(c.getColumnIndex("DESCRIPTION")));
                c.moveToNext();
            }
        }
        return arrayList;
    }

}
