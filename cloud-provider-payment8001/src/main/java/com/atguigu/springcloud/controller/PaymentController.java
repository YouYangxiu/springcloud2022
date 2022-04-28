package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.commonutils.Result;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @PostMapping("createPayment")
    public Result createPayment(@RequestBody Payment payment) {
        boolean result = paymentService.save(payment);
        return result ? Result.success() : Result.failure();
    }
    @GetMapping("getPaymentById/{id}")
    public Result getPaymentById(@PathVariable Long id) {
        Payment result = paymentService.getById(id);
        return Result.success().data("data", result);
    }
}
