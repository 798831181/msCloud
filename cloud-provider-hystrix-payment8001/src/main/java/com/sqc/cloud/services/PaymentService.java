package com.sqc.cloud.services;

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

    public String paymentError() {
        try {
            TimeUnit.MILLISECONDS.sleep(sleepTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "PaymentService.paymentError(): 支付失败，耗时（毫秒）： " + sleepTime;
    }
}
