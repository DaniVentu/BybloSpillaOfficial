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

public class Page_Events extends AppCompatActivity implements modify_events_dialog.modify_events_dialog_Listener{

    private TextView textView1;
    private Button btnadd;

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
                final EditText mPassword = mView.findViewById(R.id.numericpw);
                Button mLogin = mView.findViewById(R.id.btnLogin);

                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();
                mLogin.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        String pw = "1923";
                        if (mPassword.getText().toString().isEmpty()) {
                            Toast.makeText(Page_Events.this, "Inserisci codice Admin", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        } else if (mPassword.getText().toString().equals(pw)) {
                            Toast.makeText(Page_Events.this, R.string.si, Toast.LENGTH_LONG).show();
                            dialog.dismiss();
                            /*starting modifying timetable code*/
                            textView1 = findViewById(R.id.editText1);
                            btnadd = findViewById(R.id.btnShowDialog);
                            btnadd.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    openDialog();
                                }
                            });
                        } else {
                            Toast.makeText(Page_Events.this, R.string.no, Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }

                    }
                });
            }
        });

    }
    public void openDialog(){
        modify_events_dialog modify_events_dialog = new modify_events_dialog();
        modify_events_dialog.show(getSupportFragmentManager(),"modify events dialog");
    }

    @Override
    public void applyTexts(String editEvents) {
        textView1.setText(editEvents);
    }

}