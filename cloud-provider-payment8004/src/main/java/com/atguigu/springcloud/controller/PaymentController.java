package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.util.UUID.randomUUID;

@RestController
@RequestMapping("payment")
public class PaymentController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("zookeeper")
    public String paymentZookeeper() {
        return "SpringCloud with zookeeper:" + serverPort + "\t" + randomUUID().toString();
    }
}
