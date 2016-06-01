package com.example.profesormanana.a08_pizzas_recyclerview;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by profesormanana on 27/5/16.
 */
public class Pizza implements Serializable{

    private String nombre;
    private List<String> ingredientes = new LinkedList<>();

    public Pizza(List<String> ingredientes, String nombre) {
        this.ingredientes.addAll(ingredientes);
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<String> getIngredientes() {
        return ingredientes;
    }

    public void addIngrediente(String ingrediente) {
        this.ingredientes.add(ingrediente);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pizza pizza = (Pizza) o;

        if (nombre != null ? !nombre.equals(pizza.nombre) : pizza.nombre != null) return false;
        return ingredientes != null ? ingredientes.equals(pizza.ingredientes) : pizza.ingredientes == null;

    }

    @Override
    public int hashCode() {
        int result = nombre != null ? nombre.hashCode() : 0;
        result = 31 * result + (ingredientes != null ? ingredientes.hashCode() : 0);
        return result;
    }
}
