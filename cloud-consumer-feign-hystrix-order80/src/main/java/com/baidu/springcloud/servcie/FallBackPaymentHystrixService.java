package com.baidu.springcloud.servcie;

import org.springframework.stereotype.Component;

@Component
public class FallBackPaymentHystrixService  implements PaymentHystrixService{

    //当前类属于异常处理类
    @Override
    public String paymentSuccess(Long id) {
        return "异常处理成功success";
    }

    @Override
    public String paymentError(Long id) throws InterruptedException {
        return "异常处理失败Error";
    }

}
