package com.kh021j.travelwithpleasurehub.common;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface JSONConvertible {
    String toJSON() throws JsonProcessingException;
}
