package com.sqc.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author sunqichao
 * @date 2020-03-30 20:16
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashBoard9001Main {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashBoard9001Main.class);
    }

}
