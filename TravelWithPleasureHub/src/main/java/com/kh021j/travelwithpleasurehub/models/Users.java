package com.kh021j.travelwithpleasurehub.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;

    private String username;

    private String password;

    private String email;

    private String firstName;

    private String secondName;

    private String location;

    private String additionalInfo;

}
