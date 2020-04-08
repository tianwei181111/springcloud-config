package com.order.springcloud.fengn;


import com.payment.springcloud.entites.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface OrderServerFeign {

    @GetMapping(value = "/payment/get/info/{id}")
    CommonResult getPaymentInfo(@PathVariable("id") Long id);

}
