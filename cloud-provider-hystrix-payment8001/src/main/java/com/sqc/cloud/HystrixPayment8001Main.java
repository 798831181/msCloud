package com.sqc.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author sunqichao
 * @date 2020-03-26 13:29
 */
@SpringBootApplication
@EnableEurekaClient
public class HystrixPayment8001Main {
    public static void main(String[] args) {
        SpringApplication.run(HystrixPayment8001Main.class);
    }
}
