package com.sqc.cloud.services.impl;

import com.sqc.cloud.services.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @author sunqichao
 * @date 2020-03-26 17:08
 */
@Component
public class PaymentGlobalFallback implements PaymentHystrixService {
    @Override
    public String getPaymentOk() {
        return "PaymentGlobalFallback.getPaymentOk() 服务繁忙";
    }

    @Override
    public String getPaymentError() {
        return "PaymentGlobalFallback.getPaymentError() 服务繁忙";
    }
}
