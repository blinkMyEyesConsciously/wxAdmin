package com.example.caricature.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;
import java.util.Map;

import com.example.caricature.entity.Cookies;

public interface CookiesMapper {
    int deleteByPrimaryKey(String id);

    int insert(Cookies record);

    int insertSelective(Cookies record);

    Cookies selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Cookies record);

    int updateByPrimaryKey(Cookies record);

     List<Map> getByAll(Cookies cookies);



}