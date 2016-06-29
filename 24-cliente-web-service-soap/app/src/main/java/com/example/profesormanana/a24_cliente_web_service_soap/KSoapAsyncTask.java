package com.example.profesormanana.a24_cliente_web_service_soap;

import android.os.AsyncTask;
import android.util.Log;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.net.Proxy;

/**
 * Created by profesormanana on 23/6/16.
 */
public class KSoapAsyncTask extends AsyncTask<String,Void,SoapObject> {
    private static final String NAMESPACE;
    private static final String URL;
    private static final String SOAP_ACTION;

    static {
        URL = "http://10.1.2.100:8080/PeliculasWS/services/GestionPeliculas";
        NAMESPACE = "http://a21_sqlite.profesormanana.example.com";
        SOAP_ACTION = "read";
    }
    @Override
    protected SoapObject doInBackground(String... params) {
        // obtener una pelicula
        SoapObject nodoRead = new SoapObject(NAMESPACE, SOAP_ACTION);// <q0:read q0:xmlns="http://a21_sqlite.profesormanana.example.com"/>
        SoapObject nodoId = new SoapObject(NAMESPACE, "id");//<q0:id q0:xmlns="http://a21_sqlite.profesormanana.example.com"/>
        nodoRead.addSoapObject(nodoId);//<q0:read q0:xmlns="http://a21_sqlite.profesormanana.example.com"><q0:id/></q0:read>
        nodoId.setInnerText(1);//<q0:read q0:xmlns="http://a21_sqlite.profesormanana.example.com"><q0:id>1</q1:id></q0:read>
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet = true;
        envelope.setAddAdornments(true);
        envelope.implicitTypes = true;
        envelope.setOutputSoapObject(nodoRead);
        HttpTransportSE httpTransportSE = new HttpTransportSE(Proxy.NO_PROXY, URL, 60000);
        httpTransportSE.debug = true;
        httpTransportSE.setXmlVersionTag("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        try {
            httpTransportSE.call(SOAP_ACTION,envelope);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }
        try {
            return (SoapObject) envelope.getResponse();
        } catch (SoapFault soapFault) {
            soapFault.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(SoapObject envelope) {
        super.onPostExecute(envelope);
        Log.d("Resultado",envelope.toString());
        Log.d("Toma director: ",envelope.getProperty(NAMESPACE,"director").toString());
    }
}
