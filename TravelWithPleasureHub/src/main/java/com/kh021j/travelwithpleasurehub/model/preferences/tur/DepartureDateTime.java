package com.kh021j.travelwithpleasurehub.model.preferences.tur;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @windowAfter indicates how many days should be return after departure date.
 * (If it is P3D, 3 days of availability will be returned briefly.
 * If it is P0D, only that day in departureDateTime will be returned with all flights.)
 *
 * @windowBefore indicates how many days should be return before departure date.
 * (If it is P3D, 3 days of availability before DepartureDateTime will be returned briefly.
 * If it is P0D, only that day in departureDateTime will be returned with all flights.)
 *
 */

public class DepartureDateTime {
    @JsonProperty("Date")
    private String date;
    @JsonProperty("WindowAfter")
    private String windowAfter;
    @JsonProperty("WindowBefore")
    private String windowBefore;

    public DepartureDateTime(){}

    public DepartureDateTime(String date, String windowAfter, String windowBefore) {
        this.date = date;
        this.windowAfter = windowAfter;
        this.windowBefore = windowBefore;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWindowAfter() {
        return windowAfter;
    }

    public void setWindowAfter(String windowAfter) {
        this.windowAfter = windowAfter;
    }

    public String getWindowBefore() {
        return windowBefore;
    }

    public void setWindowBefore(String windowBefore) {
        this.windowBefore = windowBefore;
    }

    @Override
    public String toString() {
        return "DepartureDateTime{" +
                "date='" + date + '\'' +
                ", windowAfter='" + windowAfter + '\'' +
                ", windowBefore='" + windowBefore + '\'' +
                '}';
    }
}
