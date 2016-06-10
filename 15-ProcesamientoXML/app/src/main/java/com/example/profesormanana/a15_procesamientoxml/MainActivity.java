package com.example.profesormanana.a15_procesamientoxml;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);

        InputStream is = getResources().openRawResource(R.raw.terremotos);

        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = factory.newSAXParser();

            TerremotosSaxHandler handler = new TerremotosSaxHandler();

            //Procesamiento del XML
            saxParser.parse(is, handler);

            List<Terremoto> terremotos = handler.getResultado();

            ArrayAdapter<Terremoto> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, terremotos);

            listView.setAdapter(adapter);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
