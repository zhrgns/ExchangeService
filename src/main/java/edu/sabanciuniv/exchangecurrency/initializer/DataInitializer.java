package edu.sabanciuniv.exchangecurrencyservice.initializer;

import edu.sabanciuniv.exchangecurrencyservice.model.CurrencyModel;
import edu.sabanciuniv.exchangecurrencyservice.model.CurrencySub;
import edu.sabanciuniv.exchangecurrencyservice.model.Pair;
import edu.sabanciuniv.exchangecurrencyservice.model.Rate;
import edu.sabanciuniv.exchangecurrencyservice.repository.PairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    PairRepository pairRepository;

    @Override
    public void run(String... args) throws Exception {
        String url ="https://mocki.io/v1/1e26abb9-d48e-42b9-995d-54cddecfbae2";
          CurrencyModel currencyModel= restTemplate.getForObject(url, CurrencyModel.class);

        if (pairRepository.count() ==0 ) {
            for (CurrencySub currency : currencyModel.getCurrencies()) {

                for(Rate rate : currency.getRates()) {

                     Pair pair =Pair.builder()
                             .source(currency.getSource())
                             .target(rate.getTarget())
                             .rate(rate.getRate())
                             .build();

                     pairRepository.save(pair);
                }
            }
        }
    }
}
