package com.example.coldchain.server.controller;

import com.example.coldchain.server.mapper.DriverMapper;
import com.example.coldchain.server.pojo.CarState;
import com.example.coldchain.server.pojo.Driver;
import com.example.coldchain.server.pojo.GoodOrder;
import com.example.coldchain.server.result.HttpResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * TODO 未完成
 *
 * @author ZhaoDesong
 * @date 2020/11/28 17:45
 */
@RestController
@RequestMapping("/api/display")
public class DisplayController {

    @Resource
    private DriverMapper driverMapper;

    @CrossOrigin
    @PostMapping("/carState")
    public HttpResult<CarState> getCarState() {

        return HttpResult.of();
    }

    @CrossOrigin
    @PostMapping("/goodOrder")
    public HttpResult<List<GoodOrder>> getGoodOrder() {

        return HttpResult.of();
    }

    @CrossOrigin
    @PostMapping("/allCarState")
    public HttpResult<List<Driver>> getAllCarState(Long goodOrderId) {

        return HttpResult.of();
    }
}
