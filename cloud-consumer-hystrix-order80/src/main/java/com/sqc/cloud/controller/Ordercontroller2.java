package com.sqc.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sqc.cloud.services.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author sunqichao
 * @date 2020-03-26 16:57
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "globalFallback")
public class Ordercontroller2 {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping(value = "/consumer/payment/global/error")
    @HystrixCommand
    public String getPaymentGlobalError() {
        return paymentHystrixService.getPaymentError();
    }
    public String paymentTimeOutFallbackMethod() {
        return "我是消费者80,对方支付系统繁忙请10秒种后再试或者自己运行出错请检查自己,o(╥﹏╥)o";
    }
    public String globalFallback(){
        return "global fallback: 系统超时或异常";
    }
}
