package com.kh021j.travelwithpleasurehub.parser.Belavia.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kh021j.travelwithpleasurehub.parser.Belavia.model.BelaviaJson;

import java.io.IOException;

public class JsonConverter {

    public String objectToJson(Object obj) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(obj);
    }

    public Object jsonToObject(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, BelaviaJson.class);
    }
}
