package com.kh021j.travelwithpleasurehub.service.dto;

import com.kh021j.travelwithpleasurehub.model.enumiration.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Integer id;

    private String username;

    private String password;

    private String email;

    private String firstName;

    private String secondName;

    private String location;

    private String additionalInfo;

    private String phoneNumber;

    private String pathToPhoto;

    private String status;

    private UserRole role;

    private boolean enabled;
}
