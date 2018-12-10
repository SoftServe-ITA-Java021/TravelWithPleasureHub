package com.kh021j.travelwithpleasurehub.common;

import java.io.IOException;
import java.net.HttpURLConnection;

public interface Connectable {
    HttpURLConnection setConnection() throws IOException;
}
