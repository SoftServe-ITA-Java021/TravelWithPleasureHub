package com.kh021j.travelwithpleasurehub.tickets.apiparser.service.data;

import com.kh021j.travelwithpleasurehub.tickets.apiparser.model.RequestModel;
import com.kh021j.travelwithpleasurehub.tickets.apiparser.model.response.v2.FlightData;
import com.kh021j.travelwithpleasurehub.tickets.apiparser.repository.FlightDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightDataService {

    @Autowired
    private FlightDataRepository flightDataRepository;

    @Transactional
    public List<FlightData> getFlightData(RequestModel requestModel) {
        List<FlightData> flightData = new ArrayList<>();
        if (requestModel.getOriginPlace() != null &&
                requestModel.getDestinationPlace() != null &&
                requestModel.getOutboundDate() != null && requestModel.getAdults() == 1 &&
                requestModel.getChildren() == 0 && requestModel.getInfants() == 0) {
            flightData = flightDataRepository.findAllByDepartureAirportAndArrivalAirportAndQueryDate
                    (requestModel.getOriginPlace(), requestModel.getDestinationPlace(),
                            requestModel.getOutboundDate());
        }
        return flightData;
    }

    @Transactional
    public void saveFlightData(List<FlightData> flightData){
        if(!flightData.isEmpty()){
            for (FlightData entity: flightData) {
                System.out.println(entity);
                flightDataRepository.saveAndFlush(entity);
            }
        }
    }
}
