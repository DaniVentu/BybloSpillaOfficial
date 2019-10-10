package com.example.byblospilla;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Page_Timetable extends AppCompatActivity {

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
                            AlertDialog.Builder LBuilder = new AlertDialog.Builder(Page_Timetable.this);
                            View LView = getLayoutInflater().inflate(R.layout.modify_timetable, null);
                            Button LSalva = LView.findViewById(R.id.btnsalva);
                            LBuilder.setView(LView);
                            final AlertDialog dialog1 = LBuilder.create();
                            dialog1.show();

                            LSalva.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    Toast.makeText(Page_Timetable.this,"Modifiche Salvate Correttamente!",Toast.LENGTH_SHORT).show();
                                    /*
                                    * salvataggio su TextView
                                    * */
                                    dialog1.dismiss();
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
}
