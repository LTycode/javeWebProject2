package com.xiaohuang.service;

import com.xiaohuang.pojo.Menu;
import com.xiaohuang.pojo.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaohuang.utils.Result;
import com.xiaohuang.vo.MenuQurey;
import com.xiaohuang.vo.OrderQuery;

/**
* @author changle
* @description 针对表【c_order】的数据库操作Service
* @createDate 2023-12-09 14:05:33
*/
public interface OrderService extends IService<Order> {

    int joinOrder(Menu menu, Integer odcount);

    Result getOrderList(OrderQuery orderQuery);

    Result updateOrderByIdAndCount(String id,Integer count);

    Result deleteOrderById(String id);

    Result addorderList(MenuQurey menuQurey);

    Result deleteOrderByIds(String ids);
}
