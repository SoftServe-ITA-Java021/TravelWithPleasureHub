
package com.kh021j.travelwithpleasurehub.parser.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PassengerQuantities {

    @JsonProperty
    private String code;
    @JsonProperty
    private int quantity;

    public PassengerQuantities() {
    }

    public PassengerQuantities(String code, int quantity) {
        this.code = code;
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "PassengerQuantities{" +
                "code='" + code + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
