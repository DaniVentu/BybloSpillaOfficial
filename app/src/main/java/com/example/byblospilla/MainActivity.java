package com.example.byblospilla;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //imposto layout da visualizzare!!
        /*setcontentview mi mostra la prima pagina dell'applicazione!
        * R.layout.activity_main è il percorso per trovare l'interfaccia grafica
        * in generale è R.CARTELLA.NOMERISORSA */
        Button btnaccess = (Button) findViewById(R.id.accessbutton);
        final Intent openPage1 = new Intent(MainActivity.this, Page1.class);
        btnaccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(openPage1);
            }
        });


    }

    /*qui posso scrivere gli altri metodi fuori dal metodo principale!*/



}
