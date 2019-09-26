package com.example.byblospilla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class page_admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page_admin);

        Button btnadmin = findViewById(R.id.pwadmin);
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
                else
                    ;
            }

        });
    }
}
