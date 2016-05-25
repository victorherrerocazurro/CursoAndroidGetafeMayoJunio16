package com.example.profesormanana.a03_comunicacionentreactividades;

import java.io.Serializable;

/**
 * Created by profesormanana on 25/5/16.
 */
public class Persona implements Serializable {

    public static final long version = 1L;

    private String nombre;
    transient private Direccion direccion;

    public Persona(String nombre, Direccion direccion){
        this.nombre = nombre;
        this.direccion = direccion;
    }


    public String getNombre() {
        return nombre;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}
