package com.example.caricature.service;

import com.example.caricature.entity.Cookies;
public interface CookiesService{


    int deleteByPrimaryKey(String id);

    int insert(Cookies record);

    int insertSelective(Cookies record);

    Cookies selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Cookies record);

    int updateByPrimaryKey(Cookies record);

}
