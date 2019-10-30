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

public class Page_Events extends AppCompatActivity {

    DatabaseHelper1 db1;

    private TextView t1;
    private TextView t2;
    private TextView t3;
    private TextView t4;
    private TextView t5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page__events);

        db1 = new DatabaseHelper1(this);

        t1 = findViewById(R.id.editText1);
        t2 = findViewById(R.id.editText2);
        t3 = findViewById(R.id.editText3);
        t4 = findViewById(R.id.editText4);
        t5 = findViewById(R.id.editText5);

        /* return */
        Button btnret = findViewById(R.id.retbtn);
        final Intent openret = new Intent(Page_Events.this, Page1.class);
        btnret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(openret);
            }
        });

        Button mShowDialog = findViewById(R.id.btnShowDialog);

        mShowDialog.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {
                /*codice per l'admin Login*/
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(Page_Events.this);
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
                            Toast.makeText(Page_Events.this, "Inserisci codice Admin", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }else if (mPassword.getText().toString().equals(pw)){
                            Toast.makeText(Page_Events.this,"Now you are able to modify the timetable!!",Toast.LENGTH_SHORT).show();
                            final Intent openmod = new Intent(Page_Events.this, Page_modifyevents.class);
                            startActivity(openmod);
                            dialog.dismiss();
                        }
                        else{
                            Toast.makeText(Page_Events.this, R.string.no, Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }

                    }
                });
            }
        });

        //viewLast();
        Cursor res = db1.getData();
        if(res.getCount() == 0){
            showMessage("Error","Nothing found!!!");
            return;
        }
        StringBuilder buffer1 = new StringBuilder();
        String t55 = t5.getText().toString();
        String t44 = t4.getText().toString();
        String t33 = t3.getText().toString();
        String t22 = t2.getText().toString();
        String t11 = t1.getText().toString();

        while(res.moveToNext()){
            buffer1.append(res.getString(1));
            //show last data
            if(!t44.equals("Empty")){
                String t = t4.getText().toString();
                t5.setText(t);
            }
            if(!t33.equals("Empty")){
                String t = t3.getText().toString();
                t4.setText(t);
            }
            if(!t22.equals("Empty")){
                String t = t2.getText().toString();
                t3.setText(t);
            }
            if(!t11.equals("Empty")){
                String t = t1.getText().toString();
                t2.setText(t);
            }
            t1.setText(buffer1);
        }



    }

    private void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}
