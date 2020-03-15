package com.example.caricature.controller;

import com.example.caricature.entity.Appsecret;
import com.example.caricature.mapper.AppsecretMapper;
import com.example.caricature.service.impl.AppsecretServiceImpl;
import com.example.caricature.sys.enums.ResultStatusCode;
import com.example.caricature.sys.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "秘钥管理")
@RestController
@RequestMapping("Appsecret")
public class AppsecretController {
    @Autowired
    AppsecretServiceImpl appsecretService;

    @ApiOperation(value = "创建秘钥")
    @PostMapping("/setKey")
    public Result setKey(Appsecret appsecret) {
        appsecretService.insert(appsecret);
        return new Result(ResultStatusCode.OK);

    }
    @ApiOperation(value = "删除秘钥")
    @PostMapping("/del")
    public Result del(String id) {
        int i = appsecretService.deleteByPrimaryKey(id);
        if (i==1) {
            return new Result(ResultStatusCode.OK);

        }else {
            return new Result(ResultStatusCode.PARAM_MISSING);

        }

    }
}
