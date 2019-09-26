package com.example.byblospilla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Page1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        /* Creo il collegamento alla pagina instagram "aulastudibyblos" */
        TextView instagram = (TextView) findViewById(R.id.ig);
        instagram.setMovementMethod(LinkMovementMethod.getInstance());

        /*Creo collegamento al button Impostazioni*/
        /* Accesso Admin */
        Button btnsetting = findViewById(R.id.btn_settings);
        final Intent openbtn_settings = new Intent(Page1.this, Page_Settings.class);
        btnsetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(openbtn_settings);
            }
        });
    }


}
