package com.example.byblospilla;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//DATABASE INTERNO PER LO STORAGE DELL'ORARIO SETTIMANALE
public class DatabaseHelper2 extends SQLiteOpenHelper {
    //ELEMENTI NECESSARI PER LA CREAZIONE DELLA TABELLA TIMETABLEUSER
    public static final String DATABASE_NAME ="timetable.db";
    public static final String TABLE_NAME3 = "timetableuser";
    public static final String C_1 = "ID";
    public static final String C_2 = "lun";
    public static final String C_3 = "mar";
    public static final String C_4 = "mer";
    public static final String C_5 = "gio";
    public static final String C_6 = "ven";
    public static final String C_7 = "sab";
    public static final String C_8 = "dom";
    //crea un oggetto helper per creare, aprire o gestire un database!
    public DatabaseHelper2(Context context){
        super(context,DATABASE_NAME,null,1);
    }
    //creazione della tabella timetableuser nel database
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //TABELLA  SQL DEl timetable
        String createtable = "CREATE TABLE timetableuser(ID INTEGER PRIMARY KEY AUTOINCREMENT, lun TEXT, mar TEXT, mer TEXT, gio TEXT, ven TEXT, sab TEXT, dom TEXT)";
        sqLiteDatabase.execSQL(createtable);
    }
    //controllo del database prima di creare nuove tabelle
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME3);
        onCreate(sqLiteDatabase);
    }
    //metodo utile all'aggiunta dell'orario settimanale del database!
    public boolean addTime (String lun, String mar, String mer, String gio, String ven,String sab, String dom){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(C_2,lun);
        contentValues.put(C_3,mar);
        contentValues.put(C_4,mer);
        contentValues.put(C_5,gio);
        contentValues.put(C_6,ven);
        contentValues.put(C_7,sab);
        contentValues.put(C_8,dom);
        //controllo sull'inserimento corretto dei dati nel database
        long result = db.insert(TABLE_NAME3,null,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }
    //metodo utile per la reperibilità dell'ultimo elemento di ogni colonna della tabella da inserire nell'interfaccia dell'app
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+ TABLE_NAME3 + " ORDER BY ID DESC LIMIT 1",null);
        return res;
    }
}
