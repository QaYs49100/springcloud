package com.baidu.springcloud.controller;

import com.baidu.springcloud.exception.JsonException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class BaseController {
    @ResponseBody
    @ExceptionHandler
    public Map<String,Object> baseControllerException(HttpServletRequest request, Exception ex){
        Map<String,Object> stringObjectMap=new HashMap<>();
        if(ex instanceof JsonException){
            JsonException jsonException= (JsonException) ex;
            stringObjectMap.put("code",jsonException.getCode());
            stringObjectMap.put("message",jsonException.getMessage());
        }else{
            stringObjectMap.put("code","-200");
            stringObjectMap.put("message","系统繁忙");
        }
        return stringObjectMap;
    }

}
