package com.baidu.springcloud.dto;


public class CommontResult<T> {

    private Integer code;
    private String desc;
    private    T   data;

    public CommontResult() {
    }

    public CommontResult(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
        this.data = null;
    }

    public CommontResult(Integer code, String desc, T data) {
        this.code = code;
        this.desc = desc;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}


