package com.order.springcloud.myrule;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalances {

    ServiceInstance instances(List<ServiceInstance> serviceInstanceList);
}
