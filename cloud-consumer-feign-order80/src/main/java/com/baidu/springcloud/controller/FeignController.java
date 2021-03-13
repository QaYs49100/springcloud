package com.baidu.springcloud.controller;

import com.baidu.springcloud.dto.CommontResult;
import com.baidu.springcloud.pojo.Payment;
import com.baidu.springcloud.service.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {

    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/{id}")
    public CommontResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return this.paymentFeignService.getPaymentById(id);
    }

    @GetMapping("/consumer/payment/timeout")
    public CommontResult<String> PaymentStatus() throws InterruptedException {

        String port = this.paymentFeignService.serverPort();
        CommontResult<String> commontResult = new CommontResult();
        commontResult.setCode(200);
        commontResult.setDesc("请求成功");
        commontResult.setData(port);
        return commontResult;
    }


}
