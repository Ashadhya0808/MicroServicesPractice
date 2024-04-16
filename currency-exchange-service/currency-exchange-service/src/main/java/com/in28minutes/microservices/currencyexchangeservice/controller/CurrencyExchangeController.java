package com.in28minutes.microservices.currencyexchangeservice.controller;

import com.in28minutes.microservices.currencyexchangeservice.beans.CurrencyExchangeBean;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchangeBean getConversionMultiple(@PathVariable String from, @PathVariable String to){
        String port = environment.getProperty("local.server.port");
        return new CurrencyExchangeBean(1,from,to,"83", port);
    }

    // Resilience Sample
    @GetMapping("/sample-api")
    @Retry(name = "sample-api" , fallbackMethod = "SampleFallbackMethod")/*sample-api is used at application.properties to define custom number of retries
                                                                            fallbackMethod is used to send sample responses of retry fails*/
    //@CircuitBreaker(name = "defaultCircuitBreaker", fallbackMethod = "SampleFallbackMethod")
    //@RateLimiter(name = "defaultRateLimit") // to specify time i.e 10s only send 2 calls as defined in application.properties
   // @Bulkhead(name = "DefaultBulkHead") // to define maximum number of concurrent calls as defined in ap
    public String getSampleResponse(){
        ResponseEntity<String> entity = new RestTemplate().getForEntity("http://localhost:8080/some-Dummy-url",String.class);
        return entity.getBody();
    }

    public String SampleFallbackMethod(Exception ex){
        return "Sample Fallback Response";
    }
}
