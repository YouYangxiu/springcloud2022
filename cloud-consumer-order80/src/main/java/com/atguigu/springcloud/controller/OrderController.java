package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.commonutils.Result;
import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.lb.LoadBalance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    //    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    //使用我们自己的负载均衡
    @Resource
    private LoadBalance loadBalance;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("createPayment")
    public Result createPayment(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/createPayment", payment, Result.class);
    }

    @GetMapping("getPaymentById/{id}")
    public Result getPaymentById(@PathVariable Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/getPaymentById/" + id, Result.class);
    }

    @GetMapping("getPaymentEntity/{id}")
    public Result getPaymentEntity(@PathVariable Long id) {
//        return restTemplate.getForObject(PAYMENT_URL + "/payment/getPaymentById/" + id, Result.class);
        ResponseEntity<Result> entity = restTemplate.getForEntity(PAYMENT_URL + "/payment/getPaymentById/" + id, Result.class);
        if (entity.getStatusCode().is2xxSuccessful()) {
            return entity.getBody();
        } else {
            return Result.failure().data("error", "400");
        }
    }

    @GetMapping("loadBalance")
    public String getPaymentLoadBalance() throws Exception {
        List<ServiceInstance> services = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (services == null || services.size() <= 0) {
            throw new Exception("无可用服务！");
        }
        ServiceInstance instance = loadBalance.instances(services);
        URI uri = instance.getUri();
        return restTemplate.getForObject(uri + "/payment/loadBalance", String.class);
    }
}
