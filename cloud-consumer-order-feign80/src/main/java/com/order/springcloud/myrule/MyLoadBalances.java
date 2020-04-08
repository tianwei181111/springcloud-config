package com.order.springcloud.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class MyLoadBalances extends AbstractLoadBalancerRule {

    private final static AtomicInteger integer = new AtomicInteger(0);


    

    public Server getServer(ILoadBalancer lb){
        //获取服务实例
        List<Server> allServers = lb.getAllServers();
        List<Server> reachableServers = lb.getReachableServers();
        if(reachableServers ==null&&allServers ==null){
            return null;
        }else {
            int count = integer.get();
            int next ;
            do{
                next = (int)(Math.random()*(reachableServers.size()));

            } while (!this.integer.compareAndSet(count,next));
            return reachableServers.get(integer.get());
        }
    }

    @Override
    public Server choose(Object key) {
        return getServer(getLoadBalancer());
    }
    
    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

}
