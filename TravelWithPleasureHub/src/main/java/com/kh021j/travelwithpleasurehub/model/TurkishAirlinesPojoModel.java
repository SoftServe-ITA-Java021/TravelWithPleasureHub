package com.kh021j.travelwithpleasurehub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kh021j.travelwithpleasurehub.model.preferences.tur.PassengerTypeQuantity;
import com.kh021j.travelwithpleasurehub.model.preferences.tur.OriginDestinationInformation;

import java.util.List;
import java.util.Arrays;

/**
 * @routingType gets "O" for one way, "R" for round trip and "M" for multicity.
 */

public class TurkishAirlinesPojoModel {

    @JsonProperty("RoutingType")
    private String routingType;
    @JsonProperty("ReducedDataIndicator")
    private boolean reducedDataIndicator;
    @JsonProperty("PassengerTypeQuantity")
    private List<PassengerTypeQuantity> passengerPreferences;
    @JsonProperty("OriginDestinationInformation")
    private List<OriginDestinationInformation> originDestinationInformation;

    public TurkishAirlinesPojoModel() {
    }

    public TurkishAirlinesPojoModel(String routingType, boolean reducedDataIndicator, List<PassengerTypeQuantity> passengerPreferences, List<OriginDestinationInformation> originDestinationInformation) {
        this.routingType = routingType;
        this.reducedDataIndicator = reducedDataIndicator;
        this.passengerPreferences = passengerPreferences;
        this.originDestinationInformation = originDestinationInformation;
    }

    public String getRoutingType() {
        return routingType;
    }

    public void setRoutingType(String routingType) {
        this.routingType = routingType;
    }

    public boolean isReducedDataIndicator() {
        return reducedDataIndicator;
    }

    public void setReducedDataIndicator(boolean reducedDataIndicator) {
        this.reducedDataIndicator = reducedDataIndicator;
    }

    public List<PassengerTypeQuantity> getPassengerPreferences() {
        return passengerPreferences;
    }

    public void setPassengerPreferences(List<PassengerTypeQuantity> passengerPreferences) {
        this.passengerPreferences = passengerPreferences;
    }

    public List<OriginDestinationInformation> getOriginDestinationInformation() {
        return originDestinationInformation;
    }

    public void setOriginDestinationInformation(List<OriginDestinationInformation> originDestinationInformation) {
        this.originDestinationInformation = originDestinationInformation;
    }

    @Override
    public String toString() {
        return "TurkishAirlinesPojoModel{" +
                "routingType='" + routingType + '\'' +
                ", reducedDataIndicator=" + reducedDataIndicator +
                ", passengerPreferences=" + Arrays.toString(new List[]{passengerPreferences}) +
                ", originDestinationInformation=" + Arrays.toString(new List[]{originDestinationInformation}) +
                '}';
    }
}
