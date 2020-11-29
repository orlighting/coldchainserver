package com.example.coldchain.server.controller;

import com.example.coldchain.server.mapper.CarStateMapper;
import com.example.coldchain.server.mapper.GoodOrderMapper;
import com.example.coldchain.server.pojo.CarState;
import com.example.coldchain.server.pojo.GoodOrder;
import com.example.coldchain.server.result.HttpResult;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @CrossOrigin
    @PostMapping("/carState")
    public HttpResult<List<CarState>> getCarState() {
//        向前端发送所有在运行订单中的最新车辆状态消息，用于前端展示
        List<GoodOrder> goodOrderList = goodOrderMapper.getNotCompeteOrderList();
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
    @PostMapping("/goodOrder")
    public HttpResult<List<GoodOrder>> getGoodOrder() {
        List<GoodOrder> goodOrderList = goodOrderMapper.getNotCompeteOrderList();
        return HttpResult.of(goodOrderList);
    }

    @CrossOrigin
    @PostMapping("/allCarState")
    public HttpResult<List<CarState>> getAllCarState(Long goodOrderId) {
        List<CarState> carStateList = carStateMapper.getByOrderId(goodOrderId);
        return HttpResult.of(carStateList);
    }
}