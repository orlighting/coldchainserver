package com.example.coldchain.server.mapper;

import com.example.coldchain.server.pojo.Admin;

public interface AdminMapper {

    /**
     * 插入一行数据，如果字段为null，则不处理
     *
     * @param admin admin
     * @return count
     */
    int saveSelective(Admin admin);

    /**
     * 根据主键更新一行数据，如果字段为null，则不处理
     *
     * @param admin admin
     * @return count
     */
    int updateByPrimaryKeySelective(Admin admin);

    /**
     * 根据主键查询一条数据
     *
     * @param id id
     * @return po
     */
    Admin getByPrimaryKey(Long id);

}
