package com.in28minutes.microservices.apigateway.loggingFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;


@Component
public class ApiGatewayLoggingFilter implements GlobalFilter {

    private Logger logger = LoggerFactory.getLogger(ApiGatewayLoggingFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange,
                             GatewayFilterChain chain) {
        /*Creates a logger.info before request os called*/
        logger.info("Request comes from -> {}" , exchange.getRequest().getPath());
        return chain.filter(exchange);
    }
}
