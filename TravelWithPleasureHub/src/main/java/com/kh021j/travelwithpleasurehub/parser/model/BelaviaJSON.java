package com.kh021j.travelwithpleasurehub.parser.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BelaviaJSON {

    @JsonProperty
    private String currency;
    @JsonProperty
    private SearchRoutes searchRoutes;
    @JsonProperty
    private PassengerQuantities passengerQuantities;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public SearchRoutes getSearchRoutes() {
        return searchRoutes;
    }

    public void setSearchRoutes(SearchRoutes searchRoutes) {
        this.searchRoutes = searchRoutes;
    }

    public PassengerQuantities getPassengerQuantities() {
        return passengerQuantities;
    }

    public void setPassengerQuantities(PassengerQuantities passengerQuantities) {
        this.passengerQuantities = passengerQuantities;
    }

    @Override
    public String toString() {
        return "BelaviaJSON{" +
                "currency='" + currency + '\'' +
                ", searchRoutes=" + searchRoutes +
                ", passengerQuantities=" + passengerQuantities +
                '}';
    }
}
