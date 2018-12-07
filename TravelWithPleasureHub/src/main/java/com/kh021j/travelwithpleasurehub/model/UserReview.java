package com.kh021j.travelwithpleasurehub.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String reviewText;

    private Integer rate;

    private Integer madeByUserId;

    private LocalDate dateRated;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
