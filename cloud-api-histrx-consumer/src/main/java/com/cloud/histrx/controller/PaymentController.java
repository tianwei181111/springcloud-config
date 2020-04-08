package com.cloud.histrx.controller;

import com.cloud.histrx.feign.PaymentFeign;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
@RequestMapping(value = "payment")
//@DefaultProperties(defaultFallback = "getHisT")
public class PaymentController {

    @Resource
    PaymentFeign paymentFeign;

    @GetMapping(value = "/consumer/thread/info/{id}")
    String  getThreadInfo(@PathVariable("id") Integer id){
        String threadInfo = paymentFeign.getThreadInfo(id);
        return threadInfo;
    }


    @GetMapping( value = "/get/thread/{id}")
//    @HystrixCommand
    String  getHisThreadInfo(@PathVariable("id") Integer id){
        String hisThreadInfo = paymentFeign.getHisThreadInfo(id);
//        int i = 10 / 0 ;
        return hisThreadInfo;
    }
    String  getHisT(){
        return "呵呵呵";
    }
}
