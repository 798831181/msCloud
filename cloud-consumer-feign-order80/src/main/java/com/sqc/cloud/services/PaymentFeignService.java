package com.sqc.cloud.services;

import com.sqc.cloud.entity.CommonResult;
import com.sqc.cloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author sunqichao
 * @date 2020-03-25 11:53
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-PAYMENT")
public interface PaymentFeignService {
    /**
     * 根据id查询订单
     * @param id
     * @return
     */
    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable(value = "id") Long id);

    /**
     * 测试feign调用超时
     * @return
     */
    @GetMapping(value = "/payment/feign/timeout")
    String feignTimeout() ;
}
