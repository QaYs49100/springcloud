package com.baidu.springcloud.servcie;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//接口➕注解的方式
@Service
@FeignClient(value = "cloud-provider-hystrix-payment",fallback = FallBackPaymentHystrixService.class)
public interface PaymentHystrixService {
    //当前服务调用远程服务接口失败降价操作
    @GetMapping("/payment/hystrix/success/{id}")
    String paymentSuccess(@PathVariable("id") Long id);

    @GetMapping("/payment/hystrix/timeout/{id}")
    String paymentError(@PathVariable("id") Long id) throws InterruptedException;
}
