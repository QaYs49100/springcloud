package com.baidu.springcloud.controller;

import com.baidu.springcloud.dto.CommontResult;
import com.baidu.springcloud.pojo.Payment;
import com.baidu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.MediaType;
import java.util.List;

@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create",
            consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public CommontResult create(@RequestBody Payment payment){

        int result = this.paymentService.create(payment);
        log.info("8001查看信息"+payment.toString());
        if(result > 0){
           return new CommontResult(200,"插入成功,端口号:"+port,result);
        }
        return new CommontResult(400,"插入失败");
    }


    @GetMapping("/payment/getPaymentById/{id}")
    public CommontResult<Payment> getPaymentById(@PathVariable("id") Long id){

        Payment payment = this.paymentService.getPaymentById(id);
        log.info("Payment"+payment);
        if(payment !=null){
            return new CommontResult(200,"查询成功8001,端口号:"+port,payment);
        }
        return new CommontResult(400,"查询失败");
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

    @GetMapping("/getDiscovery")
    public Object discovery(){
        //获取所有注册到eureka中心的服务
        List<String> services = this.discoveryClient.getServices();
        for (String service: services) {
            log.info("service信息:{}",service);
        }
        //获取服务的详细信息
        List<ServiceInstance> instances 
                = this.discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance serviceInstance:instances) {
           log.info("获取service_id:{}", serviceInstance.getServiceId());
           log.info("获取getInstanceId:{}",serviceInstance.getInstanceId()); //获取服务别名
            log.info("获取获取服务地址:{}",serviceInstance.getHost()); //获取地址
            log.info("获取端口号:{}",serviceInstance.getPort()); //获取端口号
            log.info("获取服务地址:{}",serviceInstance.getUri());  //获取服务的全路径地址
        }
        return  this.discoveryClient;
    }

    @GetMapping("/payment/timeout")
    public String serverPort() throws InterruptedException {
        Thread.sleep(3000);
        return port;
    }


}
