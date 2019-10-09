package com.example.byblospilla;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Page_Events extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page__events);

        /* return */
        Button btnret = findViewById(R.id.retbtn);
        final Intent openret = new Intent(Page_Events.this, Page1.class);
        btnret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(openret);
            }
        });


        /*prova dialog*/

        Button mShowDialog = findViewById(R.id.btnShowDialog);


        mShowDialog.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                AlertDialog.Builder mBuilder = new AlertDialog.Builder(Page_Events.this);
                View mView = getLayoutInflater().inflate(R.layout.my_dialog, null);
                final EditText mPassword =  mView.findViewById(R.id.numericpw);
                Button mLogin = mView.findViewById(R.id.btnLogin);

                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();
                mLogin.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        String pw = "1923";
                        if(mPassword.getText().toString().isEmpty()){
                            Toast.makeText(Page_Events.this, "Inserisci codice Admin", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }else if (mPassword.getText().toString().equals(pw)){
                            Toast.makeText(Page_Events.this, R.string.si,Toast.LENGTH_SHORT).show();

                        }
                        else{
                            Toast.makeText(Page_Events.this, R.string.no, Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }

                    }
                });
            }
        });
    }

}
