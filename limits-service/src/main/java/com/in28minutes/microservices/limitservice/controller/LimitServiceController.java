package com.in28minutes.microservices.limitservice.controller;

import com.in28minutes.microservices.limitservice.beans.Limits;
import com.in28minutes.microservices.limitservice.configuration.LimitsConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitServiceController {

    @Autowired
    private LimitsConfiguration configuration;

    @GetMapping(value = "/limits")
    public Limits retrieveAllLimits(){
        return new Limits(configuration.getMinimum(),configuration.getMaximum());
        //return new Limits(1,1000);
    }


}
