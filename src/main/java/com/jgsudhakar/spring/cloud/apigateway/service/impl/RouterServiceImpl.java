package com.jgsudhakar.spring.cloud.apigateway.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.jgsudhakar.spring.cloud.apigateway.dto.FilterDefDto;
import org.springframework.stereotype.Service;

import com.jgsudhakar.spring.cloud.apigateway.dto.RouterDto;
import com.jgsudhakar.spring.cloud.apigateway.repository.RouterRepository;
import com.jgsudhakar.spring.cloud.apigateway.service.RouterService;
/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.spring.cloud.apigateway.util.GatewayConstants
 * @Date : 01/05/2021
 */
@Service
public class RouterServiceImpl implements RouterService {
	
	private RouterRepository routerRepository;
	
	public RouterServiceImpl(RouterRepository routerRepository) {
		this.routerRepository = routerRepository;
	}

	@Override
	public List<RouterDto> retrieveRouter() {

		return Optional.ofNullable(routerRepository.findAll()).
				orElse(Collections.emptyList()).
				stream().
				map(entity -> RouterDto.
						builder().
						apiName(entity.getApiName()).
						id(entity.getId()).
						reqUri(entity.getReqUri()).
						targetUri(entity.getTargetUri()).
						filterSet(
								Optional.ofNullable(entity.getFilterDefinitionEntitySet()).
										orElse(Collections.emptyList()).stream().map(filterDefinitionEntity -> {
											return FilterDefDto.builder().
													id(filterDefinitionEntity.getId()).
													filterName(filterDefinitionEntity.getFilterName()).
													remarks(filterDefinitionEntity.getRemarks()).
													order(filterDefinitionEntity.getOrder()).
													build();
								}).collect(Collectors.toSet())
								).
						build()).
				collect(Collectors.toList());
	}

}
