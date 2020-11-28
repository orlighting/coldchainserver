package com.example.coldchain.server.controller;

import com.example.coldchain.server.mapper.DriverMapper;
import com.example.coldchain.server.pojo.Driver;
import com.example.coldchain.server.result.HttpResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @CrossOrigin
    @PostMapping("/driverList")
    public HttpResult<List<Driver>> getAllCheckList() {
        List<Driver> driverList = driverMapper.getNoteCheckList(1);
        return HttpResult.of(driverList);
    }
}
