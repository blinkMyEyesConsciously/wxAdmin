package com.example.caricature.controller;

import com.example.caricature.entity.UserRole;
import com.example.caricature.service.impl.UserRoleServiceImpl;
import com.example.caricature.sys.enums.ResultStatusCode;
import com.example.caricature.sys.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (UserRole)表控制层
 *
 * @author makejava
 * @since 2020-02-29 22:32:39
 */
@Api(tags = "用户权限关系")
@RestController
@RequestMapping("userRole")
public class UserRoleController {
    /**
     * 服务对象
     */
    @Resource
    private UserRoleServiceImpl userRoleService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @PostMapping("selectOne")
    public int selectOne(String id) {
        return 0;
    }

    @ApiOperation(value = "插入用户权限关系")
    @PostMapping("insert")
    public Result insert (String userID,String roleId  ) {
        UserRole userRole= new UserRole();
        userRole.setUserId(userID);
        userRole.setRoleId(roleId);
        userRoleService.insert(userRole);
        return  new Result(ResultStatusCode.OK );
    }

}