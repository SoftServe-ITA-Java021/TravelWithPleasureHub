package com.kh021j.travelwithpleasurehub.event;

import java.util.Date;

/**
 * Created by ${JDEEK} on ${11.11.2018}.
 */
public class LoginEvent {

    private String username;
    private Date date;

    public LoginEvent(String username) {
        this.username = username;
        this.date = new Date();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
