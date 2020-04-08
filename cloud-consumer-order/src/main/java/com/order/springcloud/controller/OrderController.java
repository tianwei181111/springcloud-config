package com.order.springcloud.controller;

import com.payment.springcloud.entites.CommonResult;
import com.payment.springcloud.entites.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
public class OrderController{
    public final static String PAYMENT = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> create(){
        Payment payment = new Payment();
        payment.setSerial("白牙彭是个牛逼的程序员");
        return restTemplate.postForObject(PAYMENT+"/payment/create/info",payment,CommonResult.class);
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id")  Long id){
        return restTemplate.getForObject(PAYMENT+"/payment/get/info/"+id,CommonResult.class);
    }

}
