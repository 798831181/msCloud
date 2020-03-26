package com.sqc.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })
    public String getPaymentError() {
        return paymentHystrixService.getPaymentError();
    }
    public String paymentTimeOutFallbackMethod() {
        return "我是消费者80,对方支付系统繁忙请10秒种后再试或者自己运行出错请检查自己,o(╥﹏╥)o";
    }
}
