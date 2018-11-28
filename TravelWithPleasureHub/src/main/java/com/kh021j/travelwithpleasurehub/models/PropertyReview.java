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
public class PropertyReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    private String reviewText;

    private Integer rate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users userTable;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;

}
