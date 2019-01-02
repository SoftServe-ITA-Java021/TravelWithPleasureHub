package com.kh021j.travelwithpleasurehub.model;


import com.kh021j.travelwithpleasurehub.model.enumiration.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;

    private String confirmPassword;

    private String email;

    private String firstName;

    private String secondName;

    private String location;

    private String additionalInfo;

    private String phoneNumber;

    private String pathToPhoto;

    private String status;

    @Enumerated(EnumType.STRING)
    @NotEmpty @NotNull
    private UserRole role;

    private boolean enabled;

}
