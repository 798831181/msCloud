package com.sqc.cloud.lb;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author sunqichao
 * @date 2020-03-23 20:28
 */
@Component
@Slf4j
public class MyLB implements LoadBalance {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            if (current >= Integer.MAX_VALUE) {
                next = 0;
            } else {
                next = current + 1;
            }

        } while (!atomicInteger.compareAndSet(current, next));

        log.info("第几次访问，next: " + next);
        return next;

    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement()% serviceInstances.size();
        return serviceInstances.get(index);
    }
}
