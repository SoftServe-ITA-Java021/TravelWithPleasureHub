package com.kh021j.travelwithpleasurehub.event;

import lombok.Data;

import java.util.Date;

/**
 * Created by ${JDEEK} on ${11.11.2018}.
 */
@Data
public class LoginEvent {

    private String username;
    private Date time;

    public LoginEvent(String username) {
        this.username = username;
        time = new Date();
    }
}
