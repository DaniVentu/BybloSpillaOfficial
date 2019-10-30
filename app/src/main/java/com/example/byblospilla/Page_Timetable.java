package com.example.byblospilla;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Page_Timetable extends AppCompatActivity {
    DatabaseHelper2 db;
    private TextView textViewm1;
    private TextView textViewm2;
    private TextView textViewm3;
    private TextView textViewm4;
    private TextView textViewm5;
    private TextView textViewm6;
    private TextView textViewm7;

    private Button refresh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page__timetable);

        textViewm1 = findViewById(R.id.m1);
        textViewm2 = findViewById(R.id.m2);
        textViewm3 = findViewById(R.id.m3);
        textViewm4 = findViewById(R.id.m4);
        textViewm5 = findViewById(R.id.m5);
        textViewm6 = findViewById(R.id.m6);
        textViewm7 = findViewById(R.id.m7);

        refresh = findViewById(R.id.btnrefresh);

        db = new DatabaseHelper2(this);


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
                final Button mLogin = mView.findViewById(R.id.btnLogin);

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
                            Toast.makeText(Page_Timetable.this,"Now you are able to modify the timetable!!",Toast.LENGTH_SHORT).show();
                            final Intent openmod = new Intent(Page_Timetable.this, Page_modifytimetable.class);
                            startActivity(openmod);
                            dialog.dismiss();
                        }
                        else{
                            Toast.makeText(Page_Timetable.this, R.string.no, Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }

                    }
                });
            }
        });

        //viewLast();
        Cursor res = db.getData();
        if(res.getCount() == 0){
            showMessage("Error","Nothing found!!!");
            return;
        }
        StringBuilder buffer1 = new StringBuilder();
        StringBuilder buffer2 = new StringBuilder();
        StringBuilder buffer3 = new StringBuilder();
        StringBuilder buffer4 = new StringBuilder();
        StringBuilder buffer5 = new StringBuilder();
        StringBuilder buffer6 = new StringBuilder();
        StringBuilder buffer7 = new StringBuilder();

        while(res.moveToNext()){
            buffer1.append(res.getString(1));
            buffer2.append(res.getString(2));
            buffer3.append(res.getString(3));
            buffer4.append(res.getString(4));
            buffer5.append(res.getString(5));
            buffer6.append(res.getString(6));
            buffer7.append(res.getString(7));
        }

        //show last data
        textViewm1.setText(buffer1);
        textViewm2.setText(buffer2);
        textViewm3.setText(buffer3);
        textViewm4.setText(buffer4);
        textViewm5.setText(buffer5);
        textViewm6.setText(buffer6);
        textViewm7.setText(buffer7);

    }


    private void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}
