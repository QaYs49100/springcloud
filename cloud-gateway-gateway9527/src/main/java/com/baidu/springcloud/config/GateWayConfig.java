package com.baidu.springcloud.config;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {

    //GateWay自定义路由配置 Bean配置的方式
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder routeLocatorBuilder){

        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        //该为一个路由配置      路由转发到指定的uri地址
        routes.route("path_rote_001",
                r -> r.path("/ent") //添加斜杠 网站的后缀名
                        .uri("http://news.baidu.com/ent")).build();//路由转发到百度
        return routes.build();
    }

        @Bean
        public RouteLocator routeLocator1(RouteLocatorBuilder routeLocatorBuilder){
            RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
            routes.route("232323",predicateSpec -> predicateSpec.path("/internet")
                    .uri("http://news.baidu.com/internet"));

            return routes.build();
        }


//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
//
//        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
//        routes.route("path_route_atguigu",
//                r -> r.path("/guonei")
//                        .uri("http://news.baidu.com/guonei")).build();
//        return routes.build();
//    }


}
