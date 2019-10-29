package com.example.byblospilla;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper1 extends SQLiteOpenHelper {


    //Database Notes
    public static final String DATABASE_NAME ="list.db";
    public static final String TABLE_NAME2 = "notesuser";
    public static final String C_1 = "ID";
    public static final String C_2 = "notes";
    //fine Database notes

    public DatabaseHelper1(Context context){
        super(context,DATABASE_NAME,null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //TABELLA  SQL DELLE NOTE
        String createtable = "CREATE TABLE notesuser(ID INTEGER PRIMARY KEY AUTOINCREMENT, notes TEXT)";
        sqLiteDatabase.execSQL(createtable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        onCreate(sqLiteDatabase);
    }
    //inserimento delle notes nel database
    public boolean addNotes(String notes) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(C_2,notes);

        long res = db.insert(TABLE_NAME2,null,contentValues);
        if(res == -1){
            return false;
        }
        else{
            return true;
        }
    }

    Cursor getListContents(){
        SQLiteDatabase db = this.getWritableDatabase();
        final Cursor data1 = db.rawQuery("SELECT * FROM notesuser", null);
        return data1;
    }

}
