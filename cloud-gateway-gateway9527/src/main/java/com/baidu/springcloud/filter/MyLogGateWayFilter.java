package com.baidu.springcloud.filter;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

@Component
@Slf4j
public class MyLogGateWayFilter implements GlobalFilter, Ordered {
    //GateWay自定义Filter过滤器
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

      log.info("com in MyLogGateWayFilter：{}",new Date());
      //获取参数:
        String username = exchange.getRequest().getQueryParams().getFirst("id");//请求当中必须带有指定的参数名才可以访问
        if(StrUtil.isEmpty(username)){
            //用户名为空设置
            log.info("用户名不能为空:{}",username);
            //响应信息
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();//完成设置返回信息
        }
        return chain.filter(exchange);   //执行链放行Filter
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
