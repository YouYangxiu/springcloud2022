package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.entity.Payment;
import com.atguigu.springcloud.mapper.PaymentMapper;
import com.atguigu.springcloud.service.PaymentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
* @author youyangxiu
* @description 针对表【payment(支付表)】的数据库操作Service实现
* @createDate 2022-04-26 10:00:42
*/
@Service
public class PaymentServiceImpl extends ServiceImpl<PaymentMapper, Payment>
    implements PaymentService{

}




