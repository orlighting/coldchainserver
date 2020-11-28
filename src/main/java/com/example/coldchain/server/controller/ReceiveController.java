package com.example.coldchain.server.controller;

import com.example.coldchain.server.mapper.CarStateMapper;
import com.example.coldchain.server.mapper.DriverMapper;
import com.example.coldchain.server.mapper.GoodOrderMapper;
import com.example.coldchain.server.pojo.CarState;
import com.example.coldchain.server.pojo.Driver;
import com.example.coldchain.server.pojo.GoodOrder;
import com.example.coldchain.server.result.HttpResult;
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
    public HttpResult<Void> receiveDriverInfo(@RequestBody Driver driver) {
        // TODO 生成ID
        driver.setCheckState(0);
        driver.setDelete(false);
        driver.setCreateTime(LocalDateTime.now());
        driver.setUpdateTime(LocalDateTime.now());

        driverMapper.saveSelective(driver);
        return HttpResult.of();
    }

    @CrossOrigin
    @PostMapping("/carState")
    public HttpResult<Void> receiveCarState(@RequestBody CarState carState) {
        // TODO
        carState.setDelete(false);
        carState.setCreateTime(LocalDateTime.now());

        carStateMapper.saveSelective(carState);
        return HttpResult.of();
    }

    @CrossOrigin
    @PostMapping("/goodOrder")
    public HttpResult<Void> receiveGoodOrder(@RequestBody GoodOrder goodOrder) {
        // TODO
        goodOrder.setDelete(false);
        goodOrder.setCreateTime(LocalDateTime.now());
        goodOrder.setUpdateTime(LocalDateTime.now());

        goodOrderMapper.saveSelective(goodOrder);
        return HttpResult.of();
    }

}
