package com.kh021j.travelwithpleasurehub.controller;

import com.kh021j.travelwithpleasurehub.model.ChatMessage;
import com.kh021j.travelwithpleasurehub.model.enumiration.MessageType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by ${JDEEK} on ${11.11.2018}.
 */
@Controller
@CrossOrigin(origins="http://localhost:3000")
public class ChatController {

    private static Logger logger = LoggerFactory.getLogger(ChatController.class);

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    @MessageMapping("/chat/{roomId}/sendMesage")
    public void sendMessage(@DestinationVariable String roomId, @Payload ChatMessage message){
        messagingTemplate.convertAndSend(String.format("/chat/%s",roomId),message);
    }

    @MessageMapping("/chat/{roomId}/sendMessage")
    public void addUser(@DestinationVariable String roomId, @Payload ChatMessage message,
                        SimpMessageHeaderAccessor accessor){
        String currentRoomId = (String) accessor.getSessionAttributes().put("room_id",roomId);
        if (currentRoomId!=null){
            ChatMessage leaveMessage = new ChatMessage();
            leaveMessage.setMessageType(MessageType.LEAVE);
            leaveMessage.setSender(message.getSender());
            messagingTemplate.convertAndSend(String.format("/channel/%s",currentRoomId),leaveMessage);
        }
        accessor.getSessionAttributes().put("username",message.getSender());
        messagingTemplate.convertAndSend(String.format("/channel/%s",roomId),message);
    }

    @RequestMapping(value = "/chatroom", method = RequestMethod.POST)
    @CrossOrigin(origins="http://localhost:3000")
    public void login(HttpServletResponse response) {
        response.setHeader("Location", "http://localhost:8080");
    }
}
