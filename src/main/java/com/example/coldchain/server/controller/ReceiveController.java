package com.example.coldchain.server.controller;

import com.example.coldchain.server.mapper.CarStateMapper;
import com.example.coldchain.server.mapper.DriverMapper;
import com.example.coldchain.server.mapper.GoodOrderMapper;
import com.example.coldchain.server.pojo.CarState;
import com.example.coldchain.server.pojo.Driver;
import com.example.coldchain.server.pojo.GoodOrder;
import com.example.coldchain.server.result.HttpResult;
import com.sun.istack.internal.NotNull;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author ZhaoDesong
 * @date 2020/11/28 17:44
 */
@RestController
@RequestMapping("/api/receive")
public class ReceiveController {

    @Resource
    private DriverMapper driverMapper;
    @Resource
    private CarStateMapper carStateMapper;
    @Resource
    private GoodOrderMapper goodOrderMapper;

    @CrossOrigin
    @PostMapping("/driver")
    public HttpResult<Long> receiveDriverInfo(@RequestBody Driver driver) {

        driver.setCheckState(0);
        driver.setDelete(false);
        driver.setCreateTime(LocalDateTime.now());
        driver.setUpdateTime(LocalDateTime.now());

        driverMapper.insertSelective(driver);
        return HttpResult.of(driver.getDriverId());
    }

    //接收上报数据状态接口
    @CrossOrigin
    @PostMapping("/carState")
    public HttpResult<Void> receiveCarState(@RequestBody CarState carState) {

        carState.setDelete(false);
        carState.setLatest(true);
        carState.setCreateTime(LocalDateTime.now());
        System.out.println("接收到消息:"+carState);
        carStateMapper.updateLatestByOrderId(carState.getOrderId());
        carStateMapper.saveSelective(carState);
        return HttpResult.of();
    }

    //接受订单数据接口
    @CrossOrigin
    @PostMapping("/goodOrder")
    public HttpResult<Long> receiveGoodOrder(@RequestBody GoodOrder goodOrder) {

        goodOrder.setDelete(false);
        goodOrder.setCreateTime(LocalDateTime.now());
        goodOrder.setUpdateTime(LocalDateTime.now());

        goodOrderMapper.saveSelective(goodOrder);

        return HttpResult.of(goodOrder.getId());
    }

    @CrossOrigin
    @RequestMapping("/changeCompleteState")
    public HttpResult<Void> receiveCompleteOrder(@RequestBody GoodOrder goodOrder){
        GoodOrder goodOrderOld = goodOrderMapper.getByPrimaryKey(goodOrder.getId());
        goodOrderOld.setUpdateTime(LocalDateTime.now());
        goodOrderOld.setCompleteState(goodOrder.getCompleteState());
        goodOrderMapper.updateByPrimaryKeySelective(goodOrder);
        return HttpResult.of();
    }
    //修改订单信息

    @CrossOrigin
    @RequestMapping("/changeOrder")
    public HttpResult<Void> changeOrder(@RequestBody GoodOrder goodOrder){
        System.out.println(goodOrder);
        goodOrder.setUpdateTime(LocalDateTime.now());
        goodOrderMapper.updateByPrimaryKeySelective(goodOrder);
        return HttpResult.of();
    }

}
