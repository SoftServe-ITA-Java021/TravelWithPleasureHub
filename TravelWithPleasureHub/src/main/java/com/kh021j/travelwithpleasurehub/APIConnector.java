package com.kh021j.travelwithpleasurehub;

import com.kh021j.travelwithpleasurehub.cfg.TurkishAirlinesJSONConverter;
import com.kh021j.travelwithpleasurehub.common.Connectable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Logger;

public class APIConnector implements Connectable {

    static Logger log;

    @Override
    public void toConnect() throws IOException {

        URL url = new URL("https://api.turkishairlines.com/test/getAvailability");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("apisecret", "8ba2200e100847c68fe5afe0e8824fbe");
        connection.setRequestProperty("Content-type", "application/json");
        connection.setRequestProperty("apikey", "L7xx683220e7213c47778f7582e51094f69c");
        TurkishAirlinesJSONConverter jsonQuery = new TurkishAirlinesJSONConverter();
        String str = jsonQuery.toJSON();
        connection.setFixedLengthStreamingMode(str.length());
        connection.setDoOutput(true);

        OutputStream out = connection.getOutputStream();
        out.write(str.getBytes());
        BufferedReader bufferedReader;

        if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
            bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        } else {
            bufferedReader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
        }

        StringBuilder queryBuilder = new StringBuilder();
        String jsonString;
        while ((jsonString = bufferedReader.readLine()) != null)
            queryBuilder.append(jsonString);
        bufferedReader.close();
        connection.disconnect();
        System.out.println(queryBuilder.toString());
    }

}
