package com.sqc.cloud.controller;

import com.sqc.cloud.services.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sunqichao
 * @date 2020-03-26 15:01
 */
@RestController
@Slf4j
public class OrderController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping(value = "/consumer/payment/ok")
    public String getPaymentOk() {
        return paymentHystrixService.getPaymentOk();
    }

    @GetMapping(value = "/consumer/payment/error")
    public String getPaymentError() {
        return paymentHystrixService.getPaymentError();
    }
}
