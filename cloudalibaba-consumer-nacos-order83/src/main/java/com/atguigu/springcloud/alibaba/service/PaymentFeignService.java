package com.atguigu.springcloud.alibaba.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "nacos-payment-provider")
public interface PaymentFeignService {
    @GetMapping("/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") String id);
}
