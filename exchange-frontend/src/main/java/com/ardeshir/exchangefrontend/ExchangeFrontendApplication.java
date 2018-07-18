package com.ardeshir.exchangefrontend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableCircuitBreaker
@EnableEurekaClient
@SpringBootApplication
public class ExchangeFrontendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExchangeFrontendApplication.class, args);
    }
}
