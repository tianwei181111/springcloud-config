package com.cloud.histrx.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Component
@FeignClient(value ="PROVIDER-HITRIXY",fallback = PaymentFeignServiceImpl.class)
public interface PaymentFeign {

    @GetMapping(value = "/histrixy/get/thread/info/{id}")
    String  getThreadInfo(@PathVariable("id") Integer id);

    @GetMapping( value = "/histrixy/get/thread/{id}")
    String  getHisThreadInfo(@PathVariable("id") Integer id);
}
@Component
class PaymentFeignServiceImpl implements PaymentFeign{

    @Override
    public String getThreadInfo(Integer id) {
        return "我是你哥666";
    }

    @Override
    public String getHisThreadInfo(Integer id) {
        return "我是你哥777";
    }
}
