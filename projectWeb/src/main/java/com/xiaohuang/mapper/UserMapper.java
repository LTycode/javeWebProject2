package com.xiaohuang.mapper;

import com.xiaohuang.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author changle
* @description 针对表【c_user】的数据库操作Mapper
* @createDate 2023-12-06 03:11:41
* @Entity com.xiaohuang.pojo.User
*/
public interface UserMapper extends BaseMapper<User> {

    User queryById(Integer i);
}




