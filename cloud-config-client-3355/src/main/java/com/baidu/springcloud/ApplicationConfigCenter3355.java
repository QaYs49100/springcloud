package com.baidu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient //开启客户端注解
public class ApplicationConfigCenter3355 {

    public static void main(String[] args) {

        SpringApplication.run(ApplicationConfigCenter3355.class,args);
    }
}
