package com.example.coldchain.server.mapper;

import com.example.coldchain.server.pojo.GoodOrder;

import java.util.List;

public interface GoodOrderMapper {

    GoodOrder findsById(Long id);

    List<GoodOrder> findsAll();

}
