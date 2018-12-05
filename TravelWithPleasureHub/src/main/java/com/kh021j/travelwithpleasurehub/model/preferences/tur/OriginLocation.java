package com.kh021j.travelwithpleasurehub.model.preferences.tur;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @multiAirportCityInd indicates if that city has more than one airport,
 * this should be set as true to get flights departing from all airports in that city.
 */

public class OriginLocation {
    @JsonProperty("LocationCode")
    private String locationCode;
    @JsonProperty("MultiAirportCityInd")
    private boolean multiAirportCityInd;

    public OriginLocation(){}

    public OriginLocation(String locationCode, boolean multiAirportCityInd) {
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
        return "OriginLocation{" +
                "locationCode='" + locationCode + '\'' +
                ", multiAirportCityInd=" + multiAirportCityInd +
                '}';
    }
}
