package com.kh021j.travelwithpleasurehub.parser.Belavia;

import com.kh021j.travelwithpleasurehub.parser.Connection;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

public class BelaviaConnection implements Connection {
    private static final String QUERY_URL = "https://ibe.belavia.by/api/flightsv2/outbound";

    @Override
    public HttpURLConnection getConnection() throws IOException {
        URL url = new URL(QUERY_URL);
        return (HttpURLConnection) url.openConnection();
    }

    @Override
    public void setRequestProperties(HttpURLConnection connection) throws ProtocolException {
        connection.setConnectTimeout(3000);
        connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) " +
                "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.110 Safari/537.36");
        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setRequestMethod("POST");
    }

    @Override
    public void closeConnection(HttpURLConnection connection) {
        connection.disconnect();
    }
}
