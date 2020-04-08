package com.order.springcloud.controller;

import com.order.springcloud.fengn.OrderServerFeign;
import com.payment.springcloud.entites.CommonResult;
import com.payment.springcloud.entites.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
@Slf4j
public class OrderController{
//    public final static String PAYMENT = "http://CLOUD-PAYMENT-SERVICE";
//
//    @Autowired
//    private RestTemplate restTemplate;
    @Autowired
    OrderServerFeign orderServerFeign;

    @GetMapping(value = "/consumer/payment/create")
    public CommonResult<Payment> create(){
        Payment payment = new Payment();
        payment.setSerial("白牙彭是个牛逼的程序员");
//        return restTemplate.postForObject(PAYMENT+"/payment/create/info",payment,CommonResult.class);
        return null;
    }

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id")  Long id){
        return orderServerFeign.getPaymentInfo(id);
    }

    public static void main(String[] args) {
        int start = 0;
        int end = 0;
        Matcher matcher = Pattern.compile("hh").matcher("hhwhwhh");


        while(matcher.find()){
            System.out.println(matcher.start());
            System.out.println(matcher.end());
            System.out.println(matcher.group(0));
        }
    }

}
