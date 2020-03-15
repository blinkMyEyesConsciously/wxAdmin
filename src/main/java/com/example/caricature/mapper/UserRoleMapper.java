package com.example.caricature.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Date;

import com.example.caricature.entity.UserRole;

public interface UserRoleMapper {
    int deleteByPrimaryKey(String id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
    List<UserRole> selectByAll(UserRole userRole);


}