package com.jgsudhakar.spring.cloud.apigateway.util;

import lombok.extern.log4j.Log4j2;

/**
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.spring.cloud.apigateway.util.GatewayConstants
 * @Date : 01/05/2021
 */
@Log4j2
public class GatewayConstants {
    /** Dummy Constructor as this will be always having the static constants.
     * we should not et the consumers to create an object
     */
    private GatewayConstants() {
    log.info("Dummy Constructor");
    }

    public static final String X_GBL_HEADER = "X-GBL-HEADER";
    public static final String X_PRE_FIL_HEADER = "X-PRE-FILTER-HEADER";

}
