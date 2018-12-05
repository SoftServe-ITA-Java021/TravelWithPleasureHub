package com.kh021j.travelwithpleasurehub.model.preferences.tur;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kh021j.travelwithpleasurehub.model.preferences.enums.PassengerType;

public class PassengerTypeQuantity {

    @JsonProperty("Quantity")
    private int quantity;
    @JsonProperty("Code")
    private Enum<PassengerType> passengerType;

    public PassengerTypeQuantity(){}

    public PassengerTypeQuantity(int quantity, Enum<PassengerType> passengerType) {
        this.quantity = quantity;
        this.passengerType = passengerType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Enum<PassengerType> getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(Enum<PassengerType> passengerType) {
        this.passengerType = passengerType;
    }

    @Override
    public String toString() {
        return "PassengerTypeQuantity[" +
                "Quantity='" + quantity + '\'' +
                ", Code='" + passengerType + '\'' +
                ']';
    }
}
