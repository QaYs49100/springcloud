package com.baidu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope //实时动态获取nacos中心的参数变化
public class ClientController {

    @Value("${config.info}")
    private String configInfo;

    @Value("${spring.profiles.active}")
    private String profile;

    @GetMapping("/configInfo")
    public String configInfo(){
        return "配置信息:"+this.configInfo+"环境:"+this.profile;
    }
}
