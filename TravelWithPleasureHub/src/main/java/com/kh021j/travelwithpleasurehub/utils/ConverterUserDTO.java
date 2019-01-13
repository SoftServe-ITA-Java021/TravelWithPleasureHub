package com.kh021j.travelwithpleasurehub.utils;

import com.kh021j.travelwithpleasurehub.model.User;
import com.kh021j.travelwithpleasurehub.service.dto.UserDTO;

public class ConverterUserDTO {

    public static UserDTO toUserDTO(User user) {
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

    public static User fromUserDTO(UserDTO userDTO) {
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
