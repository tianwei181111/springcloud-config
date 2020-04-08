package com.payment.springcloud.Controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PaymentController {

    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "/payment/zk")
    public  String paymentZk(){

        return "Spring with zookeeper is :" + port +"\t" + UUID.randomUUID().toString();

    }

}
