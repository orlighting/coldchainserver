package com.example.coldchain.server.controller;

import com.example.coldchain.server.mapper.AdminMapper;
import com.example.coldchain.server.pojo.Admin;
import com.example.coldchain.server.pojo.GoodOrder;
import com.example.coldchain.server.result.HttpResult;
import com.example.coldchain.server.result.HttpResultCodeEnum;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Objects;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @Resource
    private AdminMapper adminMapper;

    @CrossOrigin
    @PostMapping("/admin")
    public HttpResult<GoodOrder> adminLogin(@RequestBody Admin admin) {
        Long id = admin.getId();

        Admin resAdmin = adminMapper.getByPrimaryKey(id);
        if (resAdmin == null) {
            return HttpResult.of(HttpResultCodeEnum.LOGIN_FAIL);
        }
        if (Objects.equals(resAdmin.getPassword(), admin.getPassword())) {
            return HttpResult.of();
        }

        return HttpResult.of(HttpResultCodeEnum.LOGIN_FAIL);

    }



}
