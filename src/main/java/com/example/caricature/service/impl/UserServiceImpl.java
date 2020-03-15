package com.example.caricature.service.impl;

import com.example.caricature.entity.User;
import com.example.caricature.mapper.UserMapper;
import com.example.caricature.service.UserService;
import com.example.caricature.sys.enums.ResultStatusCode;
import com.example.caricature.sys.vo.Result;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    @Transactional
    public int deleteByPrimaryKey(String ids) {
        List<String> list = Arrays.asList(ids.split(","));
        for (String s : list) {
            userMapper.deleteByPrimaryKey(s);


        }
        return 0;
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(String id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    public int selectAll() {
        return 0;
    }

    public Result login(String userName, String passWord) {
        return new Result(ResultStatusCode.OK);
    }
}
