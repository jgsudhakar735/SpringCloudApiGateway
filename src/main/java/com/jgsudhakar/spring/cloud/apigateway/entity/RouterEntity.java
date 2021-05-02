package com.jgsudhakar.spring.cloud.apigateway.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import lombok.Data;
/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.spring.cloud.apigateway.util.GatewayConstants
 * @Date : 01/05/2021
 */
@Entity
@Table(name = "ROUTE_DEF_MTB")
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

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "routerEntity",fetch = FetchType.EAGER)
	private List<FilterDefinitionEntity> filterDefinitionEntitySet = new ArrayList<>();
}
