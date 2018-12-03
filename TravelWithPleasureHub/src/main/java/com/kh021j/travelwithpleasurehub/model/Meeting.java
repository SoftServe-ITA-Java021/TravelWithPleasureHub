package com.kh021j.travelwithpleasurehub.model;

import com.kh021j.travelwithpleasurehub.model.enumiration.MeetingType;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Builder(toBuilder = true)
@Data
@NoArgsConstructor
@Entity
@Table(name = "meeting")
public class Meeting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @OneToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @ManyToMany
    @JoinTable(name = "confirmed_users",
            joinColumns = @JoinColumn(name = "meeting_id_meeting"),
            inverseJoinColumns = @JoinColumn(name = "user_id_users"))
    private List<User> confirmedUsers;

    @ManyToMany
    @JoinTable(name = "wishing_users",
            joinColumns = @JoinColumn(name = "meeting_id_meeting"),
            inverseJoinColumns = @JoinColumn(name = "user_id_users"))
    private List<User> wishingUsers;
}


