package com.kh021j.travelwithpleasurehub.models;


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
public class PropertyAvailability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigInteger id;

    private LocalDate bookedSince;

    private LocalDate bookedUntil;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;

}
