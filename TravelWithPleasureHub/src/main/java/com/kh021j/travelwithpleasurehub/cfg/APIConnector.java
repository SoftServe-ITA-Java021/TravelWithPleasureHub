package com.kh021j.travelwithpleasurehub.cfg;

import com.kh021j.travelwithpleasurehub.common.Connectable;

import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.*;
import java.net.URL;
import java.net.HttpURLConnection;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class APIConnector implements Connectable {

    private static APIConnector api = new APIConnector();

    @Override
    public HttpURLConnection setConnection() throws IOException {

        Element el = getElement("tur");

        URL url = new URL(el.getElementsByTagName("url").item(0).getTextContent());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("apisecret", el.getElementsByTagName("apisecret").item(0).getTextContent());
        connection.setRequestProperty("Content-type", "application/json");
        connection.setRequestProperty("apikey", el.getElementsByTagName("apikey").item(0).getTextContent());

        return connection;
    }

    private boolean sendRequest(HttpURLConnection connection) throws IOException {
        boolean flag = false;
        TurkishAirlinesJSONConverter model = new TurkishAirlinesJSONConverter();
        String stringQuery = model.toJSON();
        connection.setFixedLengthStreamingMode(stringQuery.length());
        connection.setDoOutput(true);
        OutputStream outputStream = connection.getOutputStream();
        outputStream.write(stringQuery.getBytes());

        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            flag = true;
        }
        return flag;
    }

    private String gerResponse() throws IOException {
        HttpURLConnection httpURLConnection = setConnection();
        boolean status = sendRequest(httpURLConnection);

        BufferedReader bufferedReader;
        if (status) {
            bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
        } else {
            bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getErrorStream()));
        }

        StringBuilder responseString = new StringBuilder();
        String temp;
        while ((temp = bufferedReader.readLine()) != null)
            responseString.append(temp);
        return responseString.toString();
    }

    private NodeList readXML() throws IOException {
        NodeList nodeList = null;
        try {
            File file = new File("./src/main/resources/res");
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);

            document.getDocumentElement().normalize();

            nodeList = document.getElementsByTagName("connection");

        } catch (ParserConfigurationException | SAXException exception) {
            exception.printStackTrace();
        }
        return nodeList;
    }

    private Element getElement(String param) throws IOException {
        NodeList nodeList = api.readXML();
        Element el = null;
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE && ((Element) node).hasAttribute(param)) {
                el = (Element) node;
            }
        }
        return el;
    }
}
