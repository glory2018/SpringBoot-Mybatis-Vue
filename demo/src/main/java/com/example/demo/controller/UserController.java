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
import com.example.demo.common.Result;
import com.example.demo.entity.User;
import com.example.demo.service.IUserService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/detail/{id}")
    public Result detail(@PathVariable(name = "id") Integer id) {
        User user = userService.detail(id);
        return Result.success(user);
    }

    @GetMapping("/list")
    public Result list(@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                       @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        Page page = userService.list(pageNum, pageSize);
        return Result.success(CommonPage.restPage(page));
    }

    @PostMapping("/update")
    public Result update(@RequestBody User user) {
        int num = userService.update(user);
        return Result.success(num);
    }
}