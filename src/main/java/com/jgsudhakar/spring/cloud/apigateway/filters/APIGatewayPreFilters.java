package com.jgsudhakar.spring.cloud.apigateway.filters;

import com.jgsudhakar.spring.cloud.apigateway.util.GatewayConstants;
import com.jgsudhakar.spring.cloud.apigateway.util.GatewayUtil;
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
public class APIGatewayPreFilters extends AbstractGatewayFilterFactory<APIGatewayPreFilters.Config> {

    public APIGatewayPreFilters(){
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        log.info(":: Inside the Pre  API GatewayFilter ::");
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest().mutate().
                    header(GatewayConstants.X_PRE_FIL_HEADER, GatewayUtil.generateUniqueId()).
                    build();
            request.getHeaders().forEach((k,v) -> {
                log.info(" Key: " +k + " & value :"+v);
            });
            return chain.filter(exchange.mutate().request(request).build());
        };
    }
    @Data
    public static class Config {
        private  String name;

    }
}
