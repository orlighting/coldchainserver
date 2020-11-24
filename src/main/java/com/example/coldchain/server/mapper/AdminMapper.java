package com.example.coldchain.server.mapper;

import com.example.coldchain.server.pojo.Admin;

import java.util.List;

public interface AdminMapper {

    Admin findsById(Long id);

    List<Admin> findsAll();


}
