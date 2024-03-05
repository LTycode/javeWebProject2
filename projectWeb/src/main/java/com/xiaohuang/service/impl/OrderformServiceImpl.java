package com.xiaohuang.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xiaohuang.mapper.MonthlyMapper;
import com.xiaohuang.mapper.OrderMapper;
import com.xiaohuang.pojo.Monthly;
import com.xiaohuang.pojo.Order;
import com.xiaohuang.pojo.Orderform;
import com.xiaohuang.pojo.User;
import com.xiaohuang.service.OrderformService;
import com.xiaohuang.mapper.OrderformMapper;
import com.xiaohuang.utils.Result;
import com.xiaohuang.vo.PeicanPojo;
import com.xiaohuang.vo.PeicanQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
* @author changle
* @description 针对表【c_orderform】的数据库操作Service实现
* @createDate 2023-12-09 14:05:33
*/
@Service
public class OrderformServiceImpl extends ServiceImpl<OrderformMapper, Orderform>
    implements OrderformService{

    @Autowired
    private OrderformMapper orderformMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private MonthlyMapper monthlyMapper;

    @Override
    public int addOrderForm(String ids, User userInfo) {
        //获取订单总价
        Double odmoney=orderMapper.querySumMoney(ids);
        System.out.println("money = " + odmoney);
        String[] split = ids.split(",");
        //获该用户id
        Integer uid = userInfo.getUid();
        //创建时间
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String creatime = localDate.format(formatter);
//        String creatime ="2023-12-10";


        //创建对象
        Orderform orderform = new Orderform(0, uid, creatime, odmoney);
        for(String s:split)
        {
            Integer oid = Integer.parseInt(s);
            orderform.setOid(oid);
            //插入对象
            int i=orderformMapper.addOrderForm(orderform);
        }
        //将订单表创建完后，将数据放入到月度统计的表中，monthly中
        List<Monthly> monthlies=monthlyMapper.getList();
        //将数据插入表中//
        int s= monthlyMapper.insertMonthly(monthlies);
        //获取这个月这个用户的总金额
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM");
        String creatime1 = localDate.format(formatter1);
        double sumprice=monthlyMapper.selectSumSomeprice(uid,creatime1);
        //将数据插入表中
        int c=monthlyMapper.setSumprice(uid,creatime1,sumprice);

        //将点餐表的status置为0
       int i=orderMapper.setStatus(ids);
        return i;
    }

    @Override
    public List<Orderform> getOrderform(Integer uid) {
        //创建时间
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String creatime = localDate.format(formatter);
//        String creatime ="2023-12-10";
        LambdaQueryWrapper<Orderform> lambdaQueryWrapper
                =new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Orderform::getUid,uid).eq(Orderform::getCreatime,creatime);
        List<Orderform> orderforms = orderformMapper.selectList(lambdaQueryWrapper);

//        List<Orderform> orderforms = orderformMapper.selectOrderform(uid,creatime);
//        System.out.println("orderforms = " + orderforms);

        return orderforms;
    }

    @Override
    public List<Order> getOrder(List<Orderform> orderform) {
       String ids1="";
        for(Orderform o:orderform)
        {
            ids1=ids1+o.getOid()+",";
        }
        String ids = ids1.substring(0, ids1.length() - 1);
        List<Order> orders= orderMapper.getOrderByIds(ids);
        return orders;
    }

    @Override
    public List<Monthly> peicanorderlist(String creatime) {
        List<Monthly> monthlies=orderformMapper.peicanorderlist(creatime);
        return monthlies;
    }

    @Override
    public List<Integer> getUids(String creatime) {
        List<Integer> lists= orderformMapper.getUids(creatime);
        return lists;
    }

    @Override
    public Result getpeicanorderList(PeicanQuery peicanQuery, Model model) {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String creatime = localDate.format(formatter);
        List<PeicanPojo> peicanPojos= orderformMapper.getpeicanorderList(peicanQuery,creatime);
        String phone = peicanPojos.get(0).getPhone();
        model.addAttribute("phone",phone);
        if(peicanPojos.isEmpty())
        {
            return Result.success(null,0L);
        }
        int size = peicanPojos.size();
        return Result.success(peicanPojos, (long) size);
    }
}




