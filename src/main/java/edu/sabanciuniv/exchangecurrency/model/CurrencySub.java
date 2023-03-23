package edu.sabanciuniv.exchangecurrencyservice.model;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CurrencySub {
    private String source;
    private List<Rate> rates = new ArrayList<>();
}
