package com.kh021j.travelwithpleasurehub.parser.Belavia.model;

import com.kh021j.travelwithpleasurehub.parser.Belavia.model.enums.Currency;

public class FlightInfo {
   private String price;
   private Currency currency;

    public FlightInfo() {
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public FlightInfo(String price, Currency currency) {
        this.price = price;
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "FlightInfo{" +
                "price='" + price + '\'' +
                ", currency=" + currency +
                '}';
    }
}
