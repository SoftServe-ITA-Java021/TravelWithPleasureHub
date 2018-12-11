package com.kh021j.travelwithpleasurehub.parser;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;

public interface Connection {

    public HttpURLConnection getConnection() throws IOException;

    public void setRequestProperties(HttpURLConnection connection) throws ProtocolException;

    public void closeConnection(HttpURLConnection connection);

}
