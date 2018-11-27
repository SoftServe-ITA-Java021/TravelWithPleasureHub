package com.kh021j.travelwithpleasurehub.service.dto;

import com.kh021j.travelwithpleasurehub.model.enumiration.MeetingType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
public class MeetingDTO {

    private long id;
    private String header;
    private MeetingType meetingType;
    private String content;
    private String location;
    private String link;
    private LocalDateTime timeOfAction;
}
