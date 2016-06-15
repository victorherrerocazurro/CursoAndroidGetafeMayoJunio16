package com.example.profesormanana.a16_noticiaselpais;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by profesormanana on 13/6/16.
 */
public class NoticiasSaxHandler extends DefaultHandler{
    private List<Noticia> resultado;

    //Empleamos esta variable, no solo como el almacen de los datos del teremoto, sino como indicador
    //de que estamos procesando un terremoto y leer las etiquetas id, title, ....
    public List<Noticia> getResultado() {
        return this.resultado;
    }

    private Noticia noticia;

    private StringBuilder acumulador;

    //2016-06-10T04:52:09.874Z
    //Mon, 13 Jun 2016 09:24:51 +0200
    //EEE, d MMM yyyy hh:mm:ss Z
    private SimpleDateFormat sdf = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        resultado = new LinkedList<>();
        acumulador =  new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);

        if (qName.equals("item")){
            noticia = new Noticia();
        }

        //Vacio antes de empezar a acumular la info que me interesa, que es la que esta entre una
        //etiqueta de inicio y su etiqueta de fin
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

        if(qName.equals("item")){
            resultado.add(noticia);
            noticia = null;
        }

        if (noticia != null){
            if(qName.equals("title")){
                noticia.setTitle(acumulador.toString());
            } else if (qName.equals("pubDate")){
                try {
                    noticia.setFecha(sdf.parse(acumulador.toString()));
                } catch (ParseException e) {
                    e.printStackTrace();
                    noticia.setFecha(null);
                }
            } else if(qName.equals("dc:creator")){
                noticia.setAutor(acumulador.toString());
            } else if (qName.equals("description")){
                noticia.setDescripcion(acumulador.toString().trim());
            } else if (qName.equals("link")){
                noticia.setLink(acumulador.toString().trim());
            }
        }
    }
}
