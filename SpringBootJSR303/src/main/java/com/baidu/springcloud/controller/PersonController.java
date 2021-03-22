package com.baidu.springcloud.controller;

import com.baidu.springcloud.dot.Person;
import com.baidu.springcloud.serivce.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
public class PersonController {

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/message",consumes = {"application/json"},produces = {"application/json"})
    public String Message(@Valid @RequestBody Person person, BindingResult bindingResult){
        log.info("查看person:{}",person);
        if(bindingResult.hasErrors()){
            //获取所有一场信息
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            fieldErrors.forEach(fieldError -> {
                log.info("{}:{}",fieldError.getField(),fieldError.getDefaultMessage());
            });
            return "失败";
        }
        log.info("------分隔符-------");
        this.orderService.addInfo("张三","1","2323","343434","asdfhkjgcvcxvxc");

        log.info("------分隔符-------");
        this.orderService.deleteInfo();

        log.info("------分隔符-------");
        this.orderService.selectInfo();

        log.info("------分隔符-------");
        this.orderService.updateInfo();

        log.info("------分隔符-------");
        this.orderService.exception();

        log.info("------分隔符-------");
        this.orderService.around();
        return "成功";
    }

}
