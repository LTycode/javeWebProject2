package com.xiaohuang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaohuang.pojo.Role;
import com.xiaohuang.service.RoleService;
import com.xiaohuang.mapper.RoleMapper;
import org.springframework.stereotype.Service;

/**
* @author changle
* @description 针对表【c_role】的数据库操作Service实现
* @createDate 2023-12-06 03:11:41
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

}




