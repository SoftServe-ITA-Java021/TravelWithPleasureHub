package com.kh021j.travelwithpleasurehub.config;

import com.kh021j.travelwithpleasurehub.event.ParticipantRepository;
import com.kh021j.travelwithpleasurehub.event.PresenceEventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.messaging.simp.SimpMessagingTemplate;

/**
 * Created by ${JDEEK} on ${11.11.2018}.
 */
@Configuration
@EnableConfigurationProperties(ChatProperties.class)
public class ChatConfig {

    @Autowired
    private ChatProperties chatProperties;

    @Bean
    @Description("Keeps connected users")
    public ParticipantRepository participantRepository(){return new ParticipantRepository();}
    @Bean
    @Description("Tracks user presence - join or leave. And broadcasts it to all connected users")
    public PresenceEventListener presenceEventListener(SimpMessagingTemplate messagingTemplate){
        PresenceEventListener presence = new PresenceEventListener(messagingTemplate,participantRepository());
        presence.setLoginDestination(chatProperties.getDestinations().getLogin());
        presence.setLogoutDestination(chatProperties.getDestinations().getLogout());
        return presence;
    }

    @Bean
    public JedisConnectionFactory jedisConnectionFactory(){
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setHostName("localhost");
        jedisConnectionFactory.setPort(6379);
        return jedisConnectionFactory;
    }

    @Bean
    public RedisTemplate<String, Object> getRedisTemplate(){
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new StringRedisSerializer());
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new StringRedisSerializer());
        return redisTemplate;
    }

}
