
package com.kh021j.travelwithpleasurehub.parser.Belavia.processing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kh021j.travelwithpleasurehub.parser.Belavia.BelaviaConnection;
import com.kh021j.travelwithpleasurehub.parser.Belavia.model.BelaviaJSON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

public class JsonProcessing {

    public String objectToJson(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }

    public Object jsonToObject(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, BelaviaJSON.class);
    }

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

    public String getPriceBeforAndAfter() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(getJsonResponse());
        JsonNode itineraries = rootNode.path("airLowFares");
        Iterator<JsonNode> elements = itineraries.elements();
        StringBuilder priceBuilder = new StringBuilder();
        while (elements.hasNext()) {
            priceBuilder.append(elements.next().get("total"));
        }
        return new String(priceBuilder);
    }

    public String getPriceFromResponse() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(getJsonResponse());
        JsonNode itineraries = rootNode.path("itineraries");
        Iterator<JsonNode> elements = itineraries.elements();
        StringBuilder priceBuilder = new StringBuilder();
        while (elements.hasNext()) {
            JsonNode brands = elements.next().path("brands");
            Iterator<JsonNode> newElements = brands.elements();
            while (newElements.hasNext()) {
                JsonNode total = newElements.next();
                priceBuilder.append(total.get("total")).append(" ");
            }
        }
        return new String(priceBuilder).trim();
    }

    public float getMinPrice() throws IOException {
        String[] values;
        float min = 0;
        if (getPriceFromResponse() == null) {
            values = getPriceBeforAndAfter().split(" ");
            min = Float.parseFloat(values[0]);
            for (String value : values) {
                float tmp = Float.parseFloat(value);
                if (tmp < min) {
                    min = tmp;
                }
            }
            return min;
        } else if (getPriceFromResponse() == null && getPriceBeforAndAfter() == null) {
            return min;
        } else {
            values = getPriceFromResponse().split(" ");
            min = Float.parseFloat(values[0]);
            for (String value : values) {
                float tmp = Float.parseFloat(value);
                if (tmp < min) {
                    min = tmp;
                }
            }
        }
        return min;
    }
}
