package com.kh021j.travelwithpleasurehub;

import com.kh021j.travelwithpleasurehub.config.ChatConfig;
import com.kh021j.travelwithpleasurehub.controller.ChatController;
import com.kh021j.travelwithpleasurehub.event.LoginEvent;
import com.kh021j.travelwithpleasurehub.event.ParticipantRepository;
import com.kh021j.travelwithpleasurehub.model.User;
import org.junit.Test;

import java.security.Principal;

/**
 * Created by ${JDEEK} on ${11.11.2018}.
 */
public class ChatModuleTest {


    @Test
    public void redisConnection(){
        ChatConfig chatConfig = new ChatConfig();

        chatConfig.jedisConnectionFactory();
        chatConfig.getRedisTemplate();
    }
    @Test
    public void testParticipantRepositoryMethods(){
        ParticipantRepository participantRepository = new ParticipantRepository();

        participantRepository.add("1",new LoginEvent("JDeek"));
        participantRepository.add("2",new LoginEvent("Bugger"));
        participantRepository.add("3",new LoginEvent("Debugger"));

        participantRepository.getActiveSessions();
        participantRepository.getParticipant("2");

        participantRepository.removeParticipant("2");
    }

    @Test
    public void testChatControllerMethods(){
        ChatController controller = new ChatController();
        LoginEvent event = new LoginEvent("JDeek");
        LoginEvent event1 = new LoginEvent("BigDeal");
        LoginEvent event2 = new LoginEvent("Molly");
        ParticipantRepository participantRepository = new ParticipantRepository();
        User user = new User();
        Principal principal = new Principal() {
            @Override
            public String getName() {
                return event.getUsername();
            }
        };
        user.setMessage("Hello guys");
        participantRepository.add("a201",event);
        participantRepository.add("a202",event1);
        participantRepository.add("a203",event2);
        controller.setParticipantRepository(participantRepository);
        controller.retrieveParticipants();

        controller.filterMessage(user,principal);
        controller.filterPrivateMessage(user, event2.getUsername(),principal);
    }
}
