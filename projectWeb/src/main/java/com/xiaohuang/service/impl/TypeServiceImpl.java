package com.xiaohuang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaohuang.pojo.Type;
import com.xiaohuang.service.TypeService;
import com.xiaohuang.mapper.TypeMapper;
import org.springframework.stereotype.Service;

/**
* @author changle
* @description 针对表【c_type】的数据库操作Service实现
* @createDate 2023-12-06 03:11:41
*/
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type>
    implements TypeService{

}




