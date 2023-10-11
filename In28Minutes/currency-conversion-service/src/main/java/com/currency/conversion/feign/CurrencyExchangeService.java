package com.currency.conversion.feign;

import com.currency.conversion.dto.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 */
//@FeignClient(name = "currency-exchange-service", url = "http://localhost:8000")
//@FeignClient(name = "currency-exchange-service")
@FeignClient(name = "api-gateway")
public interface CurrencyExchangeService {
    @GetMapping("currency-exchange/api/v1/exchange-value/{from}/to/{to}")
    public CurrencyConversion getExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to);
}
