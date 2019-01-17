package com.kh021j.travelwithpleasurehub.tickets.apiparser.model.response.v2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(name = "buying_link")
    private String linkForBuying;

    @Column(name = "price")
    private Double price;

}
