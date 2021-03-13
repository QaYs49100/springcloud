package com.baidu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard //开启图形化界面
public class ConsumerHystrixDashboard9001 {

    public static void main(String[] args) {

        SpringApplication.run(ConsumerHystrixDashboard9001.class,args);
    }


}

