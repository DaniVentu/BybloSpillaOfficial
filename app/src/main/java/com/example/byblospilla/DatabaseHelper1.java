package com.example.byblospilla;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

//DATABASE NECESSARIO PER LO STORAGE DELLE NOTE
public class DatabaseHelper1 extends SQLiteOpenHelper {


    //Elementi necessari per creare la tabella notesuser
    public static final String DATABASE_NAME ="list.db";
    public static final String TABLE_NAME2 = "notesuser";
    public static final String C_1 = "ID";
    public static final String C_2 = "notes";

    //crea un oggetto helper per creare, aprire o gestire un database!
    public DatabaseHelper1(Context context){
        super(context,DATABASE_NAME,null,1);
    }
    //creazione tabella notesuser nel database
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //TABELLA  SQL DELLE NOTE
        String createtable = "CREATE TABLE notesuser(ID INTEGER PRIMARY KEY AUTOINCREMENT, notes TEXT)";
        sqLiteDatabase.execSQL(createtable);
    }
    //metodo per il controllo del contenuto del database
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
    //metodo che serve per reperire elementi della tabella notesuser in modo da reperire le ultime 5 note scritte dall'utente
    public Cursor getData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+ TABLE_NAME2 + " ORDER BY ID DESC LIMIT 5",null);
        return res;
    }

}
