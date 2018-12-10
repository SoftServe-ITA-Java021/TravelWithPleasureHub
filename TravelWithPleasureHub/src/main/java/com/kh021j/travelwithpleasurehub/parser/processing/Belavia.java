package com.kh021j.travelwithpleasurehub.parser.processing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kh021j.travelwithpleasurehub.parser.model.BelaviaJSON;
import com.kh021j.travelwithpleasurehub.parser.model.PassengerQuantities;
import com.kh021j.travelwithpleasurehub.parser.model.SearchRoutes;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;

public class Belavia {
    private static String queryUrl = "https://ibe.belavia.by/api/flightsv2/outbound";
    private static String jsonQuery = "{\"currency\":\"USD\",\"searchRoutes\":" +
            "[{\"origin\":\"IEV\",\"destination\":\"BUD\",\"departing\":" +
            "\"2018-12-12\",\"direction\":0}],\"passengerQuantities\":" +
            "[{\"code\":\"ADT\",\"quantity\":1}]}";


    public HttpURLConnection getConnection(String urlQuery) throws IOException {
        URL url = new URL(urlQuery);
        return (HttpURLConnection) url.openConnection();
    }

    public HttpURLConnection setRequestJsonProperties(HttpURLConnection connection) throws ProtocolException {
        connection.setConnectTimeout(3000);
        connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) " +
                "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36");
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestMethod("POST");
        return connection;
    }

    public void sendJsonRequest(URLConnection connection, String jsonQuery) throws IOException {
        OutputStream os = connection.getOutputStream();
        os.write(jsonQuery.getBytes(StandardCharsets.UTF_8));
        os.close();
    }

    public String getJsonResponse(URLConnection connection) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder jsonBuilder = new StringBuilder();
        String jsonString;
        while ((jsonString = bufferedReader.readLine()) != null) {
            jsonBuilder.append(jsonString);
        }
        bufferedReader.close();
        return new String(jsonBuilder);
    }

    public void closeConnection(HttpURLConnection connection) {
        connection.disconnect();
    }

    public static String objectToJson(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }

    public Object jsonToObject(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, Belavia.class);
    }

    /*public static void main(String[] args) throws IOException {
        BelaviaJSON belaviaJSON = new BelaviaJSON("USD",
                new SearchRoutes("IEV", "BUD", "2018-12-12", 0),
                new PassengerQuantities("ADT", 1));

        String jsonQuery = objectToJson(belaviaJSON);
        System.out.println(jsonQuery);


        URL url = new URL(queryUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setConnectTimeout(3000);
        connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) " +
                "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36");
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestMethod("POST");

        OutputStream os = connection.getOutputStream();
        os.write(jsonQuery.getBytes(StandardCharsets.UTF_8));
        os.close();
        // read the response
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder queryBuilder = new StringBuilder();
        String jsonString;
        while ((jsonString = bufferedReader.readLine()) != null) {
            queryBuilder.append(jsonString);
        }
        System.out.println(queryBuilder);
        JSONObject jsonObject = new JSONObject(new String(queryBuilder));
        System.out.println("AirLowFares: " + jsonObject.get("airLowFares"));
        bufferedReader.close();
        connection.disconnect();
    }*/
}
