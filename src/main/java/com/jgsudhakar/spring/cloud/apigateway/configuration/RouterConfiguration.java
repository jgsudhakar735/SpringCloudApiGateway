package com.jgsudhakar.spring.cloud.apigateway.configuration;

import com.jgsudhakar.spring.cloud.apigateway.dto.RouterDto;
import com.jgsudhakar.spring.cloud.apigateway.filters.APIGlobalFilter;
import com.jgsudhakar.spring.cloud.apigateway.service.RouterService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.spring.cloud.apigateway.util.GatewayConstants
 * @Date : 01/05/2021
 */
@Log4j2
@ConditionalOnClass(FlywayAutoConfiguration.class)
@Configuration
public class RouterConfiguration {

	@Autowired
	private RouterService routerService;

	@ConditionalOnProperty(prefix = "apigateway",name = "loadYamlConfig",havingValue = "false",matchIfMissing = true)
	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder) {
		log.info(":: Started Loading the Configuration from data base::");
		List<RouterDto> retrieveRouter = routerService.retrieveRouter();
		RouteLocatorBuilder.Builder routes = builder.routes();
		// injecting the routers to router builder
		Optional.ofNullable(retrieveRouter).
				orElse(Collections.emptyList()).
				forEach(routerDto -> {
					routes.
						route(r -> {
							log.info("Loading the FIlter Configuration::"+routerDto.getApiName());
							return r.path(routerDto.getReqUri()).
//							filters(gatewayFilterSpec -> {
//								Optional.ofNullable(routerDto.getFilterSet()).
//										orElse(Collections.emptySet()).
//										forEach(filterDefDto -> {
//											gatewayFilterSpec.preserveHostHeader().
//											filter(filterDefDto.getFilterName(),filterDefDto.getOrder());
//										});
//										;
//								return gatewayFilterSpec;
//							}).
							uri(routerDto.getTargetUri());
						});
				});
		return routes.build();
	}
}
