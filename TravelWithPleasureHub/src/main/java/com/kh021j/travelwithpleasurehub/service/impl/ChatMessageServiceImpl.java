/*
package com.kh021j.travelwithpleasurehub.service.impl;

import com.kh021j.travelwithpleasurehub.model.ChatMessage;
import com.kh021j.travelwithpleasurehub.repository.ChatMessageRepository;
import com.kh021j.travelwithpleasurehub.service.ChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

*/
/**
 * Created by ${JDEEK} on ${11.11.2018}.
 *//*

@Service
public class ChatMessageServiceImpl implements ChatMessageService{

    @Autowired
    private ChatMessageRepository chatMessageRepository;

    @Override
    public void appendInstantMessageToConversations(ChatMessage instantMessage) {
        instantMessage.setUsername(instantMessage.getSender());
        chatMessageRepository.save(instantMessage);

    }

    @Override
    public List<ChatMessage> findAllInstantMessagesFor(String username, String chatRoomId) {
        return chatMessageRepository.findInstantMessagesByUsernameAndChatRoomId(username,chatRoomId);
    }
}
*/
