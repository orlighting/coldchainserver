package com.example.coldchain.server.controller;

import com.example.coldchain.server.mapper.GoodOrderMapper;
import com.example.coldchain.server.pojo.GoodOrder;
import com.example.coldchain.server.result.HttpResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @Author ccesss
 * @Date 2021/3/15 9:25
 * @Version 1.0
 **/
@Controller
public class DataController {

    @Resource
    GoodOrderMapper goodOrderMapper;
    @CrossOrigin
    @ResponseBody
    @RequestMapping("api/data/carBendOrder")
    public HttpResult<GoodOrder> carBendOrder(int deviceId){
        System.out.println(deviceId);
        GoodOrder goodOrder=goodOrderMapper.getOrderByDeviceId(deviceId);
        System.out.println(goodOrder);
        return HttpResult.of(goodOrder);
    }
}
