package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class paymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfoOk(Integer id) {
        return "paymentInfoOk的服务兜底";
    }

    @Override
    public String paymentInfoTimeout(Integer id) {
        return "paymentInfoTimeOut的兜底方法";
    }
}
