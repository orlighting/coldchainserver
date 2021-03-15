package com.example.coldchain.server.mapper;

import com.example.coldchain.server.pojo.Driver;

import java.util.List;

public interface DriverMapper {

    /**
     * 插入一行数据，如果字段为null，则不处理
     *
     * @param driver driver
     * @return count
     */
    int saveSelective(Driver driver);

    /**
     * 根据主键更新一行数据，如果字段为null，则不处理
     *
     * @param driver driver
     * @return count
     */
    int updateByPrimaryKeySelective(Driver driver);

    /**
     * 根据主键查询一条数据
     *
     * @param id id
     * @return po
     */
    Driver getByPrimaryKey(Long id);

    /**
     * 根据审核状态获取司机信息
     *
     * @param checkStatus
     * @return
     */
    List<Driver> getNoteCheckList(Integer checkStatus);

    //通过id查司机
    Driver getDriver(Long id);

    //返回所有司机
    List<Driver> getAllDriver();
}
