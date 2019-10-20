package com.example.byblospilla;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Page1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        /*Creo collegamento al button chi siamo?*/
        Button btnsetting = findViewById(R.id.btn_settings);
        final Intent openbtn_settings = new Intent(Page1.this, Page_Info.class);
        btnsetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(openbtn_settings);
            }
        });

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


        /*creo collegamento al button dove siamo*/
        Button btnwhere = findViewById(R.id.btn_where);
        final Intent openbtn_where = new Intent(Page1.this, Page_where.class);
        btnwhere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(openbtn_where);
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

    public void instagram_link(View view) {
        Intent instagramIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/aulastudiobyblos?igshid=mp7ipsmcjxz8"));
        startActivity(instagramIntent);
    }
}
