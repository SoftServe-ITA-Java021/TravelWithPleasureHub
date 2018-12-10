package com.kh021j.travelwithpleasurehub.cfg;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kh021j.travelwithpleasurehub.common.JSONConvertible;
import com.kh021j.travelwithpleasurehub.model.TurkishAirlinesPojoModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.kh021j.travelwithpleasurehub.model.preferences.enums.CabinType;
import com.kh021j.travelwithpleasurehub.model.preferences.enums.PassengerType;
import com.kh021j.travelwithpleasurehub.model.preferences.tur.*;

import java.util.ArrayList;
import java.util.List;

public class TurkishAirlinesJSONConverter implements JSONConvertible {

    private int adultQuantity;
    private int childQuantity;
    private int infantQuantity;

    private boolean originMultiAirportCityInd;
    private boolean destinationAirportCityInd;

    private String originDate;
    private String departureDate;
    private String windowAfter;
    private String windowBefore;
    private String originLocationCode;
    private String destinationLocationCode;

    private CabinType cabinType;

    public int getAdultQuantity() {
        return adultQuantity;
    }

    public void setAdultQuantity(int adultQuantity) {
        this.adultQuantity = adultQuantity;
    }

    public int getChildQuantity() {
        return childQuantity;
    }

    public void setChildQuantity(int childQuantity) {
        this.childQuantity = childQuantity;
    }

    public int getInfantQuantity() {
        return infantQuantity;
    }

    public void setInfantQuantity(int infantQuantity) {
        this.infantQuantity = infantQuantity;
    }

    public boolean isOriginMultiAirportCityInd() {
        return originMultiAirportCityInd;
    }

    public void setOriginMultiAirportCityInd(boolean originMultiAirportCityInd) {
        this.originMultiAirportCityInd = originMultiAirportCityInd;
    }

    public boolean isDestinationAirportCityInd() {
        return destinationAirportCityInd;
    }

    public void setDestinationAirportCityInd(boolean destinationAirportCityInd) {
        this.destinationAirportCityInd = destinationAirportCityInd;
    }

    public String getOriginDate() {
        return originDate;
    }

    public void setOriginDate(String originDate) {
        this.originDate = originDate;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
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

    public String getOriginLocationCode() {
        return originLocationCode;
    }

    public void setOriginLocationCode(String originLocationCode) {
        this.originLocationCode = originLocationCode;
    }

    public String getDestinationLocationCode() {
        return destinationLocationCode;
    }

    public void setDestinationLocationCode(String destinationLocationCode) {
        this.destinationLocationCode = destinationLocationCode;
    }

    public CabinType getCabinType() {
        return cabinType;
    }

    public void setCabinType(CabinType cabinType) {
        this.cabinType = cabinType;
    }

    @Override
    public String toJSON() throws JsonProcessingException {

        PassengerTypeQuantity adults = new PassengerTypeQuantity(adultQuantity, PassengerType.ADULT);
        PassengerTypeQuantity children = new PassengerTypeQuantity(childQuantity, PassengerType.CHILD);
        PassengerTypeQuantity infants = new PassengerTypeQuantity(infantQuantity, PassengerType.INFANT);

        List<PassengerTypeQuantity> passengerList = new ArrayList<>();
        passengerList.add(adults);
        passengerList.add(children);
        passengerList.add(infants);

        DepartureDateTime departureDateTime = new DepartureDateTime(originDate, "P0D", "P0D");
        OriginLocation originLocation = new OriginLocation(originLocationCode, originMultiAirportCityInd);
        DestinationLocation destinationLocation = new DestinationLocation(destinationLocationCode, destinationAirportCityInd);

        CabinPreferences cabinPreferences = new CabinPreferences(CabinType.ECONOMY);
        CabinPreferences cabinPreferences1 = new CabinPreferences(CabinType.BUSINESS);
        List<CabinPreferences> cabinPreferencesList = new ArrayList<>();
        cabinPreferencesList.add(cabinPreferences);
        cabinPreferencesList.add(cabinPreferences1);

        OriginDestinationInformation originDestinationInformation = new OriginDestinationInformation(departureDateTime,
                originLocation, destinationLocation, cabinPreferencesList);

        boolean onCheck = false;
        List<OriginDestinationInformation> originDestinationInformationList = null;
        if (!onCheck) {
            DepartureDateTime departureDateTime1 = new DepartureDateTime(departureDate, "P0D", "P0D");
            OriginLocation originLocation1 = new OriginLocation(destinationLocationCode, destinationAirportCityInd);
            DestinationLocation destinationLocation1 = new DestinationLocation(originLocationCode, originMultiAirportCityInd);
            OriginDestinationInformation originDestinationInformation1 =
                    new OriginDestinationInformation(departureDateTime1, originLocation1, destinationLocation1,
                            cabinPreferencesList);
            originDestinationInformationList = new ArrayList<>();
            originDestinationInformationList.add(originDestinationInformation);
            originDestinationInformationList.add(originDestinationInformation1);
        }

        ObjectMapper mapper = new ObjectMapper();
        TurkishAirlinesPojoModel queryModel = new TurkishAirlinesPojoModel("r", false,
                passengerList, originDestinationInformationList);

        return mapper.writeValueAsString(queryModel);
    }
}
