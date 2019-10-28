package com.example.byblospilla;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Page_Events extends AppCompatActivity implements modify_events_dialog.modify_events_dialog_Listener{

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;

    private Button btnadd;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page__events);

        final ListView listView = findViewById(R.id.listview);
        Button btnsave = findViewById(R.id.btnSalva);
        final ArrayList<String> list;
        final EditText editText = findViewById(R.id.edittype);
        list = new ArrayList<>();
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, list);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String notes = editText.getText().toString();
                list.add(notes);

                listView.setAdapter(arrayAdapter);
                arrayAdapter.notifyDataSetChanged();
            }
        });



        /* return */
        Button btnret = findViewById(R.id.retbtn);
        final Intent openret = new Intent(Page_Events.this, Page1.class);
        btnret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(openret);
            }
        });

    }
    public void openDialog(){
        modify_events_dialog modify_events_dialog = new modify_events_dialog();
        modify_events_dialog.show(getSupportFragmentManager(),"modify events dialog");
    }

    @Override
    public void applyTexts(String editEvents) {

        if(!textView4.getText().toString().equals("Nessun Avviso"))
            textView5.setText(textView4.getText().toString());
        if(!textView3.getText().toString().equals("Nessun Avviso"))
            textView4.setText(textView3.getText().toString());
        if(!textView2.getText().toString().equals("Nessun Avviso"))
            textView3.setText(textView2.getText().toString());
        if(!textView1.getText().toString().equals("Nessun Avviso"))
            textView2.setText(textView1.getText().toString());

        textView1.setText(editEvents);



    }
}
