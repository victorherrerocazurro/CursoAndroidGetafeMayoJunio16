package com.example.profesormanana.a11_fragmentosdinamicos;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by profesormanana on 3/6/16.
 */
public class CorreoElectronico implements Serializable{

    private String asunto;
    private String contenido;
    private String[] destinatarios;
    private String remitente;
    private String[] cc;
    private String[] cco;
    private Date fechaEnvio;

    public CorreoElectronico() {
    }

    public CorreoElectronico(String asunto, String contenido, String[] destinatarios, String remitente, String[] cc, String[] cco, Date fechaEnvio) {
        this.asunto = asunto;
        this.contenido = contenido;
        this.destinatarios = destinatarios;
        this.remitente = remitente;
        this.cc = cc;
        this.cco = cco;
        this.fechaEnvio = fechaEnvio;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String[] getDestinatarios() {
        return destinatarios;
    }

    public void setDestinatarios(String[] destinatarios) {
        this.destinatarios = destinatarios;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String[] getCc() {
        return cc;
    }

    public void setCc(String[] cc) {
        this.cc = cc;
    }

    public String[] getCco() {
        return cco;
    }

    public void setCco(String[] cco) {
        this.cco = cco;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }
}
