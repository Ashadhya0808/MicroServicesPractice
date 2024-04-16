package com.in28minutes.microservices.currencyexchangeservice.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class CurrencyExchangeBean {

    @Id
    @GeneratedValue
    private int id;

    private String fromCurrency;

    private String toCurrency;

    private String conversionMultiple;

    private String environment;



    public CurrencyExchangeBean(int id, String fromCurrency, String toCurrency, String conversionMultiple, String environment) {
        this.id = id;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.conversionMultiple = conversionMultiple;
        this.environment = environment;
    }

    public CurrencyExchangeBean() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public String getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(String conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    @Override
    public String toString() {
        return "CurrencyExchangeBean{" +
                "id=" + id +
                ", fromCurrency='" + fromCurrency + '\'' +
                ", toCurrency='" + toCurrency + '\'' +
                ", conversionMultiple='" + conversionMultiple + '\'' +
                ", environment='" + environment + '\'' +
                '}';
    }
}
