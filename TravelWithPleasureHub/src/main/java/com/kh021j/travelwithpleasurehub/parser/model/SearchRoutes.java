package com.kh021j.travelwithpleasurehub.parser.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchRoutes {

    @JsonProperty
    private String origin;
    @JsonProperty
    private String destination;
    @JsonProperty
    private String departing;
    @JsonProperty
    private int direction;

    public SearchRoutes() {
    }

    public SearchRoutes(String origin, String destination, String departing, int direction) {
        this.origin = origin;
        this.destination = destination;
        this.departing = departing;
        this.direction = direction;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDeparting() {
        return departing;
    }

    public void setDeparting(String departing) {
        this.departing = departing;
    }

    public int getDirection() {
        return direction;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "SearchRoutes {" +
                "origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", departing='" + departing + '\'' +
                ", direction=" + direction +
                "}";
    }
}
