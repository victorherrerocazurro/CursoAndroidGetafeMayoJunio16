package com.example.profesormanana.a15_procesamientoxml;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.ext.DefaultHandler2;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by profesormanana on 10/6/16.
 */
public class TerremotosSaxHandler extends DefaultHandler {

    private List<Terremoto> resultado;

    private StringBuilder acumulador;

    //2016-06-10T04:52:09.874Z
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    //Empleamos esta variable, no solo como el almacen de los datos del teremoto, sino como indicador
    //de que estamos procesando un terremoto y leer las etiquetas id, title, ....
    private Terremoto terremoto = null;

    public List<Terremoto> getResultado(){
        return resultado;
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        resultado = new LinkedList<>();
        acumulador =  new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);

        if (qName.equals("entry")){
            terremoto = new Terremoto();
        }

        if (terremoto != null){
            if(qName.equals("link")){
                terremoto.addLink(attributes.getValue("href"));
            }
        }
        acumulador.setLength(0);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        acumulador.append(ch,start,length);


    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if(qName.equals("entry")){
            resultado.add(terremoto);
            terremoto = null;
        }

        if (terremoto != null){
            if(qName.equals("id")){
                //Que a traves de character se habra acumulado el valor entre las etiquetas de inicio y fin de id
                terremoto.setId(acumulador.toString());
            } else if(qName.equals("title")){
                terremoto.setTitulo(acumulador.toString());
            } else if (qName.equals("updated")){
                try {
                    terremoto.setFecha(sdf.parse(acumulador.toString()));
                } catch (ParseException e) {
                    e.printStackTrace();
                    terremoto.setFecha(null);
                }
            } else if(qName.equals("georss:point")){
                String[] latLon = acumulador.toString().split(" ");
                terremoto.setLatitud(Double.valueOf(latLon[0]));
                terremoto.setLongitud(Double.valueOf(latLon[1]));
            } else if (qName.equals("summary")){
                terremoto.setDescripcion(acumulador.toString().trim());

                //Si deseamos interrumpir en un momento el parse del XML
                //throw new SAXException();

            }
        }
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }
}
