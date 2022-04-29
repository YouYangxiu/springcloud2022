package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.commonutils.Result;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping("createPayment")
    public Result createPayment(@RequestBody Payment payment) {
        boolean result = paymentService.save(payment);
        System.out.println("端口号是：" + serverPort);
        return result ? Result.success().data("serverPort", serverPort) : Result.failure().data("serverPort", serverPort);
    }

    @GetMapping("getPaymentById/{id}")
    public Result getPaymentById(@PathVariable Long id) {
        Payment result = paymentService.getById(id);
        System.out.println("端口号是：" + serverPort);
        return Result.success().data("data", result).data("serverPort", serverPort);
    }

    @GetMapping("discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        services.forEach(service -> {
            System.out.println("我是service" + service);
        });
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        instances.forEach(instance -> {
            System.out.println("我是instance：" + instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        });
        return this.discoveryClient;
    }
}
