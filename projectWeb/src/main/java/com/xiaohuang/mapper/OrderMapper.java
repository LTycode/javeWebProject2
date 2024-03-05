package com.xiaohuang.mapper;

import com.xiaohuang.pojo.Menu;
import com.xiaohuang.pojo.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xiaohuang.vo.MenuQurey;
import com.xiaohuang.vo.OrderQuery;

import java.util.List;

/**
* @author changle
* @description 针对表【c_order】的数据库操作Mapper
* @createDate 2023-12-09 14:05:33
* @Entity com.xiaohuang.pojo.Order
*/
public interface OrderMapper extends BaseMapper<Order> {

    int joinOrder(Menu menu, Integer odcount,Double sum);

    List<Order> getOrderList(OrderQuery orderQuery);

    Long getCount(OrderQuery orderQuery);

    int updateOrderByIds(String id);

    Order queryById(String id);

    int updateOrder(Order order);

    int deleteOrderById(String id);

    Double querySumMoney(String ids);

    int setStatus(String ids);

    List<Order> getOrderByIds(String ids);


    List<Menu> addorderList(MenuQurey menuQurey);

    int deleteOrderByIds(String ids);
}




