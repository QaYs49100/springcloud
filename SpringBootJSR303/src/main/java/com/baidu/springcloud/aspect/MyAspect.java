package com.baidu.springcloud.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class MyAspect {

    /**
     *  表达式: 方法访问修饰符  返回值  包名.类名.方法名(方法的参数)
     *
     *  方法访问修饰符:可以省略
     *  返回值类型: 返回值不确定的时候可以 使用 * 号来代替
     *  包名可以用 * 号 代替
     *  *..* 代表包及子包任意包下
     *  方法名也可以用 * 号,也可以模糊匹配 前缀 或 后缀
     *  方法参数可以根据方法的参数类型来确定,只需传入对应的数据类型，也可以用    '..' 两个点来表示多个任意参数
     *
     */

    //切面类
    //用于增强的代码
    //@Before("execution(public void com.baidu.springcloud.serivce.OrderServiceImpl.addInfo())") //完整写法
    //@Before("execution(void com.baidu.springcloud.serivce.OrderServiceImpl.addInfo())") //修饰符可以省略
    //方法之前执行
    @Before("execution(* *..*.OrderServiceImpl.*Info(String,String...))")  //任意包下及子包下的OrderServiceImpl.addInfo()方法  ->   *..*
    public void before(){

      log.info("方法增强");

    }
    //后置通知方法之后
    //在方法之后进行通知,如果通知的方法出现异常增强的方法就不会运行
    @AfterReturning("execution(public void com.baidu.springcloud.serivce.OrderServiceImpl.deleteInfo())")
    public void afterReturning(){
        log.info("AfterReturning后面的通知");
    }

    //方法之后进行增强,无论方法中是否有异常最终都会执行切面的方法
    @After("execution(public void com.baidu.springcloud.serivce.OrderServiceImpl.selectInfo())")
    public void after(){
        log.info("after后面的通知");
    }

    //AfterThrowing 只有在目标方法发生异常才会执行切面类方法
    @AfterThrowing("execution(public void com.baidu.springcloud.serivce.OrderServiceImpl.exception())")
    public void exp(){
        log.info("AfterThrowing异常切面类使用");
    }

    //环绕通知,围绕连接点进行通知,需要参数ProceedingJoinPoint 做消息的前后传递
    @Around("execution(public void com.baidu.springcloud.serivce.OrderServiceImpl.around())")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("环绕前置通知");
        Object proceed = joinPoint.proceed();
        log.info("环绕前置通知");
        return proceed;
    }

}
