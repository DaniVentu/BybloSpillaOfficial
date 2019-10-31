package com.example.byblospilla;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
//CLASSE PER LA MODIFICA DELLA TABELLA ORARI
public class Page_modifytimetable extends AppCompatActivity {

    DatabaseHelper2 db;

    private EditText editTextm11;
    private EditText editTextm22;
    private EditText editTextm33;
    private EditText editTextm44;
    private EditText editTextm55;
    private EditText editTextm66;
    private EditText editTextm77;

    private Button btnsave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_modifytimetable);

        editTextm11 = findViewById(R.id.m11);
        editTextm22 = findViewById(R.id.m22);
        editTextm33 = findViewById(R.id.m33);
        editTextm44 = findViewById(R.id.m44);
        editTextm55 = findViewById(R.id.m55);
        editTextm66 = findViewById(R.id.m66);
        editTextm77 = findViewById(R.id.m77);
        db = new DatabaseHelper2(this);
        //bottone per il salvataggio dei dati inseriti
        btnsave = findViewById(R.id.btnsave);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String m11 = editTextm11.getText().toString();
                String m22 = editTextm22.getText().toString();
                String m33 = editTextm33.getText().toString();
                String m44 = editTextm44.getText().toString();
                String m55 = editTextm55.getText().toString();
                String m66 = editTextm66.getText().toString();
                String m77 = editTextm77.getText().toString();

                if(m11.length() == 0){
                    m11 = "Closed";

                }
                if(m22.length() == 0){
                    m22 = "Closed";

                }
                if(m33.length() == 0){
                    m33 = "Closed";

                }
                if(m44.length() == 0){
                    m44 = "Closed";

                }
                if(m55.length() == 0){
                    m55 = "Closed";

                }
                if(m66.length() == 0) {
                    m66 = "Closed";

                }
                if(m77.length() == 0){
                    m77 = "Closed";

                }
                editTextm11.setText("");
                editTextm22.setText("");
                editTextm33.setText("");
                editTextm44.setText("");
                editTextm55.setText("");
                editTextm66.setText("");
                editTextm77.setText("");

                //richiama metodo data per inserimento dei dati nel database
                AddData(m11,m22,m33,m44,m55,m66,m77);

                //a fine inserimento torna nella schermata timetable
                final Intent retback = new Intent(Page_modifytimetable.this,Page_Timetable.class);
                startActivity(retback);

                }
        });

        /* return */
        Button btnret = findViewById(R.id.retbtn);
        final Intent openret = new Intent(Page_modifytimetable.this, Page_Timetable.class);
        btnret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(openret);
            }
        });
    }

    //motodo per inserimento dati nella tabella del relativo database
    public void AddData(String m11,String m22,String m33,String m44,String m55,String m66,String m77){
        boolean insertData = db.addTime(m11,m22,m33,m44,m55,m66,m77);
        if(insertData)
            ToasMessage("Data successfully inserted!");
        else
            ToasMessage("Data not inserted!");
    }
    //metodo per il toast di messaggi a video
    private void ToasMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

}
