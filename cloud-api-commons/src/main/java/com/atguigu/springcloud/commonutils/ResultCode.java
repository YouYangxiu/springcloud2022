package com.atguigu.springcloud.commonutils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {
    SUCCESS(200),
    ERROR(400);
    private Integer code;

}
