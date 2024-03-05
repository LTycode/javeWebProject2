package com.xiaohuang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaohuang.pojo.Menu;
import com.xiaohuang.pojo.Order;
import com.xiaohuang.service.OrderService;
import com.xiaohuang.mapper.OrderMapper;
import com.xiaohuang.utils.Result;
import com.xiaohuang.vo.MenuQurey;
import com.xiaohuang.vo.OrderQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
* @author changle
* @description 针对表【c_order】的数据库操作Service实现
* @createDate 2023-12-09 14:05:33
*/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService{
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public int joinOrder(Menu menu, Integer odcount) {
        Double sum = menu.getMprice()*odcount;

        int i=orderMapper.joinOrder(menu,odcount,sum);
        return 0;
    }

    @Override
    public Result getOrderList(OrderQuery orderQuery) {
        List<Order> orders=orderMapper.getOrderList(orderQuery);
        System.out.println("orders = " + orders);
        Long count = orderMapper.getCount(orderQuery);

        return Result.success(orders,count);
    }

    @Override
    public Result updateOrderByIdAndCount(String id,Integer count) {
        Order order = orderMapper.queryById(id);
        order.setOcount(String.valueOf(count));
        order.setOsomeprice(count*(order.getOprice()));
        System.out.println("order = " + order.getOsomeprice());
        int i=orderMapper.updateOrder(order);
        return Result.success("修改成功！");
    }

    @Override
    public Result deleteOrderById(String id) {
        System.out.println("id = " + id);
       int i= orderMapper.deleteOrderById(id);
        return Result.success("删除成功");
    }

    @Override
    public Result addorderList(MenuQurey menuQurey) {

        List<Menu> menus=orderMapper.addorderList(menuQurey);
        int size = menus.size();
        return Result.success(menus, (long) size);
    }

    @Override
    public Result deleteOrderByIds(String ids) {
        int i= orderMapper.deleteOrderByIds(ids);
        return Result.success("删除成功！");
    }
}




