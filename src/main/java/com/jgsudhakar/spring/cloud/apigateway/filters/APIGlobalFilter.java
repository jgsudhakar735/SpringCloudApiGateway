package com.jgsudhakar.spring.cloud.apigateway.filters;

import com.jgsudhakar.spring.cloud.apigateway.util.GatewayConstants;
import com.jgsudhakar.spring.cloud.apigateway.util.GatewayUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.spring.cloud.apigateway.filters.APIGlobalFilter
 * @Date : 02/05/2021
 */
@Configuration
@Log4j2
public class APIGlobalFilter implements GlobalFilter, Ordered {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info(":: Inside the Global API GatewayFilter ::");
        ServerHttpRequest request = exchange.getRequest().mutate().
                header(GatewayConstants.X_GBL_HEADER, GatewayUtil.generateUniqueId()).
                build();
        return chain.filter(exchange.mutate().request(request).build());
    }

    @Override
    public int getOrder() {
        return 0;
    }


}
