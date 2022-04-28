package com.atguigu.springcloud.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 支付表
 * @TableName payment
 */
@Data
public class Payment implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 支付流水号
     */
    private String serial;

    private static final long serialVersionUID = 1L;
}