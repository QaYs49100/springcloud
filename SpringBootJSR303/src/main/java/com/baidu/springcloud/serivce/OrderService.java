package com.baidu.springcloud.serivce;

public interface OrderService {

    void addInfo(String str,String... str1 );
    void deleteInfo();
    void updateInfo();
    void selectInfo();

    void exception();
    void around();
}
