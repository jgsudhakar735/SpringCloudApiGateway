package com.jgsudhakar.spring.cloud.apigateway.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

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
}
