package com.example.caricature.service.impl;

import com.example.caricature.entity.Cookies;
import com.example.caricature.mapper.CookiesMapper;
import com.example.caricature.service.CookiesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class CookiesServiceImpl implements CookiesService{

    @Resource
    private CookiesMapper cookiesMapper;

    @Override
    public int deleteByPrimaryKey(String id) {
        return cookiesMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Cookies record) {
        return cookiesMapper.insert(record);
    }

    @Override
    public int insertSelective(Cookies record) {
        return cookiesMapper.insertSelective(record);
    }

    @Override
    public Cookies selectByPrimaryKey(String id) {
        return cookiesMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Cookies record) {
        return cookiesMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Cookies record) {
        return cookiesMapper.updateByPrimaryKey(record);
    }

    public List<Map> getByAll(Cookies cookies) {
        return cookiesMapper.getByAll(cookies);
    }
}
