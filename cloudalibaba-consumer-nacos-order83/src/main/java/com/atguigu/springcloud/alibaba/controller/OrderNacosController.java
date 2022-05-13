package com.atguigu.springcloud.alibaba.controller;

import com.atguigu.springcloud.alibaba.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderNacosController {
    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("nacos/{id}")
    public String getPayment(@PathVariable String id) {
        String payment = paymentFeignService.getPayment(id);
        return payment;
    }
}
