package com.baidu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient //用于服务的发现注册到nacos服务中心
public class CloudAlibabaApplication9002 {

    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaApplication9002.class,args);
    }
}
