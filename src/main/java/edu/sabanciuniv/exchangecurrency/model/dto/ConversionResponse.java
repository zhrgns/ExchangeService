package edu.sabanciuniv.exchangecurrency.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConversionResponse {

    private double amount;
    private double totalAmount;
    private String transactionId;

}
