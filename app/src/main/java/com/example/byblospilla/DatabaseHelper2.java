package com.example.byblospilla;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper2 extends SQLiteOpenHelper {

    public static final String DATABASE_NAME ="timetable.db";
    public static final String TABLE_NAME2 = "timetableuser";
    public static final String C_1 = "ID";
    public static final String C_2 = "time";

    public DatabaseHelper2(Context context){
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
