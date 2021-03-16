package com.baidu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApplicationOrder83 {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationOrder83.class,args);
    }
}
