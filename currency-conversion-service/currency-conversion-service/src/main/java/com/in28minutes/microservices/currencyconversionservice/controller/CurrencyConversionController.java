package com.in28minutes.microservices.currencyconversionservice.controller;

import com.in28minutes.microservices.currencyconversionservice.beans.CurrencyConversionBean;
import com.in28minutes.microservices.currencyconversionservice.config.CurrencyConversionConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyConversionConfiguration exchangeProxy;

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean getConversion(@PathVariable String from, @PathVariable String to, @PathVariable Integer quantity){
        RestTemplate restTemplate = new RestTemplate();
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);
        ResponseEntity<CurrencyConversionBean> exchangeResult =  restTemplate.getForEntity(
                "http://localhost:8000/currency-exchange/from/{from}/to/{to}"
                , CurrencyConversionBean.class,uriVariables);
        CurrencyConversionBean conversionBean = exchangeResult.getBody();
        return new CurrencyConversionBean(conversionBean.getId(),from,to
                ,conversionBean.getConversionMultiple()
                , conversionBean.getEnvironment()
                , quantity
                , Integer.parseInt(conversionBean.getConversionMultiple())*quantity);

    }

    @GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean getConversionFeign(@PathVariable String from, @PathVariable String to, @PathVariable Integer quantity){

        CurrencyConversionBean conversionBean = exchangeProxy.getConversionMultiple(from, to);
        return new CurrencyConversionBean(conversionBean.getId(),from,to
                ,conversionBean.getConversionMultiple()
                , conversionBean.getEnvironment() + " " + "feign"
                , quantity
                , Integer.parseInt(conversionBean.getConversionMultiple())*quantity);

    }
}
