package com.curso.android.ejemplochatfirebase;

import android.util.Log;

/**
 * Created by kane_project on 28/6/16.
 */
public class Mensaje {
    private String usuario;
    private String mensaje;

    public Mensaje(){

    }
    public Mensaje(String string){
        Log.d("MENSAJE",string);
        usuario = string;
    }
    public Mensaje(String mensaje, String usuario) {
        this.mensaje = mensaje;
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
