package com.sqc.cloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author sunqichao
 * @date 2020-03-23 20:26
 */
public interface LoadBalance {
    /**
     * 获得所有服务实例
     * @param serviceInstances
     * @return
     */
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
