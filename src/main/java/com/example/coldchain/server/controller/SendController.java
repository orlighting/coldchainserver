package com.example.coldchain.server.controller;

import com.example.coldchain.server.mapper.CarStateMapper;
import com.example.coldchain.server.mapper.DriverMapper;
import com.example.coldchain.server.pojo.CarState;
import com.example.coldchain.server.pojo.Driver;
import com.example.coldchain.server.result.HttpResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ZhaoDesong
 * @date 2020/11/28 17:45
 */
@RestController
@RequestMapping("/api/send")
public class SendController {

    @Resource
    private DriverMapper driverMapper;
    @Resource
    private CarStateMapper carStateMapper;

    //拉取司机信息
    @CrossOrigin
    @ResponseBody
    @PostMapping("/driverList")
    public HttpResult<List<Driver>> getAllCheckList() {
        List<Driver> driverList = driverMapper.getNoteCheckList(1);
        return HttpResult.of(driverList);
    }

    //返回单一订单id的所有车辆状态
    @CrossOrigin
    @ResponseBody
    @PostMapping("/carState")
    public HttpResult<List<CarState>> getACarState(@RequestBody CarState carState){
        List<CarState> byOrderId = carStateMapper.getByOrderId(carState.getOrderId());
        return HttpResult.of(byOrderId);
    }


}
