package com.example.demo.service;

import com.example.demo.entity.UmsPermission;
import com.example.demo.entity.User;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

public interface IUserService {
    int insert(User user);

    int update(User user);

    Page list(Integer pageNum, Integer pageSize);

    User get(Integer id);

    User get(Map map);

    User getAdminByUsername(String username);

    List<UmsPermission> getPermissionList(Integer id);
}
