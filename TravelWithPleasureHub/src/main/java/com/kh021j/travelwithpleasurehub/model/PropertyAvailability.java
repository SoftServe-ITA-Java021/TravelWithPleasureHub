package com.kh021j.travelwithpleasurehub.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyAvailability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate bookedSince;

    private LocalDate bookedUntil;

    @ManyToOne
    @JoinColumn(name = "property_id")
    private Property property;

}
