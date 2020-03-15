package com.example.caricature.controller;


import com.example.caricature.entity.Cookies;
import com.example.caricature.service.impl.CookiesServiceImpl;
import com.example.caricature.sys.enums.ResultStatusCode;
import com.example.caricature.sys.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.json.Cookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Validated
@Api(tags = "cookies管理")
@RestController
@RequestMapping("/cookies")
public class CookiesAdminController {
    @Resource
    CookiesServiceImpl cookiesService;


    @ApiOperation(value = "添加")
    @PostMapping("select")
    public Result add(Cookies cookie) {
        int insert = cookiesService.insert(cookie);

        return new Result(ResultStatusCode.OK);
    }

    @ApiOperation(value = "删除")
    @PostMapping("del")
    public Result del(String id) {
        int i = cookiesService.deleteByPrimaryKey(id);
        if (i==1) {
            return new Result(ResultStatusCode.OK);
        }else {
            return  new Result(ResultStatusCode.SYSTEM_ERR);
        }
    }

    @ApiOperation(value = "获取")
    @PostMapping("getAll")
    public Result getAll(Cookies cookies) {
        List<Map> byAll = cookiesService.getByAll(cookies);
        return new Result(ResultStatusCode.OK,byAll);


    }


}
