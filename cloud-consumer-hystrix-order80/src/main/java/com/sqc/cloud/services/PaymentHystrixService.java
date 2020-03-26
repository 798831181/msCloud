package com.sqc.cloud.services;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author sunqichao
 * @date 2020-03-26 15:03
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT")
public interface PaymentHystrixService {
    /**
     * 成功支付
     * @return
     */
    @GetMapping(value = "/payment/ok")
    String getPaymentOk();

    /**
     * 支付失败
     * @return
     */
    @GetMapping(value = "/payment/error")
    String getPaymentError();
}
