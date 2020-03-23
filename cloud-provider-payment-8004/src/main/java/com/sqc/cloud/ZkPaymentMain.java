package com.sqc.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author sunqichao
 * @date 2020-03-19 15:27
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ZkPaymentMain {
    public static void main(String[] args) {
        SpringApplication.run(ZkPaymentMain.class);
    }
}
