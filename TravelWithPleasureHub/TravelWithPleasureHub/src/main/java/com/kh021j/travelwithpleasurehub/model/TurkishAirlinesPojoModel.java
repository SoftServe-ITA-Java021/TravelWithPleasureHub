package com.kh021j.travelwithpleasurehub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.kh021j.travelwithpleasurehub.common.IJSONFile;
import com.kh021j.travelwithpleasurehub.model.preferences.tur.OriginDestinationInformation;
import com.kh021j.travelwithpleasurehub.model.preferences.tur.PassengerTypeQuantity;

import java.util.Arrays;
import java.util.List;

/**
 * @routingType gets "O" for one way, "R" for round trip and "M" for multicity.
 */

public class TurkishAirlinesPojoModel implements IJSONFile {

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

    @Override
    public void deserialize() throws JsonProcessingException {
        // TODO: 12/5/2018 . . .
    }
}
