package com.example.byblospilla;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Page_Rooms extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page__rooms);


        /*CardView cardG = findViewById(R.id.cardGialla);
        final Intent opencardG = new Intent (Page_Rooms.this, Page_Gallery.class);
        cardG.setOnClickListener(new View.OnClickListener(){
            public void onClick (View v) {
                startActivity(opencardG);
            }
        }); */



        /* return */


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
