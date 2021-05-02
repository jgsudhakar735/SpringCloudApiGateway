package com.jgsudhakar.spring.cloud.apigateway.util;

import lombok.extern.log4j.Log4j2;

import java.security.SecureRandom;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.spring.cloud.apigateway.util.GatewayUtil
 * @Date : 02/05/2021
 */
@Log4j2
public class GatewayUtil {
    /** Dummy Constructor as this will be always having the static constants.
     * we should not et the consumers to create an object
     */
    private GatewayUtil(){
        log.info("Dummy Constructor");
    }

    /**
     * Request Header Unique Id Generator
     */
    public static String generateUniqueId() {
        long MSB = 0x8000000000000000L;
        SecureRandom ng = new SecureRandom();
        return (Long.toHexString(MSB | ng.nextLong()) + Long.toHexString(MSB | ng.nextLong())).toUpperCase();
    }
}
