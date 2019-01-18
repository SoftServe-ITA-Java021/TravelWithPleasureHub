
package com.kh021j.travelwithpleasurehub.tickets.apiparser.service;

import com.kh021j.travelwithpleasurehub.tickets.apiparser.model.RequestModel;
import com.kh021j.travelwithpleasurehub.tickets.apiparser.model.response.v2.Flight;
import com.kh021j.travelwithpleasurehub.tickets.apiparser.model.response.v2.FlightData;
import com.kh021j.travelwithpleasurehub.tickets.apiparser.model.response.v2.Ticket;
import com.kh021j.travelwithpleasurehub.tickets.apiparser.service.OneWayOptionRequestService;
import com.kh021j.travelwithpleasurehub.tickets.parser.Belavia.model.enums.Currency;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class TopRoutes {

    private static Date currentDate = new Date();

    public static List<FlightData> getMonthTopRoutes() throws UnirestException, JSONException {
        LocalDate localDate = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        List<RequestModel> list = getTopRoutes();
        List<FlightData> flightDataList = new ArrayList<>();

        for (RequestModel entity : list) {
            for (int i = 1; i < 31; i++) {
                entity.setOutboundDate(localDate.plusDays(i).toString());
                flightDataList.addAll(getFlightsData(entity));
            }
        }

        return flightDataList;
    }

    public static List<FlightData> getFlightsData(RequestModel entity) throws JSONException, UnirestException {
        OneWayOptionRequestService oneWayOptionRequestService = new OneWayOptionRequestService();
        List<FlightData> flightDataList = new ArrayList<>();
        JsonNode obj = oneWayOptionRequestService.sendResponseToController(entity);
        while (obj.getObject().getJSONArray("Carriers").length() < 1) {
            obj = oneWayOptionRequestService.sendResponseToController(entity);
        }
        JSONArray carrier = obj.getObject().getJSONArray("Carriers");
        for (int j = 0; j < carrier.length(); j++) {
            FlightData flightData = FlightData.builder()
                    .companyId(carrier.getJSONObject(j).getInt("Id"))
                    .departureAirport(entity.getOriginPlace())
                    .arrivalAirport(entity.getDestinationPlace())
                    .queryDate(LocalDate.parse(entity.getOutboundDate()))
                    .cabinType(entity.getCabinType())
                    .currency(Currency.valueOf(obj.getObject().getJSONObject("Query").getString("Currency").toUpperCase()))
                    .company(carrier.getJSONObject(j).getString("Name"))
                    .companyCode(carrier.getJSONObject(j).getString("DisplayCode"))
                    .imageCompany(carrier.getJSONObject(j).getString("ImageUrl"))
                    .flights(getFlightsForResponse(obj, carrier.getJSONObject(j).getString("Id")))
                    .build();
            if (!flightData.getFlights().isEmpty()) {
                flightDataList.add(flightData);
            }
        }
        return flightDataList;
    }

    private static List<Flight> getFlightsForResponse(JsonNode obj, String carrierId) throws JSONException {
        JSONArray legs = obj.getObject().getJSONArray("Legs");
        List<Flight> flights = new ArrayList<>();
        for (int i = 0; i < legs.length(); i++) {
            JSONArray carrierIds = legs.getJSONObject(i).getJSONArray("Carriers");
            for (int j = 0; j < carrierIds.length(); j++) {
                if (carrierIds.get(j).toString().equals(carrierId)) {
                    Flight flight = Flight.builder()
                            .arrivalTime(ZonedDateTime.of(LocalDateTime.parse(legs.getJSONObject(i).getString("Arrival")), ZoneId.systemDefault()))
                            .departureTime(ZonedDateTime.of(LocalDateTime.parse(legs.getJSONObject(i).getString("Departure")), ZoneId.systemDefault()))
                            .duration(legs.getJSONObject(i).getInt("Duration"))
                            .tickets(getTicketsForFlight(obj, legs.getJSONObject(i).getString("Id")))
                            .build();
                    if (!flight.getTickets().isEmpty()) {
                        flights.add(flight);
                    }
                }
            }
        }
        return flights;
    }

    private static List<Ticket> getTicketsForFlight(JsonNode obj, String legId) throws JSONException {
        JSONArray itineraries = obj.getObject().getJSONArray("Itineraries");
        List<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i < itineraries.length(); i++) {
            if (legId.equals(itineraries.getJSONObject(i).getString("OutboundLegId"))) {
                JSONArray pricingOptions = itineraries.getJSONObject(i).getJSONArray("PricingOptions");
                for (int j = 0; j < pricingOptions.length(); j++) {
                    Ticket ticket = Ticket.builder()
                            .linkForBuying(pricingOptions.getJSONObject(j).getString("DeeplinkUrl"))
                            .price(pricingOptions.getJSONObject(j).getDouble("Price"))
                            .build();
                    tickets.add(ticket);
                }
            }
        }
        return tickets;
    }

    private static List<RequestModel> getTopRoutes() {
        List<RequestModel> list = new ArrayList<>();
        LocalDate localDate = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        list.add(new RequestModel("US", "USD", "en-US",
                "ICN", "CJU", localDate.toString(),
                1, "economy", 0, 0));
        list.add(new RequestModel("US", "USD", "en-US",
                "MEL", "SYD", localDate.toString(),
                1, "economy", 0, 0));
        list.add(new RequestModel("US", "USD", "en-US",
                "BOM", "DEL", localDate.toString(),
                1, "economy", 0, 0));
        list.add(new RequestModel("US", "USD", "en-US",
                "DUB", "LCY", localDate.toString(),
                1, "economy", 0, 0));
        list.add(new RequestModel("US", "USD", "en-US",
                "GIG", "GRU", localDate.toString(),
                1, "economy", 0, 0));
        list.add(new RequestModel("US", "USD", "en-US",
                "LAX", "SFO", localDate.toString(),
                1, "economy", 0, 0));
        list.add(new RequestModel("US", "USD", "en-US",
                "SIN", "KUL", localDate.toString(),
                1, "economy", 0, 0));
        list.add(new RequestModel("US", "USD", "en-US",
                "LGA", "YYZ", localDate.toString(),
                1, "economy", 0, 0));
        list.add(new RequestModel("US", "USD", "en-US",
                "AMS", "LHR", localDate.toString(),
                1, "economy", 0, 0));
        list.add(new RequestModel("US", "USD", "en-US",
                "DXB", "KWI", localDate.toString(),
                1, "economy", 0, 0));
        list.add(new RequestModel("US", "USD", "en-US",
                "ORD", "YYZ", localDate.toString(),
                1, "economy", 0, 0));
        list.add(new RequestModel("US", "USD", "en-US",
                "JFK", "LHR", localDate.toString(),
                1, "economy", 0, 0));
        list.add(new RequestModel("US", "USD", "en-US",
                "HKG", "PEK", localDate.toString(),
                1, "economy", 0, 0));
        list.add(new RequestModel("US", "USD", "en-US",
                "BKK", "HKG", localDate.toString(),
                1, "economy", 0, 0));
        list.add(new RequestModel("US", "USD", "en-US",
                "CGK", "SIN", localDate.toString(),
                1, "economy", 0, 0));
        return list;
    }
}
