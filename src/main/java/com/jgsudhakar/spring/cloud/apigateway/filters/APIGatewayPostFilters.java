package com.jgsudhakar.spring.cloud.apigateway.filters;

import com.jgsudhakar.spring.cloud.apigateway.util.GatewayConstants;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.security.SecureRandom;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.spring.cloud.apigateway.filters.APIGatewayGlobalFilters
 * @Date : 01/05/2021
 */
@Component
@Log4j2
public class APIGatewayPostFilters extends AbstractGatewayFilterFactory<APIGatewayPostFilters.Config> {

    public APIGatewayPostFilters(){
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        log.info(":: Inside the Post API GatewayFilter ::");
        return (exchange, chain) -> {
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                ServerHttpResponse response = exchange.getResponse();
                HttpHeaders httpHeaders = response.getHeaders();
                httpHeaders.forEach((k,v) -> {
                    log.info(" Key: " +k + " & value :"+v);
                });
            }));
        };
    }
    /**
     * Request Header Unique Id Generator
     */
    private static String generateUniqueId() {
        long MSB = 0x8000000000000000L;
        SecureRandom ng = new SecureRandom();
        String generatedUUID  = (Long.toHexString(MSB | ng.nextLong()) + Long.toHexString(MSB | ng.nextLong())).toUpperCase();
        return generateUniqueId();
    }

    @Data
    public static class Config {
        private  String name;

    }
}
