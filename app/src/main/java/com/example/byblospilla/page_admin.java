package com.example.byblospilla;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class page_admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_admin);

        final Button btnadmin = findViewById(R.id.pwadmin);
        final Intent openmenu = new Intent(page_admin.this, Page1.class);
        btnadmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText recuperapw = (EditText) findViewById(R.id.numericpw);
                String Spw = recuperapw.getText().toString();
                String pw = "1923";
                if (Spw.equals(pw)) {
                    startActivity(openmenu);
                }
                else {
                    recuperapw.setError("please enter valid code!");
                }
            }

        });
        /* return */
        Button btnret = findViewById(R.id.retbtn);
        final Intent openret = new Intent(page_admin.this, Main2Activity.class);
        btnret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(openret);
            }
        });
    }
}
