package com.kh021j.travelwithpleasurehub.controller;

import com.kh021j.travelwithpleasurehub.model.ChatMessage;
import com.kh021j.travelwithpleasurehub.model.ChatMessage.MessageType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

import static java.lang.String.format;

/*import com.kh021j.travelwithpleasurehub.service.ChatMessageService;*/

@Controller
public class ChatController {

    private static final Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

/*    @Autowired
    private ChatMessageService chatMessageService;*/

    @MessageMapping("/chat/{roomId}/sendMessage")
    public void sendMessage(@DestinationVariable String roomId, @Payload ChatMessage chatMessage) {
        messagingTemplate.convertAndSend(format("/channel/%s", roomId), chatMessage);
       /* String chatRoomId = headerAccessor.getSessionAttributes().get("chatRoomId").toString();
        chatMessage.setSender(principal.getName());
        chatMessage.setChatRoomId(chatRoomId);
        chatMessageService.appendInstantMessageToConversations(chatMessage);*/
    }

    @MessageMapping("/chat/{roomId}/addUser")
    public void addUser(@DestinationVariable String roomId, @Payload ChatMessage chatMessage,
                        SimpMessageHeaderAccessor headerAccessor) {
        String currentRoomId = (String) headerAccessor.getSessionAttributes().put("room_id", roomId);
        if (currentRoomId != null) {
            ChatMessage leaveMessage = new ChatMessage();
            leaveMessage.setType(MessageType.LEAVE);
            leaveMessage.setSender(chatMessage.getSender());
            messagingTemplate.convertAndSend(format("/channel/%s", currentRoomId), leaveMessage);
        }
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        messagingTemplate.convertAndSend(format("/channel/%s", roomId), chatMessage);
    }

   /* @SubscribeMapping("/old.messages")
    public List<ChatMessage> listOldMessagesFromUserOnSubscribe(Principal principal,
                                                                SimpMessageHeaderAccessor headerAccessor){
        String chatRoomId = headerAccessor.getSessionAttributes().get("chatRoomId").toString();
        return chatMessageService.findAllInstantMessagesFor(principal.getName(),chatRoomId);
    }*/
}