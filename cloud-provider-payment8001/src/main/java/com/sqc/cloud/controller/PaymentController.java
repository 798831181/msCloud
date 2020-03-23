package com.sqc.cloud.controller;

import com.netflix.appinfo.InstanceInfo;
import com.sqc.cloud.entity.CommonResult;
import com.sqc.cloud.entity.Payment;
import com.sqc.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sqc
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("新增订单： " + payment.toString());
        if (result > 0) {
            return new CommonResult(200, "新增成功,port: " + port, result);
        } else {
            return new CommonResult(444, "新增失败", null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable(value = "id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("getPaymentById: id[]" + id);
        if (payment != null) {
            return new CommonResult(200, "查询成功, port: " + port, payment);
        } else {
            return new CommonResult(444, "查询失败", null);
        }
    }

    @GetMapping(value = "/payment/discover")
    public Object discover() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service: " + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PROVIDER-PAYMENT");

        for (ServiceInstance instance : instances) {
            log.info("id: " + instance.getInstanceId() + " host: " + instance.getHost() + " port: " + instance.getPort());
        }
        return this.discoveryClient;
    }
}
