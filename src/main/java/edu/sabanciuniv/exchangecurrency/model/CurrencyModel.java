package edu.sabanciuniv.exchangecurrencyservice.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CurrencyModel {
    private List<CurrencySub> currencies = new ArrayList<>();
}
