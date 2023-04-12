package edu.sabanciuniv.exchangecurrency.model.dto;

import lombok.Data;

@Data
public class ConversionRequest {

    private String target;
    private String source;
    private double amount;

}
