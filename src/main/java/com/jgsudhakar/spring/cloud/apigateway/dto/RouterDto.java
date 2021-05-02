package com.jgsudhakar.spring.cloud.apigateway.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import lombok.Builder;
import lombok.Data;
/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.spring.cloud.apigateway.util.GatewayConstants
 * @Date : 01/05/2021
 */
@Data
@Builder
public class RouterDto implements Serializable{

	/**
	 * Default Serial id
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	
	private String apiName;
	
	private String reqUri;
	
	private String targetUri;

	private String remarks;

	private Long apikey;

	private Set<FilterDefDto> filterSet = new HashSet<>();
}
