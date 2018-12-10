package com.kh021j.travelwithpleasurehub.parser.processing;

import java.net.HttpURLConnection;
import java.net.URLConnection;

public interface Connection {

    HttpURLConnection getConnection(String url);

    HttpURLConnection setRequestJsonProperties(HttpURLConnection connection);

    void sendJsonRequest(URLConnection connection, String jsonQuery);

    String getJsonResponse(URLConnection connection);


}
