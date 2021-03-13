package com.baidu.springcloud.service.serviceimpl;

import com.baidu.springcloud.dao.PaymentDao;
import com.baidu.springcloud.pojo.Payment;
import com.baidu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl  implements PaymentService {

    //@Autowired //spring的注解
    @Resource  //JDK 自带的注入注解
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {

        return paymentDao.getPaymentById(id);
    }


}
