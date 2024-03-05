package com.xiaohuang.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaohuang.pojo.User;
import com.xiaohuang.service.UserService;
import com.xiaohuang.mapper.UserMapper;
import com.xiaohuang.utils.JwtHelper;
import com.xiaohuang.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author changle
* @description 针对表【c_user】的数据库操作Service实现
* @createDate 2023-12-06 03:11:41
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private JwtHelper jwtHelper;
    @Override
    public User login(User user) {
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(User::getUsername,user.getUsername());
        User user1 = userMapper.selectOne(lambdaQueryWrapper);
        return user1;
    }

    @Override
    public List<User> getUsers(List<Integer> lists) {
        List<User> users=new ArrayList<>();
        for(Integer i:lists)
        {
           users.add(userMapper.queryById(i));
        }

        return users;
    }
}




