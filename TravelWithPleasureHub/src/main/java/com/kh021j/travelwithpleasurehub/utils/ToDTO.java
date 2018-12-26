package com.kh021j.travelwithpleasurehub.utils;

import com.kh021j.travelwithpleasurehub.userrelated.model.User;
import com.kh021j.travelwithpleasurehub.service.dto.UserDTO;

public class ToDTO {
    public static UserDTO toUserDTO(User user){
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .email(user.getEmail())
                .firstName(user.getFirstName())
                .secondName(user.getSecondName())
                .location(user.getLocation())
                .additionalInfo(user.getAdditionalInfo())
                .phoneNumber(user.getPhoneNumber())
                .status(user.getStatus())
                .role(user.getRole())
                .build();
    }
}
