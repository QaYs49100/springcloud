package com.baidu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer  //Eureka 服务端开启服务端注解
public class EurekaApplicationServer7002 {

    public static void main(String[] args) {

        SpringApplication.run(EurekaApplicationServer7002.class,args);
    }

}
