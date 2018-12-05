package com.kh021j.travelwithpleasurehub.model.preferences.tur;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class OriginDestinationInformation {
    @JsonProperty("DepartureDateTime")
    private DepartureDateTime departureDateTime;
    @JsonProperty("OriginLocation")
    private OriginLocation originLocation;
    @JsonProperty("DestinationLocation")
    private DestinationLocation destinationLocation;
    @JsonProperty("CabinPreferences")
    private List<CabinPreferences> cabinPreferences;

    public OriginDestinationInformation(){}

    public OriginDestinationInformation(DepartureDateTime departureDateTime, OriginLocation originLocation, DestinationLocation destinationLocation, List<CabinPreferences> cabinPreferences) {
        this.departureDateTime = departureDateTime;
        this.originLocation = originLocation;
        this.destinationLocation = destinationLocation;
        this.cabinPreferences = cabinPreferences;
    }

    public DepartureDateTime getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(DepartureDateTime departureDateTime) {
        this.departureDateTime = departureDateTime;
    }

    public OriginLocation getOriginLocation() {
        return originLocation;
    }

    public void setOriginLocation(OriginLocation originLocation) {
        this.originLocation = originLocation;
    }

    public DestinationLocation getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(DestinationLocation destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public List<CabinPreferences> getCabinPreferences() {
        return cabinPreferences;
    }

    public void setCabinPreferences(List<CabinPreferences> cabinPreferences) {
        this.cabinPreferences = cabinPreferences;
    }

    @Override
    public String toString() {
        return "OriginDestinationInformation[" +
                "departureDateTime=" + departureDateTime +
                ", originLocation=" + originLocation +
                ", destinationLocation=" + destinationLocation +
                ", cabinPreferences=" + cabinPreferences +
                ']';
    }
}
