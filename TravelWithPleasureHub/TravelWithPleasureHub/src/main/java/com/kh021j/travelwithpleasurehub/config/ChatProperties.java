package com.kh021j.travelwithpleasurehub.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by ${JDEEK} on ${11.11.2018}.
 */
@ConfigurationProperties(prefix = "chat")
public class ChatProperties {

    private Destinations destinations;

    public Destinations getDestinations() {
        return destinations;
    }

    public void setDestinations(Destinations destinations) {
        this.destinations = destinations;
    }

    static class Destinations{
        private String login;
        private String logout;

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getLogout() {
            return logout;
        }

        public void setLogout(String logout) {
            this.logout = logout;
        }
    }
}
