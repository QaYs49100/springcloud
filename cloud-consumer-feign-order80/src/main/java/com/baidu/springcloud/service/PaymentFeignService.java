package com.baidu.springcloud.service;

import com.baidu.springcloud.dto.CommontResult;
import com.baidu.springcloud.dot.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(value = "CLOUD-PAYMENT-SERVICE") //请求响应时间默认1秒超时
public interface PaymentFeignService {

    //找到对应服务的名称和调用的接口服务
    @GetMapping("/payment/getPaymentById/{id}")
    CommontResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/payment/timeout")
    String serverPort() throws InterruptedException;
}
