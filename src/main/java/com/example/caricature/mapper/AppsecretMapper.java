package com.example.caricature.mapper;
import java.util.List;

import com.example.caricature.entity.Appsecret;

public interface AppsecretMapper {
    int deleteByPrimaryKey(String id);

    int insert(Appsecret record);

    int insertSelective(Appsecret record);

    Appsecret selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Appsecret record);

    int updateByPrimaryKey(Appsecret record);

    List<Appsecret> getByAll(Appsecret appsecret);


}