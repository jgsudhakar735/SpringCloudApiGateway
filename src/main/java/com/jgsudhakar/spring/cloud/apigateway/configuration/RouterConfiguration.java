package com.jgsudhakar.spring.cloud.apigateway.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jgsudhakar.spring.cloud.apigateway.service.RouterService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Configuration
public class RouterConfiguration {
	
	@Autowired
	private RouterService routerService;

	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder) {
		routerService.print();
		log.info(":: Started Configuring the Router ::");
		return builder.routes()
                .route(r ->
                        r.path("/java/**")
                                .filters(
                                        f -> f.stripPrefix(1)
                                )
                                .uri("http://httpbin.org:80")
                )
                .build();
	}
}
