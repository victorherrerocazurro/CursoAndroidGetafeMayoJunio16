package com.example.profesormanana.a11_fragmentosdinamicos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ListadoCorreosFragment extends Fragment {

    private AdapterView.OnItemClickListener listener;

    private ListView lvCorreos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_listado_correos, container, false);

        //Bloque de inicializacion de las vistas
        lvCorreos = (ListView) view.findViewById(R.id.listViewCorreos);

        List<CorreoElectronico> correos = ServicioCorreos.getTodosLosCorreos();

        ArrayAdapter<CorreoElectronico> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, correos);

        lvCorreos.setAdapter(adapter);

        return view;
    }

    //Tenemos la garantia de que se ha ejecutado todo el metodo onCreate de la actividad, y por tanto se han definido las inicializaciones del objeto fragment
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Registrar listener de eventos

        //Aqui podriamos emplear un atributo de clase de tipo OnItemClickListener, que se obtuviese
        // por inyeccion con el correspondiente método de set
        lvCorreos.setOnItemClickListener(listener);
    }

    //Metodo que permitia que desde el exterior, proporcionar al Fragmento un controlador (listener)
    //del evento de click sobre la Lista de Correos
    public void setOnItemClickListener(AdapterView.OnItemClickListener listener){
        this.listener = listener;
    }
}
