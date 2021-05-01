package com.jgsudhakar.spring.cloud.apigateway.configuration;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import com.jgsudhakar.spring.cloud.apigateway.dto.RouterDto;
import com.jgsudhakar.spring.cloud.apigateway.service.RouterService;

import lombok.extern.log4j.Log4j2;

@Log4j2
//@ConditionalOnClass(FlywayAutoConfiguration.class)
//@Configuration
public class RouterConfiguration {
	
	@Autowired
	private RouterService routerService;

	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder) {
		List<RouterDto> retrieveRouter = routerService.retrieveRouter();
		log.info(":: Started Configuring the Router ::"+retrieveRouter.toString());
		
		Optional.ofNullable(retrieveRouter).
		orElse(Collections.emptyList()).
		stream().
		map(dto -> {
			return null;
		}).collect(Collectors.toList());
		
		RouteLocator build = builder.routes()
                .route(r ->
                        r.path("/java/**")
                                .filters(
                                        f -> f.stripPrefix(1)
                                )
                                .uri("http://httpbin.org:80")
                )
                .build();
		return build;
	}
}
