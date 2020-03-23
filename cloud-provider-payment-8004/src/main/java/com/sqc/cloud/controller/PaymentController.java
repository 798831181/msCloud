package com.sqc.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author sunqichao
 * @date 2020-03-19 15:30
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;
    @GetMapping(value = "payment/zk")
    public String paymentZK(){
        return "serverPort: "+serverPort + UUID.randomUUID().toString();
    }
}
