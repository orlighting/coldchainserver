package com.example.coldchain.server.controller;

import com.example.coldchain.server.mapper.CarStateMapper;
import com.example.coldchain.server.mapper.DriverMapper;
import com.example.coldchain.server.mapper.GoodOrderMapper;
import com.example.coldchain.server.pojo.CarState;
import com.example.coldchain.server.pojo.Driver;
import com.example.coldchain.server.pojo.GoodOrder;
import com.example.coldchain.server.result.HttpResult;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ZhaoDesong
 * @date 2020/11/28 17:45
 */
@RestController
@RequestMapping("/api/display")
public class DisplayController {

    @Resource
    private CarStateMapper carStateMapper;
    @Resource
    private GoodOrderMapper goodOrderMapper;
    @Resource
    private DriverMapper driverMapper;

    @CrossOrigin
    @PostMapping("/carState")
    public HttpResult<List<CarState>> getCarState(@RequestBody GoodOrder goodOrder) {
//        向前端发送所有在运行订单中的最新车辆状态消息，用于前端展示
        List<GoodOrder> goodOrderList = goodOrderMapper.getNotCompeteOrderList(goodOrder.getCompleteState());
        if (CollectionUtils.isEmpty(goodOrderList)) {
            return HttpResult.of(new ArrayList<>());
        }
        List<Long> goodOrderIdList = goodOrderList.stream()
                .map(GoodOrder::getId)
                .collect(Collectors.toList());
        List<CarState> carStateList = carStateMapper.getCarLatestStateByOrderIdList(goodOrderIdList);
        return HttpResult.of(carStateList);
    }

    @CrossOrigin
    @RequestMapping("/goodOrder")
    public HttpResult<List<GoodOrder>> getGoodOrder(int completeState) {
        List<GoodOrder> goodOrderList = goodOrderMapper.getNotCompeteOrderList(completeState);
        return HttpResult.of(goodOrderList);
    }

    @CrossOrigin
    @PostMapping("/allCarState")
    public HttpResult<List<CarState>> getAllCarState(@RequestBody GoodOrder goodOrder) {
        List<CarState> carStateList = carStateMapper.getByOrderId(goodOrder.getId());
        return HttpResult.of(carStateList);
    }
    //那司机id查司机
    @CrossOrigin
    @RequestMapping("/driver")
    public HttpResult<Driver> getDriver(@RequestBody Driver driver){
        Driver driver2 = driverMapper.selectByPrimaryKey(driver.getDriverId());
        return HttpResult.of(driver2);
    }
}
