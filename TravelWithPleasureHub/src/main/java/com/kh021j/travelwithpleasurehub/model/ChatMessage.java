package com.kh021j.travelwithpleasurehub.model;

/**
 * Created by ${JDEEK} on ${11.11.2018}.
 */
/*@Table("chatroom")*/
public class ChatMessage {

   /* public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getChatRoomId() {
        return chatRoomId;
    }

    public void setChatRoomId(String chatRoomId) {
        this.chatRoomId = chatRoomId;
    }
*/
    public enum MessageType {
        CHAT, JOIN, LEAVE
    }

 /*   @JsonIgnore
    @PrimaryKeyColumn(name = "username", ordinal = 0,type = PrimaryKeyType.PARTITIONED)
    private String username;
    @PrimaryKeyColumn(name = "chatRoomId",ordinal = 1,type = PrimaryKeyType.PARTITIONED)
    private String chatRoomId;*/
    private MessageType messageType;
    private String content;
    private String sender;

    public ChatMessage() {
    }

    public MessageType getType() {
        return messageType;
    }

    public void setType(MessageType messageType) {
        this.messageType = messageType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
