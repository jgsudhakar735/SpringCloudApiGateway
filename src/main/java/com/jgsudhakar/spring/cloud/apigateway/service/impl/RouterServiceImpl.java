package com.jgsudhakar.spring.cloud.apigateway.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jgsudhakar.spring.cloud.apigateway.dto.RouterDto;
import com.jgsudhakar.spring.cloud.apigateway.repository.RouterRepository;
import com.jgsudhakar.spring.cloud.apigateway.service.RouterService;

@Service
public class RouterServiceImpl implements RouterService {
	
	private RouterRepository routerRepository;
	
	public RouterServiceImpl(RouterRepository routerRepository) {
		this.routerRepository = routerRepository;
	}

	@Override
	public void print() {
		System.out.println("Calling the Service before data");
		
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
						build()).
				collect(Collectors.toList());
	}

}
