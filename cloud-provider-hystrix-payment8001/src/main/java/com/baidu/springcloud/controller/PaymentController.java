package com.baidu.springcloud.controller;

import com.baidu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String prot;

    @GetMapping("/payment/hystrix/success/{id}")
    public String paymentSuccess(@PathVariable("id") Long id){
        String result = this.paymentService.paymentSuccess(id);
        log.info("查看信息:{}",result);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentError(@PathVariable("id") Long id) throws InterruptedException {
        String result = this.paymentService.paymentError(id);
        log.info("查看信息:{}",result);
        return result;
    }

    //====服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id)
    {
        String result = this.paymentService.paymentCircuitBreaker(id);
        log.info("****result: "+result);
        return result;
    }

}
