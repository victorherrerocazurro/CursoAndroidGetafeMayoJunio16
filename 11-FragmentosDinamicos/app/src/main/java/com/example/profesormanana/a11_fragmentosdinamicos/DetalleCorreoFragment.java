package com.example.profesormanana.a11_fragmentosdinamicos;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetalleCorreoFragment extends Fragment {



    public static String DATO_CORREO_ELECTONICO = "CorreoElectronico";

    private TextView txAsunto;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detalle_correo, container, false);

        txAsunto = (TextView) view.findViewById(R.id.tx_asunto);

        CorreoElectronico correo = (CorreoElectronico) getActivity().getIntent().getSerializableExtra(DATO_CORREO_ELECTONICO);

        if(correo != null){
            //Estoy en un SmartPhone
            actualizarDetalle(correo);

        } else {
            //Estoy en una Tablet
        }

        return view;
    }

    public void actualizarDetalle(CorreoElectronico correo) {
        txAsunto.setText(correo.getAsunto());
        //TODO falta por completar todos los settext de todos los TextView de informacion del Layout asociado al
        //fragmento de detalle
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }
}
