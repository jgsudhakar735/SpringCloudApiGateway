package com.jgsudhakar.spring.cloud.apigateway.filters;

import com.jgsudhakar.spring.cloud.apigateway.util.GatewayConstants;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.spring.cloud.apigateway.filters.APIGatewayGlobalFilters
 * @Date : 01/05/2021
 */
@Component
@Log4j2
public class APIGatewayGlobalFilters extends AbstractGatewayFilterFactory<APIGatewayGlobalFilters.Config> {

    public APIGatewayGlobalFilters(){
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        log.info(":: Inside the Global API GatewayFilter ::");
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest().mutate().
                    header(GatewayConstants.X_GBL_HEADER,generateUniqueId()).
                    build();
            return chain.filter(exchange.mutate().request(request).build());
        };
    }
    /**
     * Request Header Unique Id Generator
     */
    private static String generateUniqueId() {
        long MSB = 0x8000000000000000L;
        SecureRandom ng = new SecureRandom();
        return (Long.toHexString(MSB | ng.nextLong()) + Long.toHexString(MSB | ng.nextLong())).toUpperCase();
    }

    @Data
    public static class Config {
        private  String name;

    }
}
