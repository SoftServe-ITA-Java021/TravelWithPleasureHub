package com.kh021j.travelwithpleasurehub.service.dto;

import com.kh021j.travelwithpleasurehub.model.enumiration.MeetingType;
import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder(toBuilder = true)
public class MeetingDTO {

    private Long id;

    private String header;

    private MeetingType meetingType;

    private String content;

    private String location;

    private String link;

    private LocalDateTime timeOfAction;

    private Long ownerId;

    private List<Long> confirmedUserIds;

    private List<Long> wishingUserIds;

}