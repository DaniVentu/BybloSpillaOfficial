package com.example.byblospilla;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //imposto layout da visualizzare!!
        /*setcontentview mi mostra la prima pagina dell'applicazione!
        * R.layout.activity_main è il percorso per trovare l'interfaccia grafica
        * in generale è R.CARTELLA.NOMERISORSA */
        Button btnaccess = findViewById(R.id.accessbutton);
        final Intent openPage1 = new Intent(MainActivity.this, Page1.class);
        btnaccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(openPage1);
            }
        });

        /*Creo collegamento al button chi siamo?*/
        Button btnsetting = findViewById(R.id.btn_settings);
        final Intent openbtn_settings = new Intent(MainActivity.this, Page_Info.class);
        btnsetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(openbtn_settings);
            }
        });

        /*creo collegamento al button dove siamo*/
        Button btnwhere = findViewById(R.id.btn_where);
        final Intent openbtn_where = new Intent(MainActivity.this, Page_where.class);
        btnwhere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(openbtn_where);
            }
        });

    }

    /*qui posso scrivere gli altri metodi fuori dal metodo principale!*/


    public void instagram_link(View view) {
        Intent instagramIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/aulastudiobyblos?igshid=mp7ipsmcjxz8"));
        startActivity(instagramIntent);
    }

}
