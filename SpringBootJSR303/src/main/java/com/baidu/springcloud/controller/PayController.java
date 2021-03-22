package com.baidu.springcloud.controller;

import com.alibaba.druid.util.StringUtils;
import com.baidu.springcloud.exception.JsonException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class PayController extends BaseController{
    @RequestMapping("/pay")
    @ResponseBody
    public Map<String,Object> pay(HttpServletRequest request) throws JsonException {
        Map<String,Object> stringObjectMap= new HashMap<>();
        String pay = request.getParameter("pay");
        if(StringUtils.isEmpty(pay.trim())){
            throw new JsonException(-100,"对不起参数为空");
        }
        try {
            int i=1/0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new JsonException(-101,"对不起 除以0 了 ");
        }
        if("魏雪".equals(pay)){
            stringObjectMap.put("code",200);
            stringObjectMap.put("message","参数传入正确");
        }
        return stringObjectMap;
    }

}
