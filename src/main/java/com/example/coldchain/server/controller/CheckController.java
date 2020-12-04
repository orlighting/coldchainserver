package com.example.coldchain.server.controller;

import com.example.coldchain.server.mapper.DriverMapper;
import com.example.coldchain.server.pojo.Driver;
import com.example.coldchain.server.result.HttpResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ZhaoDesong
 * @date 2020/11/28 17:44
 */
@RestController
@RequestMapping("/api/check")
public class CheckController {

    @Resource
    private DriverMapper driverMapper;

    @CrossOrigin
    @PostMapping("/driver")
    public HttpResult<Void> checkDriverInfo(@RequestBody Driver driver) {
        driverMapper.updateByPrimaryKeySelective(driver);
        return HttpResult.of();
    }

    @CrossOrigin
    @RequestMapping("/driverList")
    public HttpResult<List<Driver>> getNotCheckList() {
        List<Driver> driverList = driverMapper.getNoteCheckList(0);
        return HttpResult.of(driverList);
    }
}
