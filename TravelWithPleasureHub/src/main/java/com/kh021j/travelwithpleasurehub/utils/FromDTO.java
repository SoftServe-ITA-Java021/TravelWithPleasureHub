package com.kh021j.travelwithpleasurehub.utils;

import com.kh021j.travelwithpleasurehub.userrelated.model.User;
import com.kh021j.travelwithpleasurehub.service.dto.UserDTO;

public class FromDTO {
    public static User fromUserDTO(UserDTO userDTO){
        return User.builder()
                .id(userDTO.getId())
                .username(userDTO.getUsername())
                .password(userDTO.getPassword())
                .email(userDTO.getEmail())
                .firstName(userDTO.getFirstName())
                .secondName(userDTO.getSecondName())
                .location(userDTO.getLocation())
                .additionalInfo(userDTO.getAdditionalInfo())
                .phoneNumber(userDTO.getPhoneNumber())
                .status(userDTO.getStatus())
                .role(userDTO.getRole())
                .build();
    }
}
