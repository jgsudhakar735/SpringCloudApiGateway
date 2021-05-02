package com.jgsudhakar.spring.cloud.apigateway.service.impl;

import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.spring.cloud.apigateway.service.impl.RouterDefinitionRepoImpl
 * @Date : 02/05/2021
 */
//@Service
public class RouterDefinitionRepoImpl implements RouteDefinitionRepository {
    @Override
    public Flux<RouteDefinition> getRouteDefinitions() {
        return null;
    }

    @Override
    public Mono<Void> save(Mono<RouteDefinition> route) {
        return null;
    }

    @Override
    public Mono<Void> delete(Mono<String> routeId) {
        return null;
    }
}
