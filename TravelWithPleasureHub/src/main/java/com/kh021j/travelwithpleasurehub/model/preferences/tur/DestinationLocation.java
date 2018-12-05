package com.kh021j.travelwithpleasurehub.model.preferences.tur;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DestinationLocation {
    @JsonProperty("LocationCode")
    private String locationCode;
    @JsonProperty("MultiAirportCityInd")
    private boolean multiAirportCityInd;

    public DestinationLocation(){}

    public DestinationLocation(String locationCode, boolean multiAirportCityInd) {
        this.locationCode = locationCode;
        this.multiAirportCityInd = multiAirportCityInd;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public boolean isMultiAirportCityInd() {
        return multiAirportCityInd;
    }

    public void setMultiAirportCityInd(boolean multiAirportCityInd) {
        this.multiAirportCityInd = multiAirportCityInd;
    }

    @Override
    public String toString() {
        return "DestinationLocation{" +
                "locationCode='" + locationCode + '\'' +
                ", multiAirportCityInd=" + multiAirportCityInd +
                '}';
    }
}
