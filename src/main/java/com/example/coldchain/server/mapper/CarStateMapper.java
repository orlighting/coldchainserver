package com.example.coldchain.server.mapper;

import com.example.coldchain.server.pojo.CarState;

import java.util.List;

public interface CarStateMapper {

    CarState findsById(Long id);

    List<CarState> findsAll();

}
