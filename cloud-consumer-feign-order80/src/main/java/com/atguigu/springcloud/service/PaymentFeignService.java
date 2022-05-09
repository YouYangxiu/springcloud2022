package com.atguigu.springcloud.service;

import com.atguigu.springcloud.commonutils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {
    @GetMapping("payment/getPaymentById/{id}")
    public Result getPaymentById(@PathVariable("id") Long id);

    @GetMapping("payment/timeout")
    public String paymentFeignTimeout();
}
