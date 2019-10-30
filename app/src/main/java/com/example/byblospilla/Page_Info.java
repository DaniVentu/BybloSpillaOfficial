package com.example.byblospilla;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Page_Info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page__info);

        /* Card5 Founders*/
        CardView cardFounders = findViewById(R.id.card5);

        cardFounders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertadd = new AlertDialog.Builder(Page_Info.this);
                LayoutInflater factory = LayoutInflater.from(Page_Info.this);
                final View view = factory.inflate(R.layout.card_founders, null);
                alertadd.setView(view);
                alertadd.show();
            }
        });

        /* Card6 Founders*/
        CardView cardDevelopers = findViewById(R.id.card6);

        cardDevelopers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertadd = new AlertDialog.Builder(Page_Info.this);
                LayoutInflater factory = LayoutInflater.from(Page_Info.this);
                final View view = factory.inflate(R.layout.card_developers, null);
                alertadd.setView(view);
                alertadd.show();
            }
        });



        /* return */
        Button btnret = findViewById(R.id.retbtn);
        final Intent openret = new Intent(Page_Info.this, MainActivity.class);
        btnret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(openret);
            }
        });



    }
}
