/*********************************************
 *
 * Copyright (C) 2019 IBM All rights reserved.
 *
 ********* K*I*N*G ********** B*A*C*K *******/
package com.example.demo.controller;
/**
 * @author Moses *
 * @Date 2020/9/22 12:00
 */

import com.example.demo.common.CommonPage;
import com.example.demo.common.CommonResult;
import com.example.demo.entity.User;
import com.example.demo.service.IUserService;
import com.github.pagehelper.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Api("User API")
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/detail/{id}")
    @ApiOperation(value = "user detail", notes = "get a user detail")
    public CommonResult detail(@PathVariable(name = "id") Integer id) {
        User user = userService.get(id);
        return CommonResult.success(user);
    }

    @GetMapping("/list")
    @ApiOperation(value = "user list", notes = "get all user list")
    public CommonResult list(@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page page = userService.list(pageNum, pageSize);
        return CommonResult.success(CommonPage.restPage(page));
    }

    /**
     * 登录之后才能访问的接口
     *
     * @param user
     * @return
     */
//    @RequiresAuthentication
    @PostMapping("/update")
    @ApiOperation(value = "user update", notes = "update user detail")
    public CommonResult update(@Validated @RequestBody User user) {
        int num = userService.update(user);
        return CommonResult.success(num);
    }
}