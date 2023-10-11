package com.currency.exchange.controller;

import com.currency.exchange.entity.ExchangeValue;
import com.currency.exchange.repo.ExchangeValueRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ExchangeValueRepo exchangeValueRepo;

    @Autowired
    private ServerProperties serverProperties;

    @GetMapping("/api/v1/exchange-value/{from}/to/{to}")
    public ExchangeValue getExchangeValue(@PathVariable String from, @PathVariable String to) {
        int port = Integer.parseInt(Objects.requireNonNull(environment.getProperty("local.server.port")));
    /*    List<ExchangeValue> list = new ArrayList<>();
        ExchangeValue exchangeValue1 = new ExchangeValue("USD", "INR", new BigDecimal("75.00"));
        list.add(exchangeValue1);
        ExchangeValue exchangeValue2 = new ExchangeValue("EUR", "INR", new BigDecimal("61.00"));
        list.add(exchangeValue2);
        ExchangeValue exchangeValue3 = new ExchangeValue("INR", "USD", new BigDecimal("00.75"));
        list.add(exchangeValue3);
        ExchangeValue exchangeValue4 = new ExchangeValue("INR", "EUR", new BigDecimal("0.61"));
        list.add(exchangeValue4);
        exchangeValueRepo.saveAll(list);*/
        ExchangeValue exchangeValue = exchangeValueRepo.findByFromAndTo(from, to);
        logger.info("exchangeValue==={}", exchangeValue);
        exchangeValue.setPort(port);
        return exchangeValue;
    }


    @PostMapping("/api/v1/exchange-value")
    public List<ExchangeValue> saveExchangeValue() {
        List<ExchangeValue> list = new ArrayList<>();
        ExchangeValue exchangeValue1 = new ExchangeValue("USD", "INR", new BigDecimal("75.00"));
        list.add(exchangeValue1);
        ExchangeValue exchangeValue2 = new ExchangeValue("EUR", "INR", new BigDecimal("61.00"));
        list.add(exchangeValue2);
        ExchangeValue exchangeValue3 = new ExchangeValue("INR", "USD", new BigDecimal("00.75"));
        list.add(exchangeValue3);
        ExchangeValue exchangeValue4 = new ExchangeValue("INR", "EUR", new BigDecimal("0.61"));
        list.add(exchangeValue4);
        return exchangeValueRepo.saveAll(list);
    }

}





