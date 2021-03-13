package com.baidu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients //项目使用Feign 所有要开启注解并使用
public class OpenFeignApplication {

    public static void main(String[] args) {

        SpringApplication.run(OpenFeignApplication.class,args);
    }

}

