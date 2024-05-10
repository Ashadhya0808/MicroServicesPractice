package com.in28minutes.microservices.currencyconversionservice.config;


import com.in28minutes.microservices.currencyconversionservice.beans.CurrencyConversionBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange", url = "localhost:8000")
@FeignClient(name = "currency-exchange-service") // name defined in eureka naming server for currency exchange service
public interface CurrencyConversionConfiguration {

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversionBean getConversionMultiple(
            @PathVariable String from,
            @PathVariable String to);

}
