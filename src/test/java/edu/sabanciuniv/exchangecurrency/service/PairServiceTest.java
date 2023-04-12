package edu.sabanciuniv.exchangecurrency.service;

import edu.sabanciuniv.exchangecurrency.model.Pair;
import edu.sabanciuniv.exchangecurrency.model.dto.RateRequest;
import edu.sabanciuniv.exchangecurrency.model.dto.RateResponse;
import edu.sabanciuniv.exchangecurrency.repository.PairRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
class PairServiceTest {

    @InjectMocks
    PairService pairService;

    @Mock
    PairRepository pairRepository;

    @Test
    void getRateResponseTest() {


        // given
        RateRequest rateRequest = RateRequest.builder().source("BTC").target("USD").build();
        Mockito.when(pairRepository.findPairBySourceAndTarget(Mockito.any(),Mockito.any())).thenReturn(Pair.builder().build());


        // when

        RateResponse rateResponse = pairService.getRateResponse(rateRequest);


        // then

        assertNotNull(rateResponse);

    }


    @Test
    void convertCurrencyTest() {
    }

    @Test
    void getConversionListTest() {
    }
}