package com.jgsudhakar.spring.cloud.apigateway.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.spring.cloud.apigateway.dto.FilterDefDto
 * @Date : 02/05/2021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FilterDefDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String filterName;

    private String remarks;

    private Integer order;
}
