package com.example.demo.service;

import com.example.demo.entity.User;
import com.github.pagehelper.Page;

public interface IUserService {
    User detail(Integer id);

    Page list(Integer pageNum, Integer pageSize);

    User findUser(User user);

    int update(User user);
}
