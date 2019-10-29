package com.example.byblospilla;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Page_Events extends AppCompatActivity {

    DatabaseHelper1 db1;
    Button btnsave;
    EditText editText;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page__events);

        editText = findViewById(R.id.edittype);
        btnsave = findViewById(R.id.btnSalva);
        listView = findViewById(R.id.listview);
        db1 = new DatabaseHelper1(this);

        final ArrayList<String> theList = new ArrayList<>();
        Cursor data;
        data = db1.getListContents();

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = editText.getText().toString();
                if(editText.length() != 0){
                    AddData(newEntry);
                    editText.setText("");

                }else{
                    Toast.makeText(Page_Events.this, "you must put something in the field", Toast.LENGTH_SHORT).show();
                }

            }
        });

        if(data.getCount() == 0){
            Toast.makeText(Page_Events.this, "DataBase is empty :(", Toast.LENGTH_SHORT).show();
        }else{
            while(data.moveToNext()){
                theList.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,theList);
                listView.setAdapter(listAdapter);

            }
        }


        /* return */
        Button btnret = findViewById(R.id.retbtn);
        final Intent openret = new Intent(Page_Events.this, Page1.class);
        btnret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(openret);
            }
        });

    }

    public void AddData (String newEntry){
        boolean insertData = db1.addNotes(newEntry);

        if(insertData == true){
            Toast.makeText(Page_Events.this, "Successfuly Entered Data :)", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(Page_Events.this, "something went wrong :( ", Toast.LENGTH_SHORT).show();
        }
    }

}
