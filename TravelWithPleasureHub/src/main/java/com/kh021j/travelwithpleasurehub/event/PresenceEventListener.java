package com.kh021j.travelwithpleasurehub.event;

import com.kh021j.travelwithpleasurehub.model.User;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import java.util.Optional;

/**
 * Created by ${JDEEK} on ${11.11.2018}.
 */
public class PresenceEventListener {

    private ParticipantRepository participantRepository;
    private SimpMessagingTemplate messagingTemplate;
    private String loginDestination;
    private String logoutDestination;

    public PresenceEventListener( SimpMessagingTemplate messagingTemplate,ParticipantRepository participantRepository) {
        this.messagingTemplate = messagingTemplate;
        this.participantRepository = participantRepository;
    }

    @EventListener
    private void handleSessionConnected(SessionConnectEvent connectEvent){
        SimpMessageHeaderAccessor headers =
                SimpMessageHeaderAccessor.wrap(connectEvent.getMessage());
        String username = headers.getUser().getName();

        LoginEvent loginEvent = new LoginEvent(username);
        messagingTemplate.convertAndSend(loginDestination,loginEvent);
        participantRepository.add(headers.getSessionId(),loginEvent);
    }

    @EventListener
    private void handleSessionDisconnect(SessionDisconnectEvent disconnectEvent){
        Optional.ofNullable(participantRepository.getParticipant(disconnectEvent.getSessionId()))
                .ifPresent(login->{
                    messagingTemplate.convertAndSend(logoutDestination,new User(login.getUsername()));
                });
    }

    public void setLoginDestination(String loginDestination) {
        this.loginDestination = loginDestination;
    }

    public void setLogoutDestination(String logoutDestination) {
        this.logoutDestination = logoutDestination;
    }
}
