package com.example.byblospilla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*  setcontentview mi mostra la prima pagina dell'applicazione!
            * R.layout.activity_main è il percorso per trovare l'interfaccia grafica
            * in generale è R.CARTELLA.NOMERISORSA */

        Button btnaccess = (Button) findViewById(R.id.accessbutton);
        final Intent openMain2Activity = new Intent(MainActivity.this, Main2Activity.class);
        btnaccess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(openMain2Activity);
            }
        });

    }

    /*qui posso scrivere gli altri metodi fuori dal metodo principale!*/

}
