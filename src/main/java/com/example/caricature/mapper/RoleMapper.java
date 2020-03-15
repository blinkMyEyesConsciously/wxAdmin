package com.example.caricature.mapper;

import com.example.caricature.entity.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(String id);


    int updateByPrimaryKey(@Param("record") Role record);

    List<Role> selectByAll(Role role);

}