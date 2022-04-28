package com.atguigu.springcloud.commonutils;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Result {
    private boolean success;
    private String message;
    private Integer code;
    private Map<String, Object> data = new HashMap<>();

    //私有化构造器
    private Result() {
    }

    //成功的静态方法
    public static Result success() {
        Result result = new Result();
        result.setSuccess(true);
        result.setCode(ResultCode.SUCCESS.getCode());
        result.setMessage("成功！");
        return result;
    }

    //失败的静态方法
    public static Result failure() {
        Result result = new Result();
        result.setSuccess(false);
        result.setCode(ResultCode.ERROR.getCode());
        result.setMessage("失败！");
        return result;
    }

    //开启链式编程
    public Result success(boolean success) {
        this.setSuccess(success);
        return this;
    }

    public Result message(String message){
        this.setMessage(message);
        return this;
    }

    public Result code(Integer code){
        this.setCode(code);
        return this;
    }

    public Result data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public Result data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }
}

