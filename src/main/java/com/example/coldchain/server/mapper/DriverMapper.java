package com.example.coldchain.server.mapper;

import com.example.coldchain.server.pojo.Driver;

import java.util.List;

public interface DriverMapper {

    Driver findsById(Integer id);

    List<Driver> findsAll();

}
