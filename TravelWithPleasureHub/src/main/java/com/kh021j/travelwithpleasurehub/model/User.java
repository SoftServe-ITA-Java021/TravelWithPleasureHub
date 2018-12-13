package com.kh021j.travelwithpleasurehub.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "location")
    private String location;

    @Column(name = "additional_info")
    private String additionalInfo;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "path_to_photo")
    private String pathToPhoto;

<<<<<<< HEAD
    public User(String username){
        this.username = username;
    }
=======
    private String status;

    private String role;
>>>>>>> origin/dev

}
