package com.currency.conversion.controller;

import com.currency.conversion.dto.CurrencyConversion;
import com.currency.conversion.feign.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
public class CurrencyConversionController {
    @Autowired
    private Environment environment;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CurrencyExchangeService currencyExchangeService;

    @GetMapping("/api/v1/currency-conversion/{from}/to/{to}/{quantity}")
    public CurrencyConversion getExchangeValue(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        int port = Integer.parseInt(Objects.requireNonNull(environment.getProperty("local.server.port")));
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);
        ResponseEntity<CurrencyConversion> response = restTemplate.getForEntity("http://localhost:8000/api/v1/exchange-value/{from}/to/{to}", CurrencyConversion.class, uriVariables);
        CurrencyConversion currencyConversion = response.getBody();
        System.out.println(currencyConversion);
        if (Objects.nonNull(currencyConversion)) {
            currencyConversion.setCalculatedAmount(currencyConversion.getConversionMultiple().multiply(quantity));
            currencyConversion.setPort(port);
            currencyConversion.setQuantity(quantity);
        }
        return currencyConversion;
    }

    /**
     * @param from
     * @param to
     * @param quantity
     * @return
     */
    @GetMapping("/api/v1/currency-conversion-feign/{from}/to/{to}/{quantity}")
    public CurrencyConversion getExchangeValueByFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {
        int port = Integer.parseInt(Objects.requireNonNull(environment.getProperty("local.server.port")));
        CurrencyConversion currencyConversion = currencyExchangeService.getExchangeValue(from, to);
        System.out.println("currencyConversion=="+currencyConversion);
        if (Objects.nonNull(currencyConversion)) {
            currencyConversion.setCalculatedAmount(currencyConversion.getConversionMultiple().multiply(quantity));
            //currencyConversion.setPort(port);
            currencyConversion.setQuantity(quantity);
        }
        return currencyConversion;
    }


}
