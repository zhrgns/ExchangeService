package edu.sabanciuniv.exchangecurrency.controller;

import edu.sabanciuniv.exchangecurrency.model.dto.ConversionRequest;
import edu.sabanciuniv.exchangecurrency.model.dto.ConversionResponse;
import edu.sabanciuniv.exchangecurrency.model.dto.RateRequest;
import edu.sabanciuniv.exchangecurrency.model.dto.RateResponse;
import edu.sabanciuniv.exchangecurrency.service.PairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class PairController {

    @Autowired
    PairService pairService;


    @GetMapping("/pair/exchange-rate")
    public RateResponse getRateResponse(@RequestBody RateRequest request){
        return pairService.getRateResponse(request);
    }

    @PostMapping ("/pair/conversion")
    public ConversionResponse convertCurrency(@RequestBody ConversionRequest request) {
        return pairService.convertCurrency(request);
    }

    @GetMapping("/pair/conversions")
    public List<ConversionResponse> getConversionList(@RequestParam(required = false) String transactionId,
                                                      @RequestParam(required = false)
                                                      @DateTimeFormat(pattern = "YYYY/MM/dd") LocalDateTime transactionDate) {
        return pairService.getConversionList(transactionId,transactionDate);
    }

}
