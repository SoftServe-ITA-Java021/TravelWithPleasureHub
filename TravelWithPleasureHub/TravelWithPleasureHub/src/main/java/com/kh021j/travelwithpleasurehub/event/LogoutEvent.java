package com.kh021j.travelwithpleasurehub.event;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by ${JDEEK} on ${11.11.2018}.
 */
@Data
@AllArgsConstructor
public class LogoutEvent {
    private String username;
}
