package com.example.caricature.controller;

import com.example.caricature.entity.User;
import com.example.caricature.service.impl.UserServiceImpl;
import com.example.caricature.sys.enums.ResultStatusCode;
import com.example.caricature.sys.vo.Check;
import com.example.caricature.sys.vo.Result;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@Api(tags = "用户管理")
@RestController
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    UserServiceImpl userService;

    @ApiOperation("登录")
    @PostMapping(value = "login")
    @Check(params = {"userName", "passWord"})                 // 若接口无必填参数，则写为 @Check(params = {})
    public Result login(String userName,  String passWord){


        return userService.login(userName, passWord);
    }

    @ApiOperation(value = "获取所有用户")
    @PostMapping("select")
    public Result select() {
        int list = userService.selectAll();
        return new Result(ResultStatusCode.OK, list);
    }

    @ApiOperation(value = "注册")
    @PostMapping("/register")
    public Result register(String name, String password) {
        User user = new User();
        user.setName(name);

        user.setPassword(password);
       int code=  userService.insert(user);
        if (code==1){
            return new Result(ResultStatusCode.OK);
        }else {
            return  new Result(ResultStatusCode.SYSTEM_ERR);
        }
    }
}