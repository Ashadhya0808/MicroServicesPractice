package com.in28minutes.microservices.currencyconversionservice.beans;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class CurrencyConversionBean {

    @Id
    @GeneratedValue
    private int id;

    private String fromCurrency;

    private String toCurrency;

    private String conversionMultiple;

    private String environment;

    private Integer quantity;

    private Integer totalAmount;

    public CurrencyConversionBean() {
    }

    public CurrencyConversionBean(int id, String fromCurrency, String toCurrency, String conversionMultiple, String environment, Integer quantity, Integer totalAmount) {
        this.id = id;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.conversionMultiple = conversionMultiple;
        this.environment = environment;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }
}
