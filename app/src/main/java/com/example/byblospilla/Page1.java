package com.example.byblospilla;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

public class Page1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        TextView instagram = (TextView) findViewById(R.id.ig);
        instagram.setMovementMethod(LinkMovementMethod.getInstance());

    }


}
