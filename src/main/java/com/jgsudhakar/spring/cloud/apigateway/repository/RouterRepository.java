package com.jgsudhakar.spring.cloud.apigateway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jgsudhakar.spring.cloud.apigateway.entity.RouterEntity;

@Repository
public interface RouterRepository extends JpaRepository<RouterEntity, Long>{

}
