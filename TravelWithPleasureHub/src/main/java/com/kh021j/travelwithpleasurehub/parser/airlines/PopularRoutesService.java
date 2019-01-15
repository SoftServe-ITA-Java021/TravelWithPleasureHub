package com.kh021j.travelwithpleasurehub.parser.airlines;

import com.kh021j.travelwithpleasurehub.parser.belavia.BelaviaConnection;
import com.kh021j.travelwithpleasurehub.parser.belavia.model.BelaviaJson;
import com.kh021j.travelwithpleasurehub.parser.belavia.model.PassengerQuantities;
import com.kh021j.travelwithpleasurehub.parser.belavia.model.SearchRoutes;
import com.kh021j.travelwithpleasurehub.parser.belavia.model.enums.Currency;
import com.kh021j.travelwithpleasurehub.parser.belavia.model.enums.PassengerCode;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class PopularRoutesService {

    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");

    public List<BelaviaJson> getPopularRoutes() throws IOException, UnirestException {
        Date currentDate = new Date();
        LocalDate localDate = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();


        List<RequestModel> list = new ArrayList<>();
               list.add(new RequestModel("US", "USD", "en-US",
                        "KBP", "MSQ", "2019-01-24",
                        "2019-01-24", 1, "economy", 0, 0));
        HttpURLConnection connection = new BelaviaConnection().createConnection();
        for(RequestModel entity: list){
            for (int i = 0; i < 30; i++) {
                entity.setOutboundDate(localDate.plusDays(i).toString());
                System.out.println(entity);
            }
        }
        connection.disconnect();


        return new ArrayList<>();
    }
}
