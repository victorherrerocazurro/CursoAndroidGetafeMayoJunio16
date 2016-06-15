package com.example.profesormanana.a15_procesamientoxml;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by profesormanana on 13/6/16.
 */
public class TerremotosPullParse {

    public List<Terremoto> parseTerremotos(InputStream is, String encoding) throws IOException, XmlPullParserException {

        XmlPullParser parser = Xml.newPullParser();

        if(encoding == null){
            encoding = "UTF-8";
        }

        parser.setInput(is,encoding);

        int tipoEvento = parser.getEventType();

        Terremoto terremoto = null;

        List<Terremoto> resultado = new LinkedList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

        while (tipoEvento != XmlPullParser.END_DOCUMENT || resultado.size() < 10){

            String tagName = parser.getName();

            if(tipoEvento == XmlPullParser.START_TAG) {

                if (tagName.equals("entry")) {
                    terremoto = new Terremoto();
                } else if(terremoto != null){

                    if(tagName.equals("id")){
                        terremoto.setId(parser.nextText());
                    } else if(tagName.equals("title")){
                        terremoto.setTitulo(parser.nextText());
                    } else if(tagName.equals("updated")){
                        try {
                            terremoto.setFecha(sdf.parse(parser.nextText()));
                        } catch (ParseException e) {
                            e.printStackTrace();
                            terremoto.setFecha(null);
                        }
                    } else if(tagName.equals("point") && "georss".equals(parser.getPrefix())){
                        String[] latLon = parser.nextText().split(" ");
                        terremoto.setLatitud(Double.valueOf(latLon[0]));
                        terremoto.setLongitud(Double.valueOf(latLon[1]));
                    } else if(tagName.equals("summary")){
                        terremoto.setDescripcion(parser.nextText());
                    }
                }
            } else if(tipoEvento == XmlPullParser.END_TAG && tagName.equals("entry")){
                resultado.add(terremoto);
                terremoto = null;
            }

            tipoEvento = parser.next();
        }

        return resultado;
    }

}
