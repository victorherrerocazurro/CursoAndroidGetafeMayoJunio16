package com.example.profesormanana.a11_fragmentosdinamicos;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by profesormanana on 3/6/16.
 */
public class ServicioCorreos {

    public static List<CorreoElectronico> getTodosLosCorreos(){
        List<CorreoElectronico> listadoCorreos = new LinkedList<>();

        listadoCorreos.add(new CorreoElectronico("Urgente",
                "Este mensaje es urgente", new String[]{"Pepe", "Juan"},"", null, null, new Date()));

        listadoCorreos.add(new CorreoElectronico("Saludos",
                "Este mensaje es urgente", new String[]{"Pepe", "Juan"},"", null, null, new Date()));

        listadoCorreos.add(new CorreoElectronico("Oferta",
                "Este mensaje es urgente", new String[]{"Pepe", "Juan"},"", null, null, new Date()));

        listadoCorreos.add(new CorreoElectronico("Por favor",
                "Este mensaje es urgente", new String[]{"Pepe", "Juan"},"", null, null, new Date()));

        listadoCorreos.add(new CorreoElectronico("Gracias",
                "Este mensaje es urgente", new String[]{"Pepe", "Juan"},"", null, null, new Date()));

        listadoCorreos.add(new CorreoElectronico("Liquidacion",
                "Este mensaje es urgente", new String[]{"Pepe", "Juan"},"", null, null, new Date()));

        listadoCorreos.add(new CorreoElectronico("Viagra",
                "Este mensaje es urgente", new String[]{"Pepe", "Juan"},"", null, null, new Date()));

        return listadoCorreos;
    }

}
