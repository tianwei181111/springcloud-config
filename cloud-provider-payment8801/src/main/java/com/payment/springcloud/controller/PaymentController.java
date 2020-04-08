package com.payment.springcloud.controller;

import com.payment.springcloud.entites.CommonResult;
import com.payment.springcloud.entites.Payment;
import com.payment.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "/payment")
public class PaymentController {

//    @Autowired
//    PaymentService paymentService;

    @Value("${server.port}")
    String port;

    @Resource
    DiscoveryClient discoveryClient;

    @PostMapping(value = "/create/info")
    public CommonResult<CommonResult> createPaymentInfo(@RequestBody Payment payment){
        int paymentInfo =0;
//        int paymentInfo = paymentService.createPaymentInfo(payment);
        if(paymentInfo !=0){
            return new CommonResult(200,"白牙彭成功晋级为一个牛逼的程序员"+"端口号"+port,paymentInfo);
        }
        return new CommonResult(404,"白牙彭在网络编程世界中成为第一个被劝退的程序员"+"端口号"+port);
    }


    @GetMapping(value = "/get/info/{id}")
    public CommonResult getPaymentInfo(@PathVariable("id") Long id,@RequestHeader(value = "Authout",required = true)String Authout){
//        Payment paymentInfo = paymentService.getPaymentInfo(id);
        int paymentInfo =0;
        log.info("RequestHeader is ############################## :{}",Authout);
        if(paymentInfo != 1){
            return new CommonResult(200,"白牙彭成功在程序员的世界中找到了自己应该有的价值"+"端口号"+port,paymentInfo);
        }
        return new CommonResult(404,"白牙彭在网络编程世界中丧失了自己成为一个得过且过的行尸走肉"+"端口号"+port,paymentInfo);
    }

    @GetMapping(value = "/discovery")
    public Object getDiscovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("*******element"+service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }

        return this.discoveryClient;
    }
}
