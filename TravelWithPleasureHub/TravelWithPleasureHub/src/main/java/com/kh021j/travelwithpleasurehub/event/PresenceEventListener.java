package com.kh021j.travelwithpleasurehub.event;

import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.util.Optional;

/**
 * Created by ${JDEEK} on ${11.11.2018}.
 *
 * * Listener to track user presence.
 * Sends notifications to the login destination when a connected event is received
 * and notifications to the logout destination when a disconnect event is received
 *
 */
public class PresenceEventListener {

    private ParticipantRepository participantRepository;
    private SimpMessagingTemplate messagingTemplate;
    private String loginDestination;
    private String logoutDestination;

    public PresenceEventListener() {
    }

    public PresenceEventListener(SimpMessagingTemplate messagingTemplate,ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
        this.messagingTemplate = messagingTemplate;
    }

    @EventListener
    private void handleSessionConnected(SessionConnectEvent event){
        SimpMessageHeaderAccessor headers = SimpMessageHeaderAccessor.wrap(event.getMessage());
        String username = headers.getUser().getName();

        LoginEvent loginEvent = new LoginEvent(username);
        messagingTemplate.convertAndSend(loginDestination,loginEvent);
        participantRepository.add(headers.getSessionId(),loginEvent);
    }

    @EventListener
    private void handleSessionDisconnect(SessionDisconnectEvent event){
        Optional.ofNullable(participantRepository.getPaticipant(event.getSessionId()))
                .ifPresent(login ->{
                    messagingTemplate.convertAndSend(logoutDestination,new LogoutEvent(login.getUsername()));
                    participantRepository.removeParticipant(event.getSessionId());
                });
    }

    public void setLoginDestination(String loginDestination) {
        this.loginDestination = loginDestination;
    }

    public void setLogoutDestination(String logoutDestination) {
        this.logoutDestination = logoutDestination;
    }
}
