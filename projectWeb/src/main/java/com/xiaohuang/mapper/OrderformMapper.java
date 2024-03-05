package com.xiaohuang.mapper;

import com.xiaohuang.pojo.Monthly;
import com.xiaohuang.pojo.Orderform;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaohuang.vo.PeicanPojo;
import com.xiaohuang.vo.PeicanQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author changle
* @description 针对表【c_orderform】的数据库操作Mapper
* @createDate 2023-12-09 14:05:33
* @Entity com.xiaohuang.pojo.Orderform
*/
public interface OrderformMapper extends BaseMapper<Orderform> {

    int addOrderForm(Orderform orderform);

    List<Orderform> selectOrderform(Integer uid, String creatime);


    List<Monthly> peicanorderlist(String creatime);

    List<Integer> getUids(String creatime);

    List<PeicanPojo> getpeicanorderList(@Param("peicanQuery")PeicanQuery peicanQuery, String creatime);
}




