package com.example.byblospilla;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

public class modify_timetable_dialog extends AppCompatDialogFragment {
    private EditText editText1m;
    private EditText editText2m;
    private EditText editText3m;
    private EditText editText4m;
    private EditText editText5m;
    private EditText editText6m;
    private EditText editText7m;


    private modify_timetable_dialogListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.modify_timetable, null);

        builder.setView(view)
                .setNegativeButton("Annulla", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Salva", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String m1 = editText1m.getText().toString();
                        String m2 = editText2m.getText().toString();
                        String m3 = editText3m.getText().toString();
                        String m4 = editText4m.getText().toString();
                        String m5 = editText5m.getText().toString();
                        String m6 = editText6m.getText().toString();
                        String m7 = editText7m.getText().toString();


                        listener.applyTexts1(m1 , m2, m3, m4, m5, m6, m7);
                    }
                });
        editText1m = view.findViewById(R.id.m11);
        editText2m = view.findViewById(R.id.m22);
        editText3m = view.findViewById(R.id.m33);
        editText4m = view.findViewById(R.id.m44);
        editText5m = view.findViewById(R.id.m55);
        editText6m = view.findViewById(R.id.m66);
        editText7m = view.findViewById(R.id.m77);



        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (modify_timetable_dialogListener) context;
        } catch (ClassCastException e) {
           throw new ClassCastException(context.toString() + "must implement modify_dialog_Listener");
        }
    }

    public interface modify_timetable_dialogListener{
        void applyTexts1(String m1,String m2,String m3,String m4,String m5,String m6,String m7);
    }
}
