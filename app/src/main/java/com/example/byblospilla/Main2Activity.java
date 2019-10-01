package com.example.byblospilla;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        /* Accesso Guest */
        Button btnpage1 = findViewById(R.id.loginguest);
        final Intent openpage1 = new Intent(Main2Activity.this, Page1.class);
        btnpage1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(openpage1);
            }
        });

        /* Accesso Admin */
        Button btn2page1 = findViewById(R.id.loginadmin);
        final Intent open2page1 = new Intent(Main2Activity.this, page_admin.class);
        btn2page1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(open2page1);
            }
        });

        /* Accesso Chi Siamo? */
        TextView textinfo = (TextView) findViewById(R.id.informazione);
        final Intent openPageInfo = new Intent( Main2Activity.this, Page_Info.class);
        textinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(openPageInfo);
            }
        });
        /* return */
        Button btnret = findViewById(R.id.retbtn);
        final Intent openret = new Intent(Main2Activity.this, MainActivity.class);
        btnret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(openret);
            }
        });

    }


}
