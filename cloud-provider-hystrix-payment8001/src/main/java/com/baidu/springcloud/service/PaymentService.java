package com.baidu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class PaymentService {

    public String paymentSuccess(Long id){

        return "线程池success:"+Thread.currentThread().getName()+ id;
    }

    //当前服务如果出现服务一场就会跳转到指定到服务名方法进行服务到降级
    @HystrixCommand(fallbackMethod ="paymentErrorFallBack",
            commandProperties = {
            //表示当前到服务降级确保在3秒以内，超出3秒走降级服务到地址
                    //当前线程的时间不可以大于指定的时间 value = "3000"
                    //服务的方法内报错也会今进行服务的降级
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
            })
    public String paymentError(Long id) throws InterruptedException {

        //Thread.sleep(1000);
       //int num = 10/0;
        return "线程池Error:"+Thread.currentThread().getName()+ id+"耗时3S";
    }

    public String paymentErrorFallBack(Long id) throws InterruptedException {

        return "线程池Error服务降级方法:"+Thread.currentThread().getName()+ id+"😊";
    }


    //=====服务熔断
    //设置错误lv
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"),// 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id)
    {
        if(id < 0)
        {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id)
    {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }


}
