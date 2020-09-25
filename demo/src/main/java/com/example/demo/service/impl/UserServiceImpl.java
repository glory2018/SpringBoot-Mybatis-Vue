package com.example.demo.service.impl;

import com.example.demo.entity.UmsPermission;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.IUserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements IUserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public Page list(Integer pageNum, Integer pageSize) {
        Map<String, Object> params = new HashMap();
        Page page = PageHelper.startPage(pageNum, pageSize);
        //  ASC是根据id 正向排序，DESC是反向排序
        PageHelper.orderBy("id ASC");
        // 从数据库查询，这里返回的的allUser就已经分页成功了
        List<User> list = userMapper.list(params);
        return page;
    }

    @Override
    public User get(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public User get(Map map) {
        return userMapper.get(map);
    }

    @Override
    public User getAdminByUsername(String username) {
        Map map = new HashMap();
        map.put("username", username);
        return get(map);
    }

    @Override
    public List<UmsPermission> getPermissionList(Integer id) {
        return null;
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int update(User user) {
        return userMapper.updateByPrimaryKey(user);
    }
}
