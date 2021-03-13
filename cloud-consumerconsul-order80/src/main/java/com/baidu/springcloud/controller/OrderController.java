package com.baidu.springcloud.controller;

import com.baidu.springcloud.dto.CommontResult;
import com.baidu.springcloud.pojo.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j //日志注解
public class OrderController {
    //当前的服务调用远程的服务地址返回数据
    //private static final String PAYMENT_URL ="http://localhost:8001";
    //通过为服务的名称实现负载均衡
    private static final String PAYMENT_URL ="http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping(value = "/consumer/payment/create",consumes = "application/json",produces = "application/json")
    public CommontResult<Payment> create( @RequestBody Payment payment){
    log.info("查看信息:{}",payment.toString());
        return restTemplate.postForObject(PAYMENT_URL+"/payment/create",payment,CommontResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommontResult<Payment> getPayment(@PathVariable("id") Long id){

        return  restTemplate.getForObject(PAYMENT_URL + "/payment/getPaymentById/" + id, CommontResult.class);

    }
    @GetMapping("/consumer/entity/get/{id}")
    public CommontResult getEntity(@PathVariable("id") Long id){

        ResponseEntity<CommontResult> forEntity =
                restTemplate.getForEntity(PAYMENT_URL + "/payment/getPaymentById/" + id, CommontResult.class);
        if(forEntity.getStatusCode().is2xxSuccessful()){

            log.info("信息查看:{}",forEntity.getStatusCode());
            log.info("信息查看:{}",forEntity.getStatusCodeValue());
            log.info("信息查看:{}",forEntity.getHeaders());
            log.info("信息查看:{}",forEntity.getBody());
            return forEntity.getBody();
        }

        return new CommontResult(400,"获取失败");
    }

}
