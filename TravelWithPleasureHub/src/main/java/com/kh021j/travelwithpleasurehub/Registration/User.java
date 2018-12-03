package com.kh021j.travelwithpleasurehub.Registration;


import lombok.*;
import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String secondName;
    private String location;
    private String additionalInfo;
    private String phoneNumber;

    public User(String username, String password, String email, String firstName, String secondName, String location,
                String additionalInfo, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.secondName = secondName;
        this.location = location;
        this.additionalInfo = additionalInfo;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() { return password;    }
    public String getUsername() { return username; }
}

//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
