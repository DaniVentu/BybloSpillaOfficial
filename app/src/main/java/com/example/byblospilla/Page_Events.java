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
//PAGINA UTILIZZATA PER LA VISUALIZZAZIONE DELLE NOTE
public class Page_Events extends AppCompatActivity {
    //chiamo il database per sapere dove salvare le note scritte;
    DatabaseHelper1 db1;
    //definizione delle TextView presenti nel layout;
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
        //reperisco gli id di ogni textview presente nel file xml associato
        t1 = findViewById(R.id.editText1);
        t2 = findViewById(R.id.editText2);
        t3 = findViewById(R.id.editText3);
        t4 = findViewById(R.id.editText4);
        t5 = findViewById(R.id.editText5);

        /* return button*/
        Button btnret = findViewById(R.id.retbtn);
        final Intent openret = new Intent(Page_Events.this, Page1.class);
        btnret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(openret);
            }
        });

        //bottone utile alla chiamata di una dialog per inserire un admin code
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
                            //se l'admin code è corretto, l'utente è abilitato all'inserimento di una nuova nota
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

        //codice per lo shifting delle note ogni volta che una di esse viene inserita nel database
        Cursor res = db1.getData();
        //se il database non contiene note viene visualizzato un messaggio di avviso per l'utente
        if(res.getCount() == 0){
            showMessage("NOTE","BENVENUTO NELLE NOTE! Qui inserire nuove note per informare gli altri utenti! Attenzione: puoi aggiungere note solo se possiedi il codice ADMIN!");
            return;
        }
        //prendo le ultime 5 note del database e le metto nelle textview
        StringBuilder buffer1 = new StringBuilder();
        String t55 = t5.getText().toString();
        String t44 = t4.getText().toString();
        String t33 = t3.getText().toString();
        String t22 = t2.getText().toString();
        String t11 = t1.getText().toString();
        //loop utile allo shifting delle note visualizzate
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
            int len = buffer1.length();
            buffer1.delete(0,len);
        }



    }
    //motodo creato per la visualizzazione di un messaggio dialog cancellabile 
    private void showMessage(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}
