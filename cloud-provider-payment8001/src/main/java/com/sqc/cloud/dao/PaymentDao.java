package com.sqc.cloud.dao;

import com.sqc.cloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author sqc
 */
@Mapper
public interface PaymentDao {
    /**
     * 新建订单
     * @param payment
     * @return
     */
    int create(Payment payment);

    /**
     * 根据id查询订单
     * @param id
     * @return
     */
    Payment getPaymentById(@Param("id") Long id);
}
