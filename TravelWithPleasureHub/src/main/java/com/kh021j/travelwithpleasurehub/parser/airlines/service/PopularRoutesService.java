
package com.kh021j.travelwithpleasurehub.parser.airlines.service;

import com.kh021j.travelwithpleasurehub.parser.airlines.model.RequestModel;
import com.kh021j.travelwithpleasurehub.parser.belavia.model.BelaviaJson;
import org.springframework.stereotype.Service;

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

    public List<BelaviaJson> getPopularRoutes() {
        Date currentDate = new Date();
        LocalDate localDate = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        RequestModel requestModel = RequestModel.builder().
                country("US").build();
        List<RequestModel> list = new ArrayList<>();
               list.add(new RequestModel("US", "USD", "en-US",
                        "KBP", "MSQ", dateFormat.format(currentDate),
                       1, "economy", 0, 0));
        for(RequestModel entity: list){
            for (int i = 0; i < 30; i++) {
                entity.setOutboundDate(localDate.plusDays(i).toString());
                System.out.println(entity);
            }
        }
        return new ArrayList<>();
    }
}
