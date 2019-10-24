package com.example.byblospilla;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Page1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        /*creo collegamento al button aule*/
        Button btnrooms = findViewById(R.id.btn_rooms);
        final Intent openbtn_rooms = new Intent(Page1.this, Page_Rooms.class);
        btnrooms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(openbtn_rooms);
            }
        });

        /*creo collegamento al button avvisi*/
        Button btnevents = findViewById(R.id.btn_events);
        final Intent openbtn_events = new Intent(Page1.this, Page_Events.class);
        btnevents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(openbtn_events);
            }
        });

        /*creo collegamento al button Orario*/
        Button btntimetable = findViewById(R.id.btn_timetable);
        final Intent openbtn_timetable = new Intent(Page1.this, Page_Timetable.class);
        btntimetable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(openbtn_timetable);
            }
        });

        Button IShowDialog = findViewById(R.id.credits);
        IShowDialog.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                /*codice per aprire dialog crediti*/
                AlertDialog.Builder IBuilder = new AlertDialog.Builder(Page1.this);
                View IView = getLayoutInflater().inflate(R.layout.dialog_credits, null);

                IBuilder.setView(IView);
                final AlertDialog dialog2 = IBuilder.create();
                dialog2.show();

            }
        });



        /* return */
        Button btnret = findViewById(R.id.retbtn);
        final Intent openret = new Intent(Page1.this, MainActivity.class);
        btnret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(openret);
            }
        });

    }
}
