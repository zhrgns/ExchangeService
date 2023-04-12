package edu.sabanciuniv.exchangecurrency.model;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CurrencySub {
    private String source;
    private List<Rate> rates = new ArrayList<>();
}
