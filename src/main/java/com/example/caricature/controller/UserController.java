package com.example.caricature.controller;

import com.example.caricature.entity.User;
import com.example.caricature.service.impl.UserServiceImpl;
import com.example.caricature.sys.enums.ResultStatusCode;
import com.example.caricature.sys.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = "用户")
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserServiceImpl userService;


    @ApiOperation(value = "修改用户信息")
    @PostMapping("/upDate")
    public Result upDate(User user) {
        int i = userService.updateByPrimaryKeySelective(user);
        if (i == 1) {
            return new Result(ResultStatusCode.OK);

        } else {
            return new Result(ResultStatusCode.SYSTEM_ERR);
        }
    }

    @ApiOperation(value = "批量删除用户")
    @PostMapping("/del")
    public Result del(String ids) {
        userService.deleteByPrimaryKey(ids);
        return new Result(ResultStatusCode.OK);

    }
}
