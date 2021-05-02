package com.jgsudhakar.spring.cloud.apigateway.service.impl;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Service;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.spring.cloud.apigateway.service.impl.RefreshRouterDefinition
 * @Date : 02/05/2021
 */
@Service
public class RefreshRouterDefinition implements ApplicationEventPublisherAware {

    protected  ApplicationEventPublisherAware applicationEventPublisherAware;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisherAware = applicationEventPublisherAware;
    }


}
