package com.example.byblospilla;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Page_Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page__info);

        /* return */
        Button btnret = findViewById(R.id.retbtn);
        final Intent openret = new Intent(Page_Info.this, Page1.class);
        btnret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(openret);
            }
        });

        Button IShowDialog = findViewById(R.id.credits);
        IShowDialog.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                /*codice per aprire dialog crediti*/
                AlertDialog.Builder IBuilder = new AlertDialog.Builder(Page_Info.this);
                View IView = getLayoutInflater().inflate(R.layout.dialog_credits, null);

                IBuilder.setView(IView);
                final AlertDialog dialog2 = IBuilder.create();
                dialog2.show();

            }
        });

    }
}
