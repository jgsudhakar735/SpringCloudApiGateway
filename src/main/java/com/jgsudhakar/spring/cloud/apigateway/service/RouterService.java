package com.jgsudhakar.spring.cloud.apigateway.service;

import java.util.List;

import com.jgsudhakar.spring.cloud.apigateway.dto.RouterDto;

public interface RouterService {

	public void print();
	
	public List<RouterDto> retrieveRouter();
}
