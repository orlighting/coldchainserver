package com.example.coldchain.server.controller;

import com.example.coldchain.server.mapper.AdminMapper;
import com.example.coldchain.server.pojo.Admin;
import com.example.coldchain.server.result.HttpResult;
import com.example.coldchain.server.result.HttpResultCodeEnum;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Objects;

@Controller
@RequestMapping("/api/login")
public class LoginController {

    @Resource
    private AdminMapper adminMapper;

    @CrossOrigin
    @PostMapping("/admin")
    @ResponseBody
    public HttpResult<Void> adminLogin(@RequestBody Admin admin){
        Long id = admin.getId();

        Admin resAdmin = adminMapper.findsById(id);
        if(resAdmin == null){
            return HttpResult.of(HttpResultCodeEnum.LOGIN_FAIL);
        }
        if(Objects.equals(resAdmin.getPassword(), admin.getPassword())){
            return HttpResult.of();
        }

        return HttpResult.of(HttpResultCodeEnum.LOGIN_FAIL);

    }


}
