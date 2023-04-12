package edu.sabanciuniv.exchangecurrency.service;


import edu.sabanciuniv.exchangecurrency.exception.NoSuchPairException;
import edu.sabanciuniv.exchangecurrency.exception.NoSuchTransactionException;
import edu.sabanciuniv.exchangecurrency.model.Conversion;
import edu.sabanciuniv.exchangecurrency.model.Pair;
import edu.sabanciuniv.exchangecurrency.model.dto.ConversionRequest;
import edu.sabanciuniv.exchangecurrency.model.dto.ConversionResponse;
import edu.sabanciuniv.exchangecurrency.model.dto.RateRequest;
import edu.sabanciuniv.exchangecurrency.model.dto.RateResponse;
import edu.sabanciuniv.exchangecurrency.repository.PairRepository;
import edu.sabanciuniv.exchangecurrency.repository.ConversionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PairService {

    @Autowired
    PairRepository pairRepository;

    @Autowired
    ConversionRepository conversionRepository;


    public RateResponse getRateResponse(RateRequest rateRequest) {

        String source = rateRequest.getSource();
        String target = rateRequest.getTarget();

        Pair entity = pairRepository.findPairBySourceAndTarget(source, target);

        return RateResponse.builder().rate(entity.getRate()).build();

    }

    public ConversionResponse convertCurrency(ConversionRequest request) {
        Pair entity = pairRepository.findPairBySourceAndTarget(request.getSource(), request.getTarget());

        if (entity != null) {

            double amount = request.getAmount();

            double total = entity.getRate() * amount;

            //new entity
            Conversion conversion = Conversion.builder().sourceAmount(amount).totalAmount(total).transactionId(UUID.randomUUID().toString()).transactionDate(LocalDateTime.now()).build();

            //save entity
            conversion = conversionRepository.save(conversion);

            //new response entity
            return ConversionResponse.builder().amount(amount).totalAmount(total).transactionId(conversion.getTransactionId()).build();

        } else {
            throw new NoSuchPairException(" No such pair !");
        }
    }


    public List<ConversionResponse> getConversionList(String transactionId, LocalDateTime transactionDate) {
        List<ConversionResponse> responseList = new ArrayList<>();

        if (transactionId != null) {

            Conversion entity = conversionRepository.findByTransactionId(transactionId);

            ConversionResponse response = ConversionResponse.builder().amount(entity.getSourceAmount()).totalAmount(entity.getTotalAmount()).transactionId(entity.getTransactionId()).build();
            responseList.add(response);

            return responseList;

        } else if (transactionDate != null) {

            List<Conversion> entityList = conversionRepository.findByTransactionDate(transactionDate);
            for (Conversion entity : entityList) {

                ConversionResponse response = ConversionResponse.builder().amount(entity.getSourceAmount()).totalAmount(entity.getTotalAmount()).transactionId(entity.getTransactionId()).build();

                responseList.add(response);
            }
            return responseList;
        } else {
            throw new NoSuchTransactionException("No such transaction !");
        }
    }
}
