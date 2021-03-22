package com.baidu.springcloud.controller;

import com.baidu.springcloud.dto.CommontResult;
import com.baidu.springcloud.dot.Payment;
import com.baidu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @PostMapping(value = "/payment/create")
    public CommontResult create(@RequestBody Payment payment){

        int result = this.paymentService.create(payment);
        log.info("8001查看信息"+payment.toString());
        if(result > 0){
           return new CommontResult(200,"插入成功,端口号:"+port,result);
        }
        return new CommontResult(400,"插入失败");
    }

    @GetMapping("/payment/getPaymentById")
    public CommontResult<Payment> getPaymentById1(@RequestParam(name = "id") Long id){

        Payment payment = this.paymentService.getPaymentById(id);
        log.info("Payment"+payment);
        if(payment !=null){
            return new CommontResult(200,"查询成功8001,端口号:"+port,payment);
        }
        return new CommontResult(400,"查询失败");
    }

    @GetMapping("/payment/getPaymentById/{id}")
    public CommontResult<Payment> getPaymentById(@PathVariable("id") Long id){

        Payment payment = this.paymentService.getPaymentById(id);
        log.info("Payment"+payment);
        if(payment !=null){
            return new CommontResult(200,"查询成功8002,端口号:"+port,payment);
        }
        return new CommontResult(400,"查询失败");
    }
}
