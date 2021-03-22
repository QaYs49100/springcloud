package com.baidu.springcloud.serivce;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService{

    @Override
    public void addInfo(String str,String... str1) {
        for (int i = 0; i < str1.length; i++) {
            log.info("新增一条数据:{}",str1[i]);
        }
        log.info("新增一条数据LOG");
    }

    @Override
    public void deleteInfo() {
        log.info("删除一条数据");
        //int num = 1/0;
        //异常之后不会执行after-Returning切面类方法
    }

    @Override
    public void updateInfo() {
        log.info("修改一条数据");
    }

    @Override
    public void selectInfo() {
        log.info("查询一条数据");
        //int num = 1/0;
        //异常之后不会执行after切面类方法
    }

    @Override
    public void exception() {
        log.info("异常信息exception");
        //int num = 1/0;
    }

    @Override
    public void around() {
        log.info("连接点:around");
    }
}
