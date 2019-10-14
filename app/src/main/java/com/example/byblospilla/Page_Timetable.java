package com.example.byblospilla;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Page_Timetable extends AppCompatActivity implements modify_timetable_dialog.modify_timetable_dialogListener {

    private TextView textViewm1;
    private TextView textViewp1;
    private TextView textViewm2;
    private TextView textViewp2;
    private TextView textViewm3;
    private TextView textViewp3;
    private TextView textViewm4;
    private TextView textViewp4;
    private TextView textViewm5;
    private TextView textViewp5;
    private TextView textViewm6;
    private TextView textViewp6;
    private TextView textViewm7;
    private TextView textViewp7;
    private Button btnadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page__timetable);

        /* return */
        Button btnret = findViewById(R.id.retbtn);
        final Intent openret = new Intent(Page_Timetable.this, Page1.class);
        btnret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(openret);
            }
        });

        /*button dialog*/

        Button mShowDialog = findViewById(R.id.btnShowDialog);

        mShowDialog.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                /*codice per l'admin Login*/
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(Page_Timetable.this);
                View mView = getLayoutInflater().inflate(R.layout.my_dialog, null);
                final EditText mPassword =  mView.findViewById(R.id.numericpw);
                Button mLogin = mView.findViewById(R.id.btnLogin);

                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();

                /*codice per impostare il Dialog di modifica*/
                mLogin.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        String pw = "1923";
                        if(mPassword.getText().toString().isEmpty()){
                            Toast.makeText(Page_Timetable.this, "Inserisci codice Admin", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }else if (mPassword.getText().toString().equals(pw)){
                            Toast.makeText(Page_Timetable.this, R.string.si,Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                            /*starting modifying timetable code*/
                            textViewm1 = findViewById(R.id.m1);
                            textViewp1 = findViewById(R.id.p1);
                            textViewm2 = findViewById(R.id.m2);
                            textViewp2 = findViewById(R.id.p2);
                            textViewm3 = findViewById(R.id.m3);
                            textViewp3 = findViewById(R.id.p3);
                            textViewm4 = findViewById(R.id.m4);
                            textViewp4 = findViewById(R.id.p4);
                            textViewm5 = findViewById(R.id.m5);
                            textViewp5 = findViewById(R.id.p5);
                            textViewm6 = findViewById(R.id.m6);
                            textViewp6 = findViewById(R.id.p6);
                            textViewm7 = findViewById(R.id.m7);
                            textViewp7 = findViewById(R.id.p7);
                            btnadd = findViewById(R.id.btnShowDialog);
                            btnadd.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    openDialog();
                                }
                            });

                        }
                        else{
                            Toast.makeText(Page_Timetable.this, R.string.no, Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }

                    }
                });
            }
        });
    }

    @Override
    public void applyTexts1(String m1, String p1, String m2, String p2, String m3, String p3, String m4, String p4, String m5, String p5, String m6, String p6, String m7, String p7) {
        if(!m1.equals("Chiusa")){
            if(!m1.equals(""))
                textViewm1.setText(m1);
        }


        if(!p1.equals("Chiusa")){
            if (!p1.equals(""))
                textViewp1.setText(p1);
        }

        if(!m2.equals("Chiusa")){
            if (!p2.equals(""))
                textViewm2.setText(m2);
        }

        if(!p2.equals("Chiusa")){
            if (!p2.equals(""))
                textViewp2.setText(p2);
        }

        if(!m3.equals("Chiusa")){
            if (!m3.equals(""))
                textViewm3.setText(m3);
        }

        if(!p3.equals("Chiusa")){
            if (!p3.equals(""))
                textViewp3.setText(p3);
        }

        if(!m4.equals("Chiusa")){
            if (!m4.equals(""))
                textViewm4.setText(m4);
        }

        if(!p4.equals("Chiusa")){
            if (!p4.equals(""))
                textViewp4.setText(p4);
        }

        if(!m5.equals("Chiusa")){
            if (!m5.equals(""))
                textViewm5.setText(m5);
        }

        if(!p5.equals("Chiusa")){
            if (!p5.equals(""))
                textViewp5.setText(p5);
        }

        if(!m6.equals("Chiusa")){
            if (!m6.equals(""))
                textViewm6.setText(m6);
        }

        if(!p6.equals("Chiusa")){
            if (!p6.equals(""))
                textViewp6.setText(p6);
        }

        if(!m7.equals("Chiusa")){
            if (!m7.equals(""))
                textViewm7.setText(m7);
        }

        if(!p7.equals("Chiusa")){
            if (!p7.equals(""))
                textViewp7.setText(p7);
        }

    }

    public void openDialog(){
        modify_timetable_dialog modify_timetable_dialog = new modify_timetable_dialog();
        modify_timetable_dialog.show(getSupportFragmentManager(),"modify timetable dialog");
    }
}
