package com.sqc.cloud.controller;

import com.sqc.cloud.services.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sunqichao
 * @date 2020-03-26 13:43
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/payment/ok")
    public String getPaymentOk() {
        return paymentService.paymentOk();
    }

    @GetMapping(value = "/payment/error")
    public String getPaymentError() {
        return paymentService.paymentError();
    }

}
