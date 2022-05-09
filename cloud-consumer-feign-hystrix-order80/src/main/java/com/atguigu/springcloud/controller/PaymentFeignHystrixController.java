package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("order/hystrix")
@DefaultProperties(defaultFallback = "commonFallback")
public class PaymentFeignHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("ok/{id}")
    public String paymentInfoOk(@PathVariable Integer id) {
        return paymentHystrixService.paymentInfoOk(id);
    }

    @GetMapping("timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentTimeoutFallbackMethod", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
//    })
    @HystrixCommand
    public String paymentInfoTimeout(@PathVariable Integer id) {
        int a = 10 / 0;
        return paymentHystrixService.paymentInfoTimeout(id);
    }

    public String paymentTimeoutFallbackMethod(Integer id) {
        return "我是消费者80，对方支付系统繁忙请10秒钟之后再尝试或者您的网络有问题请自查😭";
    }

    //统一兜底方法
    public String commonFallback() {
        return "调用了全局异常处理";
    }
}
