package com.devteria.identityservice.constants;

import org.springframework.beans.factory.annotation.Value;

public class KafkaConstant {

    @Value("${spring.kafka.bootstrap-servers}")
    public static String URL ;
}
