package com.example.caricature.service.impl;

import com.example.caricature.entity.Appsecret;
import com.example.caricature.entity.UserRole;
import com.example.caricature.entity.utils.PageHelpEntity;
import com.example.caricature.mapper.AppsecretMapper;
import com.example.caricature.service.AppsecretService;
import com.example.caricature.sys.enums.ResultStatusCode;
import com.example.caricature.sys.vo.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;

@Service
public class AppsecretServiceImpl implements AppsecretService {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");//格式化输出日期

    @Resource
    private AppsecretMapper appsecretMapper;

    @Resource
    private UserRoleServiceImpl userRoleService;

    @Override
    public int deleteByPrimaryKey(String id) {
        return appsecretMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Appsecret record) {

        return appsecretMapper.insert(record);
    }

    @Override
    public int insertSelective(Appsecret record) {
        return appsecretMapper.insertSelective(record);
    }

    @Override
    public Appsecret selectByPrimaryKey(String id) {
        return appsecretMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Appsecret record) {
        return appsecretMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Appsecret record) {
        return appsecretMapper.updateByPrimaryKey(record);
    }

    @Override
    @Transactional
    public Result useKey(Appsecret appsecret) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Appsecret key = selectByPrimaryKey(appsecret.getId());
//        判断是否被使用
        if (StringUtils.isEmpty(key.getId()) || key.getIsUse().equals("1")) {
            return new Result(ResultStatusCode.SYSTEM_ERR, "卡密已经被使用或者不存在");
        } else {
            UserRole userRole = new UserRole();
            userRole.setUserId(appsecret.getUserId());
            userRole.setRoleId(appsecret.getRoleId());
            List<UserRole> userRoles = userRoleService.selectByAll(userRole);
            Date date = new Date();
            long time = 60 * 1000 * 60;//60分钟
            Date data2 = new Date(date.getTime() + time * appsecret.getUseTime());
            switch (userRoles.size()) {
                case 0:
                    userRole.setDisabilityTime(data2);
                    userRoleService.insert(userRole);
                case 1:
                    UserRole uRole = userRoles.get(0);
                    userRole.setId(uRole.getId());
                    if (uRole.getDisabilityTime().before(new Date())) {
                        userRole.setDisabilityTime(data2);
                        userRoleService.updateByPrimaryKey(userRole);
                    } else {
                        userRole.setDisabilityTime(new Date(uRole.getDisabilityTime().getTime() + time * appsecret.getUseTime()));
                        userRoleService.updateByPrimaryKey(userRole);
                    }
                    break;
                default:
                    return new Result(ResultStatusCode.SYSTEM_ERR);

            }

        }

        return new Result(ResultStatusCode.OK);
    }


    @Override
    public PageInfo<Appsecret> getByAllwithPage(PageHelpEntity pageHelpEntity, Appsecret appsecret) {
        PageHelper.startPage(pageHelpEntity);
        return new PageInfo<>(appsecretMapper.getByAll(appsecret));
    }
}
