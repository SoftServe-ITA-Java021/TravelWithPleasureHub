package com.kh021j.travelwithpleasurehub.model;

/**
 * Created by ${JDEEK} on ${11.11.2018}.
 */
public class ChatMessage {

    private String username;
    private String message;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {

            this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ChatMessage{" +
                "username='" + username + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
