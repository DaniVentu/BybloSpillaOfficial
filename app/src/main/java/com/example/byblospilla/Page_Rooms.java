package com.example.byblospilla;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Page_Rooms extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page__rooms);

        /* collegamento cardview Aula Gialla con foto */

        CardView cardG = findViewById(R.id.cardGialla);

        cardG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertadd_1 = new AlertDialog.Builder(Page_Rooms.this);
                LayoutInflater factory_1 = LayoutInflater.from(Page_Rooms.this);
                final View view_1 = factory_1.inflate(R.layout.card_gialla, null);
                alertadd_1.setView(view_1);
                alertadd_1.show();
            }
        });

        /* collegamento cardview Aula Verde con foto */
        CardView cardV = findViewById(R.id.cardVerde);
        cardV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertadd_2 = new AlertDialog.Builder(Page_Rooms.this);
                LayoutInflater factory_2 = LayoutInflater.from(Page_Rooms.this);
                final View view_2 = factory_2.inflate(R.layout.card_verde, null);
                alertadd_2.setView(view_2);
                alertadd_2.show();
            }
        });


        Button btnret = findViewById(R.id.retbtn);
        final Intent openret = new Intent(Page_Rooms.this, Page1.class);
        btnret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(openret);
            }
        });
    }
}
