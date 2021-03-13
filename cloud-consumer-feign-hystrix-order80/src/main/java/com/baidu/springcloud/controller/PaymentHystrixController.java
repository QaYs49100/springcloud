package com.baidu.springcloud.controller;

import com.baidu.springcloud.servcie.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@DefaultProperties(defaultFallback= "paymentErrorTimeoutFallBackAll") // 服务降级指定默认的方法名
public class PaymentHystrixController {

    @Autowired
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/success/{id}")
    public String paymentSuccess(@PathVariable("id") Long id){

        return this.paymentHystrixService.paymentSuccess(id);
    }

//    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    public String paymentError(@PathVariable("id") Long id) throws InterruptedException{
//
//        return this.paymentHystrixService.paymentError(id);
//    }


    //当前服务如果出现服务一场就会跳转到指定到服务名方法进行服务到降级
//    @HystrixCommand(fallbackMethod ="paymentErrorTimeoutFallBack",
//            commandProperties = {
//                    //表示当前到服务降级确保在3秒以内，超出3秒走降级服务到地址
//                    //当前线程的时间不可以大于指定的时间 value = "3000"
//                    //服务的方法内报错也会今进行服务的降级
//                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
//            })
    //如果档期拿到客户端去访问一个地址服务响应时间大于指定的时间就会走降级的方法
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    @HystrixCommand(fallbackMethod = "paymentErrorTimeoutFallBackAll")
    public String paymentError(@PathVariable("id") Long id) throws InterruptedException {
        int num = 10/0;
      return this.paymentHystrixService.paymentError(id);
    }

    public String paymentErrorTimeoutFallBack(Long id) throws InterruptedException {

        return "80服务启动，对方消费系统繁忙10分钟重试。:"+Thread.currentThread().getName()+ id+"😊";
    }

    //全局服务服务降价指定默认方法

    public String paymentErrorTimeoutFallBackAll(Long id) throws InterruptedException {

        return "80服务启,服务降价操作@HystrixCommand:"+Thread.currentThread().getName()+ id;
    }




}
