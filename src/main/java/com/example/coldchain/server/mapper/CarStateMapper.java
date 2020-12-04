package com.example.coldchain.server.mapper;

import com.example.coldchain.server.pojo.CarState;

import java.util.List;

public interface CarStateMapper {

    /**
     * 插入一行数据，如果字段为null，则不处理
     *
     * @param carstate carstate
     * @return count
     */
    int saveSelective(CarState carstate);

    /**
     * 根据主键更新一行数据，如果字段为null，则不处理
     *
     * @param carstate carstate
     * @return count
     */
    int updateByPrimaryKeySelective(CarState carstate);

    /**
     * 根据主键查询一条数据
     *
     * @param orderId id
     * @return po
     */
    List<CarState> getByOrderId(Long orderId);

    /**
     * 根据主键查询一条数据
     *
     * @param orderIdList
     * @return po
     */
    List<CarState> getCarLatestStateByOrderIdList(List<Long> orderIdList);

    /**
     * 根据订单编号修改当前最新的记录为非最新
     * @param orderId
     * @return
     */
    int updateLatestByOrderId(Long orderId);


}
