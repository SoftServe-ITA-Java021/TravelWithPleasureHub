package com.kh021j.travelwithpleasurehub.tickets.apiparser.model.response;


import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Currencies {
    private String decimalSeparator;
    private String thousandsSeparator;
    private boolean symbolOnLeft;
    private boolean spaceBetweenAmountSymbol;
    private String symbol;
    private int decimalDigits;
    private String code;
    private double roundingCoefficient;
}
