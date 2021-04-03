package com.example.coldchain.server.mapper;

import com.example.coldchain.server.pojo.ErrorOrder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * ErrorOrderMapper继承基类
 */
@Mapper
@Repository
public interface ErrorOrderMapper{
    int addNew(ErrorOrder errorOrder);

    /**
     * 获取结束时间为null的条目,并填充时间
     */
    void updateEndTimeNull(LocalDateTime localDateTime);

    /**
     * 返回所有问题订单表
     */
    List<ErrorOrder> findAll();

    /**
     * 根据主键获取异常订单
     * @param id
     * @return
     */
    List<ErrorOrder> selectByPrimaryKey(Long id);
}