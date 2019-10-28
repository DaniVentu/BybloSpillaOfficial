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

public class modify_events_dialog extends AppCompatDialogFragment {

    private EditText editTextModifica;
    private modify_events_dialog_Listener listener;



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder((getActivity()));

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.modify_events,null);

        builder.setView(view)
                .setNegativeButton("Annulla", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton("Salva", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String modifica = editTextModifica.getText().toString();


                        listener.applyTexts(modifica);
                    }
                });
        editTextModifica = view.findViewById(R.id.editevents);


        return builder.create();

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (modify_events_dialog_Listener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + "must implement modify_dialog_Listener");
        }
    }

    public interface modify_events_dialog_Listener{
        void applyTexts(String editEvents);
    }

}
