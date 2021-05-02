package com.jgsudhakar.spring.cloud.apigateway.service;

import java.util.List;

import com.jgsudhakar.spring.cloud.apigateway.dto.RouterDto;
/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.spring.cloud.apigateway.util.GatewayConstants
 * @Date : 01/05/2021
 */
public interface RouterService {

	public List<RouterDto> retrieveRouter();
}
