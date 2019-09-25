package com.example.byblospilla;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.preference.EditTextPreference;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //imposto layout da visualizzare!!
        /*setcontentview mi mostra la prima pagina dell'applicazione!
        * R.layout.activity_main è il percorso per trovare l'interfaccia grafica
        * in generale è R.CARTELLA.NOMERISORSA */

    }

    /*qui posso scrivere gli altri metodi fuori dal metodo principale!*/


}
