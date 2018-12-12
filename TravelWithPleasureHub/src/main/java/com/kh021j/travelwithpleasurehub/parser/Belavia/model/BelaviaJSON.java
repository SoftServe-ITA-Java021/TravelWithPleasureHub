
package com.kh021j.travelwithpleasurehub.parser.Belavia.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

import java.util.List;

public class BelaviaJSON {


    @JsonProperty
    private String currency;
    @JsonProperty
    private List<SearchRoutes> searchRoutes;
    @JsonProperty
    private List<PassengerQuantities> passengerQuantities;

    public BelaviaJSON() {
    }

    public BelaviaJSON(String currency, List<SearchRoutes> searchRoutes,
                       List<PassengerQuantities> passengerQuantities) {
        this.currency = currency;
        this.searchRoutes = searchRoutes;
        this.passengerQuantities = passengerQuantities;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<SearchRoutes> getSearchRoutes() {
        return searchRoutes;
    }

    public void setSearchRoutes(List<SearchRoutes> searchRoutes) {
        this.searchRoutes = searchRoutes;
    }

    public List<PassengerQuantities> getPassengerQuantities() {
        return passengerQuantities;
    }

    public void setPassengerQuantities(List<PassengerQuantities> passengerQuantities) {
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
