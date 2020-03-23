package com.sqc.cloud.service;

import com.sqc.cloud.entity.Payment;

/**
 * @author sqc
 */
public interface PaymentService {
    /**
     * 新增账单
     * @param payment
     * @return
     */
    int create(Payment payment);

    /**
     * 根据id查询账单
     * @param id
     * @return
     */
    Payment getPaymentById(Long id);

}
