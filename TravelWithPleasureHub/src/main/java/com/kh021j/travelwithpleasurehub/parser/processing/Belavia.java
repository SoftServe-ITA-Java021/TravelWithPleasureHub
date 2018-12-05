package com.kh021j.travelwithpleasurehub.parser.processing;

import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Belavia {
    private static String queryUrl = "https://ibe.belavia.by/api/flightsv2/outbound";
    private static String jsonQuery = "{\"currency\":\"USD\",\"searchRoutes\":" +
            "[{\"origin\":\"IEV\",\"destination\":\"BUD\",\"departing\":" +
            "\"2018-12-08\",\"direction\":0}],\"passengerQuantities\":" +
            "[{\"code\":\"ADT\",\"quantity\":1}]}";

    public static void main(String[] args) throws IOException {
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
        os.write(jsonQuery.getBytes("UTF-8"));
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
    }
}
