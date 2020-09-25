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

import com.example.demo.common.CommonResult;
import com.example.demo.entity.User;
import com.example.demo.service.IUserService;
import com.example.demo.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Api("Login API")
@RestController
public class LoginController {
    @Autowired
    IUserService userService;
    @Autowired
    private UmsAdminService adminService;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;
    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @PostMapping("/login")
    @ApiOperation(value = "login", notes = "User login api")
    public CommonResult login(@RequestBody User user, HttpServletResponse response) {
//        user.setPassword(SecureUtil.md5(user.getPassword()));
//
//        User u = userService.getAdminByUsername(user.getUsername());
//        String jwt = jwtUtils.generateToken(u.getId());
//        response.setHeader("Authorization", jwt);
//        response.setHeader("Access-Control-Expose-Headers", "Authorization");
        String token = adminService.login(user.getUsername(), user.getPassword());
        if (token == null) {
            return CommonResult.validateFailed("用户名或密码错误");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return CommonResult.success(tokenMap);
    }

    //    @RequiresAuthentication
    @GetMapping("/logout")
    @ApiOperation(value = "logout", notes = "User logout api")
    public CommonResult logout() {
        return CommonResult.success(null);
    }
}