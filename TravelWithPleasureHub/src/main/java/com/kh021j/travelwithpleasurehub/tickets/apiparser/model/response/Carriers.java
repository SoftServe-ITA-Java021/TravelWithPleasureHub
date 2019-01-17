package com.kh021j.travelwithpleasurehub.tickets.apiparser.model.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Carriers {
    private String imageUrl;
    private int id;
    private String code;
    private String name;
    private String displayCode;
}
