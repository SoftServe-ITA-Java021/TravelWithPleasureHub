package com.kh021j.travelwithpleasurehub.model.preferences.tur;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kh021j.travelwithpleasurehub.model.preferences.enums.CabinType;

public class CabinPreferences {
    @JsonProperty("Cabin")
    private Enum<CabinType> cabin;

    public CabinPreferences() {
    }

    public CabinPreferences(Enum<CabinType> cabin) {
        this.cabin = cabin;
    }

    public Enum<CabinType> getCabin() {
        return cabin;
    }

    public void setCabin(Enum<CabinType> cabin) {
        this.cabin = cabin;
    }

    @Override
    public String toString() {
        return "CabinPreferences[" +
                "cabin='" + cabin + '\'' +
                ']';
    }
}
