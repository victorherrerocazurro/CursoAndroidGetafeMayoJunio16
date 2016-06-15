package com.example.profesormanana.a16_noticiaselpais;

import android.os.AsyncTask;
import android.widget.Adapter;
import android.widget.ArrayAdapter;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by profesormanana on 13/6/16.
 */
public class DescargaRssNoticias extends AsyncTask<String, Void, List<Noticia>>{

    private ArrayAdapter<Noticia> adapter;

    public DescargaRssNoticias(ArrayAdapter<Noticia> adapter) {
        this.adapter = adapter;
    }

    @Override
    protected List<Noticia> doInBackground(String... params) {

        URL url = null;

        try {
            url = new URL(params[0]);

            URLConnection connection = url.openConnection();

            InputStream is = connection.getInputStream();

            SAXParserFactory factory = SAXParserFactory.newInstance();

            SAXParser saxParser = factory.newSAXParser();

            NoticiasSaxHandler handler = new NoticiasSaxHandler();

            //Procesamiento del XML
            saxParser.parse(is, handler);

            return handler.getResultado();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(List<Noticia> noticias) {
        super.onPostExecute(noticias);

        if(noticias != null){
            //deesta forma la dependencia solo es adapter
            adapter.addAll(noticias);
            adapter.notifyDataSetChanged();

            //Si lo hacemos con esta opcion, las dependencias son listView y context
            //ArrayAdapter<Noticia> adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1, noticias);
            //listView.setAdapter(adapter);
        }
    }
}
