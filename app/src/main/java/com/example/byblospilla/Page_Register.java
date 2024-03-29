package com.example.byblospilla;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

//PAGINA DEDICATA ALLA REGISTRAZIONE DELL'UTENTE
public class Page_Register extends AppCompatActivity {
    DatabaseHelper db;
    EditText mTextUsername;
    EditText mTextPassword;
    EditText mTextCnfPassword;
    Button mButtonRegister;
    TextView mTextViewLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page__register);

        db = new DatabaseHelper(this);
        mTextUsername = findViewById(R.id.edittext_username);
        mTextPassword = findViewById(R.id.edittext_password);
        mTextCnfPassword = findViewById(R.id.edittext_cnf_password);
        mButtonRegister = findViewById(R.id.button_register);
        mTextViewLogin = findViewById(R.id.textview_login);
        //textview che riporta l'utente alla schermata di login
        mTextViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent LoginIntent = new Intent(Page_Register.this,Page_Login.class);
                startActivity(LoginIntent);
            }
        });

        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = mTextUsername.getText().toString().trim();
                String pwd = mTextPassword.getText().toString().trim();
                String cnf_pwd = mTextCnfPassword.getText().toString().trim();
                //controllo sulla registrazione dell'utente
                if(pwd.equals(cnf_pwd) && !user.isEmpty() && !pwd.isEmpty()){
                    long val = db.addUser(user,pwd);
                    if(val > 0){
                        Toast.makeText(Page_Register.this,"Success!",Toast.LENGTH_SHORT).show();
                        Intent moveToLogin = new Intent(Page_Register.this,Page_Login.class);
                        startActivity(moveToLogin);
                    }
                    else{
                        Toast.makeText(Page_Register.this,"Registration Error",Toast.LENGTH_SHORT).show();
                    }

                }
                else{
                    Toast.makeText(Page_Register.this,"Password is not matching",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}