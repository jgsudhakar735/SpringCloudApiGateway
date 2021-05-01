package com.jgsudhakar.spring.cloud.apigateway.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.spring.cloud.apigateway.controller.APIGatewayController
 * @Date : 01/05/2021
 */
@RestController
@RequestMapping("gateway")
public class APIGatewayController {
    @Value("${server.port}")
    private int serevrPort;

    @GetMapping
    public String serverDetaila() {
        return " This is a Sample Spring API CLoud Gateway Running on the Port "+serevrPort;
    }
}
