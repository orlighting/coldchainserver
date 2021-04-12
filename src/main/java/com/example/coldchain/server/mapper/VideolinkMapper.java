package com.example.coldchain.server.mapper;

import com.example.coldchain.server.pojo.Videolink;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * VideolinkMapper继承基类
 */
@Mapper
@Repository
public interface VideolinkMapper extends MyBatisBaseDao<Videolink, Integer> {
}