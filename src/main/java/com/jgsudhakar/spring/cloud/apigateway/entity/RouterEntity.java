package com.jgsudhakar.spring.cloud.apigateway.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "APIM_API_ROUTE")
@Data
public class RouterEntity implements Serializable{
	
	/**
	 * Default Serial id
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO,generator = "AR_SEQ")
	@SequenceGenerator(initialValue = 1,allocationSize = 1,name = "AR_SEQ")
	@Column(name = "API_KEY")
	private Long id;
	
	@Column(name = "API_NAME")
	private String apiName;
	
	@Column(name = "REQUEST_URI")
	private String reqUri;
	
	@Column(name = "TARGET_URL")
	private String targetUri;

}
