package com.kh021j.travelwithpleasurehub.event;

/**
 * Created by ${JDEEK} on ${11.11.2018}.
 */
public class LogoutEvent {

    private String username;

    public LogoutEvent(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
