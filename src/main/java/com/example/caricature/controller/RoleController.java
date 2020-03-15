package com.example.caricature.controller;

import com.example.caricature.entity.Role;
import com.example.caricature.service.impl.RoleServiceImpl;
import com.example.caricature.sys.enums.ResultStatusCode;
import com.example.caricature.sys.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Role)表控制层
 *
 * @author makejava
 * @since 2020-02-29 21:44:45
 */
@Api(tags = "权限")
@RestController
@RequestMapping("role")
public class RoleController {
    /**
     * 服务对象
     */
    @Resource
    private RoleServiceImpl roleService;

    /**
     * 通过主键查询单条数据
     *
     * @return List
     */
    @ApiOperation(value = "获取所有权限")
    @PostMapping("select")
    public Result select() {
        List<Role> list = roleService.queryAll();
        return new Result(ResultStatusCode.OK, list);
    }


    @ApiOperation(value = "添加权限")
    @PostMapping("insert")
    public Result insert(String name) {

        Role role = new Role();
        role.setName(name);
        int code = roleService.insert(role);
        if (code == 1) {
            return new Result(ResultStatusCode.OK);
        } else {
            return new Result(ResultStatusCode.SYSTEM_ERR);
        }
    }
}