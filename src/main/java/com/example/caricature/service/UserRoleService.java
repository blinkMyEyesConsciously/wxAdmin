package com.example.caricature.service;

import com.example.caricature.entity.UserRole;

import java.util.List;

public interface UserRoleService {


    int deleteByPrimaryKey(String id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

    int queryById(String id);

    List<UserRole> selectByAll(UserRole userRole);
}

