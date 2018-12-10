package com.kh021j.travelwithpleasurehub.service.dto;

import com.kh021j.travelwithpleasurehub.model.enumiration.MeetingType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder(toBuilder = true)
public class MeetingDTO {

    private Integer id;
    private String header;
    private MeetingType meetingType;
    private String content;
    private String location;
    private List<String> links;
    private LocalDateTime timeOfAction;
    private Integer ownerId;
    private List<Long> confirmedUserIds;
    private List<Long> wishingUserIds;
}
