
package com.kh021j.travelwithpleasurehub.parser.Belavia.processing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kh021j.travelwithpleasurehub.parser.Belavia.BelaviaConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

public class JsonProcessing {

    public void sendJsonRequest(String jsonQuery) throws IOException {
        HttpURLConnection connection = new BelaviaConnection().createConnection();
        OutputStream os = connection.getOutputStream();
        os.write(jsonQuery.getBytes(StandardCharsets.UTF_8));
        os.close();
    }

    public String getJsonResponse() throws IOException {
        HttpURLConnection connection = new BelaviaConnection().getConnection();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder jsonBuilder = new StringBuilder();
        String jsonString;
        while ((jsonString = bufferedReader.readLine()) != null) {
            jsonBuilder.append(jsonString);
        }
        bufferedReader.close();
        return new String(jsonBuilder);
    }

    public String getMinPriceFromResponse() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(getJsonResponse());
        JsonNode itineraries = rootNode.path("itineraries");
        Iterator<JsonNode> elements = itineraries.elements();
        String minPrice = null;
        while (elements.hasNext()) {
            JsonNode brands = elements.next().path("brands");
                minPrice = brands.get(0).get("total").toString();
            }
        return minPrice;
    }

    private JsonNode getNodeFromMainKey(String mainKey) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(getJsonResponse());
        JsonNode mainNode = rootNode.path(mainKey);
        return mainNode;
    }

    private String getInfoFromItineraries(String key) throws IOException {
        JsonNode itineraries = new JsonProcessing().getNodeFromMainKey("itineraries");
        String departureDateTime = itineraries.get(0).
                get(key).toString().replace("\"", "");
        return departureDateTime.replace("T", " ");

    }

    public String getDepartureDateTime() throws IOException {
        String departureDateTime = getInfoFromItineraries("departureDateTime");
        return departureDateTime ;
    }

    public String getArrivalDateTime() throws IOException {
        String arrivalDateTime = getInfoFromItineraries("arrivalDateTime");
        return arrivalDateTime;
    }

    public String getDepature() throws IOException {
        String duration = getInfoFromItineraries("duration");
        return duration;
    }
}
