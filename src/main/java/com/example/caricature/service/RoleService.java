package com.example.caricature.service;

import com.example.caricature.entity.Role;

import java.util.List;

public interface RoleService {


    int deleteByPrimaryKey(String id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);

    List<Role> queryAll();
}

