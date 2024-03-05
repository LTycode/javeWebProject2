package com.xiaohuang.service;

import com.xiaohuang.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaohuang.utils.Result;

import java.util.List;

/**
* @author changle
* @description 针对表【c_user】的数据库操作Service
* @createDate 2023-12-06 03:11:41
*/
public interface UserService extends IService<User> {

    User login(User user);

    List<User> getUsers(List<Integer> lists);
}
