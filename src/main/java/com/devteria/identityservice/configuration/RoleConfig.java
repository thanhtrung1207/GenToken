package com.devteria.identityservice.configuration;

import org.springframework.beans.factory.annotation.Value;

public class RoleConfig {
    @Value("${http.roles.admin}")
    public static String ADMIN ;

    @Value("${http.roles.client}")
    public static String CLIENT ;
}
