package com.order.springcloud.myrule;

import com.netflix.loadbalancer.IRule;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class RuleConfig {

    @Resource
    DiscoveryClient discoveryClient;
    @Bean
    @LoadBalanced
    public IRule getRandom(){
        return new MyLoadBalances();

    }
}
