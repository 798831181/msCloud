package com.sqc.cloud.services;

import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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

    @HystrixCommand(fallbackMethod = "paymentErrorHandler", commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")})
    public String paymentError() {
        try {
            TimeUnit.MILLISECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "PaymentService.paymentError(): 支付失败，耗时（毫秒）： " + sleepTime;
    }

    public String paymentErrorHandler() {
        return "调用支付接口失败，thread: " + Thread.currentThread().getName();
    }

    /**
     * 测试熔断
     *
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback",
            commandProperties = {
                    @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
                    @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
                    @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
                    @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60")
            })
    public String paymentCircuitBreaker(Long id) {
        if (id < 0) {
            throw new RuntimeException("id can not less than zero");
        }
        String serialNum = IdUtil.simpleUUID();
        return Thread.currentThread().getName() + "调用成功, 流水号： " + serialNum;
    }

    public String paymentCircuitBreakerFallback(Long id) {
        return "id can not less than zero! current id = " + id;
    }
}
