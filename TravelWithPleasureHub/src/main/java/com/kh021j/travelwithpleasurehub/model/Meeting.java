package com.kh021j.travelwithpleasurehub.model;

import com.kh021j.travelwithpleasurehub.model.enumiration.MeetingType;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder(toBuilder = true)
@Data
@NoArgsConstructor
@Entity
@Table(name = "meeting")
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "header", nullable = false)
    private String header;

    @Column(name = "meeting_type", nullable = false)
    private MeetingType meetingType;

    @Column(name = "content")
    private String content;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "link")
    private String link;

    @Column(columnDefinition = "date", nullable = false)
    private LocalDateTime timeOfAction;
}


