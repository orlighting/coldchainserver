package com.example.coldchain.server.controller;

import com.example.coldchain.server.mapper.AdminMapper;
import com.example.coldchain.server.mapper.DriverMapper;
import com.example.coldchain.server.mapper.GoodOrderMapper;
import com.example.coldchain.server.pojo.Admin;
import com.example.coldchain.server.pojo.Driver;
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
    @Resource
    DriverMapper driverMapper;
    @Resource
    AdminMapper adminMapper;


    @CrossOrigin
    @ResponseBody
    @RequestMapping("api/data/carBendOrder")//车辆订单绑定接口
    public HttpResult<GoodOrder> carBendOrder(@RequestBody GoodOrder goodOrder){
        System.out.println(goodOrder.getDeviceId());
        GoodOrder goodOrder2=goodOrderMapper.getOrderByDeviceId(goodOrder.getDeviceId());
        System.out.println(goodOrder2);
        return HttpResult.of(goodOrder2);
    }


    @CrossOrigin
    @ResponseBody
    @RequestMapping("api/data/getDriver")//获取司机信息
    public HttpResult<Driver> getDriver(@RequestBody Driver driver){
        System.out.println(driver.getId());
        return HttpResult.of(driverMapper.getByPrimaryKey(driver.getId()));
    }

    @CrossOrigin
    @ResponseBody
    @RequestMapping("api/data/getCreator")//获取订单员信息
    public HttpResult<Admin> getAdmin(@RequestBody Admin admin){
        System.out.println(admin.getId());
        return HttpResult.of(adminMapper.getByPrimaryKey(admin.getId()));
    }






}
