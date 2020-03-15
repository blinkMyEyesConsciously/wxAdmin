package com.example.caricature.service.impl;

import com.example.caricature.entity.UserRole;
import com.example.caricature.mapper.UserRoleMapper;
import com.example.caricature.service.UserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return userRoleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(UserRole record) {
        return userRoleMapper.insert(record);
    }

    @Override
    public int insertSelective(UserRole record) {
        return userRoleMapper.insertSelective(record);
    }

    @Override
    public UserRole selectByPrimaryKey(String id) {
        return userRoleMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(UserRole record) {
        return userRoleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(UserRole record) {
        return userRoleMapper.updateByPrimaryKey(record);
    }
    @Override
    public int queryById(String id) {
        return 0;
    }
    @Override
    public List<UserRole> selectByAll(UserRole userRole) {
        return userRoleMapper.selectByAll(userRole);
    }
}

