package com.sqc.cloud.controller;

import com.sqc.cloud.entity.CommonResult;
import com.sqc.cloud.entity.Payment;
import com.sqc.cloud.services.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sunqichao
 * @date 2020-03-25 11:47
 */
@RestController
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable(value = "id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }
}
