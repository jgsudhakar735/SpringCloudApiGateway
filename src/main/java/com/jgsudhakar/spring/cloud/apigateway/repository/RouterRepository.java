package com.jgsudhakar.spring.cloud.apigateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jgsudhakar.spring.cloud.apigateway.entity.RouterEntity;
/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.spring.cloud.apigateway.util.GatewayConstants
 * @Date : 01/05/2021
 */
@Repository
public interface RouterRepository extends JpaRepository<RouterEntity, Long>{

}
