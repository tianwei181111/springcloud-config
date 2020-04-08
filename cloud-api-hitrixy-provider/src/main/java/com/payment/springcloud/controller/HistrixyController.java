package com.payment.springcloud.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@Slf4j
@RequestMapping(value = "/histrixy")
public class HistrixyController {
    private final static AtomicInteger a = new AtomicInteger(0);
    @GetMapping(value = "/get/thread/info/{id}")
    public String  getThreadInfo(@PathVariable("id") Integer id){
        log.info("warn :{}",a.addAndGet(1));
        return "current thread is name " + Thread.currentThread().getName() +"payment id is " + id + "\t(●'◡'●)" + a;
    }
    @HystrixCommand(fallbackMethod = "getHisThreadInfoHandler",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    @GetMapping( value = "/get/thread/{id}")
    public String  getHisThreadInfo(@PathVariable("id") Integer id){
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "current thread is name " + Thread.currentThread().getName() +"payment id is " + id + "\t(●'◡'●)";
    }

    public String getHisThreadInfoHandler(Integer id){
        return "current thread is name " + Thread.currentThread().getName() +"payment id is "+"\t(●'◡'●)" + "超时";

    }



}
