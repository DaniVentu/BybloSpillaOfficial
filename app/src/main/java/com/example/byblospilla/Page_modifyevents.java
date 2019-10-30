package com.example.byblospilla;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Page_modifyevents extends AppCompatActivity {

    DatabaseHelper1 db;

    private EditText editTextm11;


    private Button btn_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_modifyevents);

        editTextm11 = findViewById(R.id.editevents);
        db = new DatabaseHelper1(this);

        btn_save = findViewById(R.id.btn_save);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String m11 = editTextm11.getText().toString();

                if(m11.length() == 0){
                    Toast.makeText(Page_modifyevents.this, "Type Something", Toast.LENGTH_SHORT).show();
                }
                else {
                    editTextm11.setText("");
                    AddData(m11);

                    final Intent retback = new Intent(Page_modifyevents.this,Page_Events.class);
                    startActivity(retback);
                }
            }
        });

        /* return */
        Button btnret = findViewById(R.id.retbtn);
        final Intent openret = new Intent(Page_modifyevents.this, Page_Events.class);
        btnret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(openret);
            }
        });
    }

    public void AddData(String m11){
        boolean insertData = db.addNotes(m11);
        if(insertData)
            ToasMessage("Data successfully inserted!");
        else
            ToasMessage("Data not inserted!");
    }

    private void ToasMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

}
