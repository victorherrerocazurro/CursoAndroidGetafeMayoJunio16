package com.example.profesormanana.a18_dialogos;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by profesormanana on 16/6/16.
 */
public class AlertDialogFragment extends DialogFragment {


    private AlertDialog.Builder builder;

    private DialogInterface.OnClickListener positiveListener;
    private DialogInterface.OnClickListener negativeListener;

    public void setPositiveListener(DialogInterface.OnClickListener listener){
        this.positiveListener = listener;
    }

    public void setNegativeListener(DialogInterface.OnClickListener listener){
        this.negativeListener = listener;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //builder = initBuilder();

        builder = new AlertDialog.Builder(getActivity());

        configBuilder(builder);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return builder.create();
    }

    /*protected AlertDialog.Builder initBuilder(){
        return new AlertDialog.Builder(getActivity());
    }*/

    protected void configBuilder(AlertDialog.Builder builder){
        //Configurar el builder para que sea de de tipo aceptarCancelar

        builder
                .setTitle("AlertDialog")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setMessage("¿Desea continuar?")
                .setNegativeButton("No", negativeListener)
                .setPositiveButton("Si", positiveListener);
    }

}
