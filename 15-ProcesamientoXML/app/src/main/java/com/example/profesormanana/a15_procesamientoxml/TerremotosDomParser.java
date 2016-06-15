package com.example.profesormanana.a15_procesamientoxml;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

/**
 * Created by profesormanana on 13/6/16.
 */
public class TerremotosDomParser {

    public List<Terremoto> parseTerremotosPorCategoria(InputStream is, String categoria)
            throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {



        List<Terremoto> resultado = new LinkedList<>();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder documentBuilder = factory.newDocumentBuilder();

        Document document = documentBuilder.parse(is);

        //EN HTML y CSS
        // <div> <div> <p> <a class="resaltado"></a> </p> </div> </div>
        //div div p a.resaltado { }


        //XPath, es un API que permite realizar selecciones de los nodos por sus caracteristicas
        // /feed/entry/category[term='Magnitude 4']

        XPathFactory xPathFactory = XPathFactory.newInstance();

        XPath xPath = xPathFactory.newXPath();

        NodeList listadoDeNodoCategoriaMagnitud4 = (NodeList) xPath.evaluate("/feed/entry/category[@term='"+ categoria +"']", document, XPathConstants.NODESET);

        addNodeListToResultado(listadoDeNodoCategoriaMagnitud4, resultado);

        NodeList listadoDeNodoCategoriaMagnitud6 = (NodeList) xPath.evaluate("/feed/entry/category[@term='Magnitude 6']", document, XPathConstants.NODESET);

        addNodeListToResultado(listadoDeNodoCategoriaMagnitud6, resultado);

        return resultado;
    }

    private void addNodeListToResultado(NodeList listadoDeNodoCategoriaMagnitud4, List<Terremoto> resultado){

        //2016-06-10T04:52:09.874Z
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

        for (int i = 0; i < listadoDeNodoCategoriaMagnitud4.getLength(); i++  ) {
            Node item = listadoDeNodoCategoriaMagnitud4.item(i);

            Node nodoEntry = item.getParentNode();

            Terremoto terremoto = new Terremoto();

            NodeList listadoHijosDeEntry = nodoEntry.getChildNodes();

            for (int j = 0; j < listadoHijosDeEntry.getLength(); j++){
                Node hijo = listadoHijosDeEntry.item(j);

                if (hijo.getNodeName().equals("id")){
                    terremoto.setId(hijo.getFirstChild().getNodeValue());
                } else if (hijo.getNodeName().equals("updated")){
                    try {
                        terremoto.setFecha(sdf.parse(hijo.getFirstChild().getNodeValue()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                        terremoto.setFecha(null);
                    }
                } else if (hijo.getNodeName().equals("title")){
                    terremoto.setTitulo(hijo.getFirstChild().getNodeValue());
                } else if (hijo.getNodeName().equals("georss:point")){
                    String[] latLon = hijo.getFirstChild().getNodeValue().split(" ");
                    terremoto.setLatitud(Double.valueOf(latLon[0]));
                    terremoto.setLongitud(Double.valueOf(latLon[1]));
                } else if (hijo.getNodeName().equals("summary")){
                    terremoto.setDescripcion(hijo.getFirstChild().getNodeValue());
                }
            }

            resultado.add(terremoto);
        }
    }

}
