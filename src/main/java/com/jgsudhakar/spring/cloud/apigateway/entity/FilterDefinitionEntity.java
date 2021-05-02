package com.jgsudhakar.spring.cloud.apigateway.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.spring.cloud.apigateway.entity.FilterDefinitionEntity
 * @Date : 02/05/2021
 */
@Entity
@Table(name = "FILTER_DEF_MTB")
@Data
public class FilterDefinitionEntity implements Serializable {

    /**
     * Default Serial id
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator = "FTR_SEQ")
    @SequenceGenerator(initialValue = 1,allocationSize = 1,name = "FTR_SEQ")
    @Column(name = "PK_KEY")
    private Long id;

    @Column(name = "FTR_NAME")
    private String filterName;

    @Column(name = "FTR_REMARKS")
    private String remarks;

    @Column(name = "API_KEY",insertable = false,updatable = false)
    private Long apikey;

    @Column(name = "FTR_ORDER")
    private Integer order;

    @ManyToOne
    @JoinColumn(name="API_KEY",referencedColumnName="API_KEY")
    private RouterEntity routerEntity;
}
