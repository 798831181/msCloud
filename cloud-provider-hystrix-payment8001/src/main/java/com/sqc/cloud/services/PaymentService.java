package com.sqc.cloud.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author sunqichao
 * @date 2020-03-26 13:38
 */
@Service
public class PaymentService {
    private Long sleepTime = 5000L;

    public String paymentOk() {
        return "PaymentService.paymentOK(): 成功支付";
    }

    @HystrixCommand(fallbackMethod = "paymentErrorHandler",commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")})
    public String paymentError() {
        try {
            TimeUnit.MILLISECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "PaymentService.paymentError(): 支付失败，耗时（毫秒）： " + sleepTime;
    }

    public String paymentErrorHandler(){
        return "调用支付接口失败，thread: " + Thread.currentThread().getName();
    }
}
