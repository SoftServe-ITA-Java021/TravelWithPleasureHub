package com.kh021j.travelwithpleasurehub.tickets.apiparser.model.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Places {
    private int parentId;
    private String type;
    private int id;
    private String code;
    private String name;
}
