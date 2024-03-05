package com.xiaohuang.service;

import com.xiaohuang.pojo.Monthly;
import com.xiaohuang.pojo.Order;
import com.xiaohuang.pojo.Orderform;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xiaohuang.pojo.User;
import com.xiaohuang.utils.Result;
import com.xiaohuang.vo.PeicanQuery;
import org.springframework.ui.Model;

import java.util.List;

/**
* @author changle
* @description 针对表【c_orderform】的数据库操作Service
* @createDate 2023-12-09 14:05:33
*/
public interface OrderformService extends IService<Orderform> {

    int addOrderForm(String ids, User userInfo);

    List<Orderform> getOrderform(Integer uid);

    List<Order> getOrder(List<Orderform> orderform);

    List<Monthly> peicanorderlist(String creatime);

    List<Integer> getUids(String creatime);

    Result getpeicanorderList(PeicanQuery peicanQuery, Model model);
}
