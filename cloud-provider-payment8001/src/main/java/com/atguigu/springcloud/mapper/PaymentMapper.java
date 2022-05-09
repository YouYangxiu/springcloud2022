package com.atguigu.springcloud.mapper;

import com.atguigu.springcloud.entity.Payment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author youyangxiu
* @description 针对表【payment(支付表)】的数据库操作Mapper
* @createDate 2022-04-26 10:00:42
* @Entity com.atguigu.springcloud.entity.Payment
*/
@Mapper
public interface PaymentMapper extends BaseMapper<Payment> {

}




