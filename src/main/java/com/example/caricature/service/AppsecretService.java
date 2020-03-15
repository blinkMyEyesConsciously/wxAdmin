package com.example.caricature.service;

import com.example.caricature.entity.Appsecret;
import com.example.caricature.entity.utils.PageHelpEntity;
import com.example.caricature.sys.vo.Result;
import com.github.pagehelper.PageInfo;

public interface AppsecretService{


    int deleteByPrimaryKey(String id);

    int insert(Appsecret record);

    int insertSelective(Appsecret record);

    Appsecret selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Appsecret record);

    int updateByPrimaryKey(Appsecret record);

    Result useKey(Appsecret appsecret);

    PageInfo<Appsecret> getByAllwithPage(PageHelpEntity pageHelpEntity, Appsecret appsecret);
}
