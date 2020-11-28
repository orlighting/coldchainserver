package com.example.coldchain.server.mapper;

import com.example.coldchain.server.pojo.GoodOrder;

import java.util.List;

public interface GoodOrderMapper {

    /**
     * 插入一行数据，如果字段为null，则不处理
     *
     * @param goodorder goodorder
     * @return count
     */
    int saveSelective(GoodOrder goodorder);

    /**
     * 根据主键更新一行数据，如果字段为null，则不处理
     *
     * @param goodorder goodorder
     * @return count
     */
    int updateByPrimaryKeySelective(GoodOrder goodorder);

    /**
     * 根据主键查询一条数据
     *
     * @param id id
     * @return po
     */
    GoodOrder getByPrimaryKey(Long id);

}
