package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.commonutils.Result;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;


    @PostMapping("createPayment")
    public Result createPayment(@RequestBody Payment payment) {
        boolean result = paymentService.save(payment);
        System.out.println("端口号是：" + serverPort);
        return result ? Result.success().data("serverPort",serverPort) : Result.failure().data("serverPort",serverPort);
    }
    @GetMapping("getPaymentById/{id}")
    public Result getPaymentById(@PathVariable Long id) {
        Payment result = paymentService.getById(id);
        System.out.println("端口号是：" + serverPort);
        return Result.success().data("data", result).data("serverPort",serverPort);
    }

    @GetMapping("loadBalance")
    public String getPaymentLoadBalance() {
        return serverPort;
    }
}
