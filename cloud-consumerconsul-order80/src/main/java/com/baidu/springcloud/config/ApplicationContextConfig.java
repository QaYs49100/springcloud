package com.baidu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {


    @Bean
    @LoadBalanced //赋予 RestTemplate 对服务对负载均衡特性(默认轮训)
    public RestTemplate restTemplate(){

        return  new RestTemplate();
    }

}
