package com.xiaohuang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaohuang.mapper.OrderMapper;
import com.xiaohuang.mapper.OrderformMapper;
import com.xiaohuang.pojo.Blanketorder;
import com.xiaohuang.pojo.Order;
import com.xiaohuang.pojo.Orderform;
import com.xiaohuang.pojo.Recipe;
import com.xiaohuang.service.BlanketorderService;
import com.xiaohuang.mapper.BlanketorderMapper;
import com.xiaohuang.utils.Result;
import com.xiaohuang.vo.BlanketorderQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
* @author changle
* @description 针对表【c_blanketorder】的数据库操作Service实现
* @createDate 2023-12-11 00:16:47
*/
@Service
public class BlanketorderServiceImpl extends ServiceImpl<BlanketorderMapper, Blanketorder>
    implements BlanketorderService{


    @Autowired
    private BlanketorderMapper blanketorderMapper;

    @Override
    public Result getBlanketorderList(BlanketorderQuery blanketorderQuery) {
        //创建时间 获取当天日期
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String creatime = localDate.format(formatter);
//        String creatime ="2023-12-10";

        //查看今天是否有订单
        List<Blanketorder> blanketorderList= blanketorderMapper.selectBycreatime(creatime);
        System.out.println("blanketorderList = " + blanketorderList);
        //查看今天订单是否已经插入
        int i=blanketorderMapper.getcountBycreatime(creatime);
        if(blanketorderList.isEmpty())
        {
            //没有订单返回空
            return Result.success(null,0L);
        }else{
            //有订单，1，已经插入，2.还没插入
            if(i==0)
            {
                //没有插入
                //便先插入总括订单表中
                int i1=blanketorderMapper.insertByList(blanketorderList);
            }
            List<Blanketorder> blanketorders =blanketorderMapper.getblanketorderList(blanketorderQuery,creatime);
            Long count = blanketorderMapper.getCount(blanketorderQuery,creatime);
            System.out.println("count = " + count);
            return Result.success(blanketorders,count);
        }
    }
}




