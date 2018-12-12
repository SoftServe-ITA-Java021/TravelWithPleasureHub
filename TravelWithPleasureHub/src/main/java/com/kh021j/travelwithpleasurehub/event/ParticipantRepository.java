package com.kh021j.travelwithpleasurehub.event;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ${JDEEK} on ${11.11.2018}.
 */
public class ParticipantRepository {

    private Map<String, LoginEvent> activeSessions = new ConcurrentHashMap<>();

    public void add(String sessionId, LoginEvent user){

        activeSessions.put(sessionId,user);
    }

    public LoginEvent getParticipant(String sessionId){

        return activeSessions.get(sessionId);
    }

    public void removeParticipant(String sessionId){

        activeSessions.remove(sessionId);
    }

    public Map<String, LoginEvent> getActiveSessions() {

        return activeSessions;
    }

    public void setActiveSessions(Map<String, LoginEvent> activeSessions) {
        this.activeSessions = activeSessions;
    }
}
