package com.baidu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @Value("{server.port}")
    private String port;

    @RequestMapping("/payment/nacos/{id}")
    public String getPayment(@PathVariable(value = "id") long id){

        return "nacosServer1 port:"+port+"接收的值是:"+id;
    }

}
