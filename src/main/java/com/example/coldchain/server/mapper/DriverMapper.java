package com.example.coldchain.server.mapper;

import com.example.coldchain.server.pojo.Driver;
import jdk.internal.dynalink.linker.LinkerServices;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DriverMapper继承基类
 */
@Mapper
@Repository
public interface DriverMapper extends MyBatisBaseDao<Driver, Long> {
    Driver selectByPrimaryKey(Long driverId);
    int insertSelective(Driver driver);
    List<Driver> getNoteCheckList(int i);

}