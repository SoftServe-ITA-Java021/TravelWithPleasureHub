
package com.kh021j.travelwithpleasurehub.parser.Belavia.processing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kh021j.travelwithpleasurehub.parser.Belavia.model.BelaviaJSON;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;

public class JsonProcessing {

    public String objectToJson(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }

    public Object jsonToObject(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, BelaviaJSON.class);
    }

    public void sendJsonRequest(HttpURLConnection connection, String jsonQuery) throws IOException {
        OutputStream os = connection.getOutputStream();
        os.write(jsonQuery.getBytes(StandardCharsets.UTF_8));
        os.close();
    }

    public String getJsonResponse(HttpURLConnection connection) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder jsonBuilder = new StringBuilder();
        String jsonString;
        while ((jsonString = bufferedReader.readLine()) != null) {
            jsonBuilder.append(jsonString);
        }
        bufferedReader.close();
        return new String(jsonBuilder);
    }

    public void getPricefromResponce() throws IOException {
       ObjectMapper objectMapper = new ObjectMapper();
       JsonNode rootNode = objectMapper.readTree("asd");
    }
}
