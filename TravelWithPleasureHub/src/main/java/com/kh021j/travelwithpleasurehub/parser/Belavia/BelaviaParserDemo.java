package com.kh021j.travelwithpleasurehub.parser.Belavia;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kh021j.travelwithpleasurehub.parser.Belavia.model.BelaviaJSON;
import com.kh021j.travelwithpleasurehub.parser.Belavia.model.PassengerQuantities;
import com.kh021j.travelwithpleasurehub.parser.Belavia.model.SearchRoutes;
import com.kh021j.travelwithpleasurehub.parser.Belavia.processing.JsonProcessing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class BelaviaParserDemo {
    private static final String queryUrl = "https://ibe.belavia.by/api/flightsv2/outbound";

    public static void main(String[] args) throws IOException {
        List<SearchRoutes> searchRoutes = new ArrayList<>();
        searchRoutes.add(new SearchRoutes("IEV", "BUD", "2018-12-12", 0));

        List<PassengerQuantities> passengerQuantities = new ArrayList<>();
        passengerQuantities.add(new PassengerQuantities("ADT", 1));

        BelaviaJSON belaviaJSON = new BelaviaJSON("USD", searchRoutes, passengerQuantities);

        JsonProcessing jsonProcessing = new JsonProcessing();

        String jsonQuery = jsonProcessing.objectToJson(belaviaJSON);
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

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(new String(queryBuilder));
        String prettyPrintEmployee = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNode);

        System.out.println(prettyPrintEmployee);
        /*JsonNode personalInformationNode = rootNode.get("total");
        JSONObject jsonObject = new JSONObject(new String(queryBuilder));
        System.out.println("AirLowFares: " + jsonObject.get("total"));*/
        bufferedReader.close();
        connection.disconnect();
    }
}
