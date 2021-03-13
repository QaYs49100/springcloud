package com.baidu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySelfRule {
    //自定义客户端的负载均衡策略，不能被@ComponentScan()注解同包及子包下使用

    @Bean
    public IRule iRule(){
        //自定义随机策略
        return  new RandomRule();
    }

}
