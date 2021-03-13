package com.baidu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean       //定义日志级别
    public Logger.Level feignLoggerLevel(){

        return Logger.Level.FULL; //详细日志
    }

}
