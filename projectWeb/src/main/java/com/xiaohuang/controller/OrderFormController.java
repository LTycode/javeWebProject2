package com.xiaohuang.controller;


import com.xiaohuang.pojo.Monthly;
import com.xiaohuang.pojo.Order;
import com.xiaohuang.pojo.Orderform;
import com.xiaohuang.pojo.User;
import com.xiaohuang.service.OrderformService;
import com.xiaohuang.service.UserService;
import com.xiaohuang.utils.Result;
import com.xiaohuang.vo.HistoricalmenuQuery;
import com.xiaohuang.vo.PeicanQuery;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("orderform")
public class OrderFormController {

    @Autowired
    private OrderformService orderformService;
    @Autowired
    private UserService userService;

    /**
     *  var url = ctxPath + "orderform/" + idArr.join(",");
     * @param ids 将点餐表的数据添加到订单表中，并将之前点餐表隐藏
     * @return
     */
    @PostMapping("/{ids}")
    @ResponseBody
    public Result addOrderForm(@PathVariable("ids") String ids, HttpSession session)
    {
        User userInfo =(User) session.getAttribute("userInfo");
        int i=orderformService.addOrderForm(ids,userInfo);
        System.out.println("userInfo = " + userInfo);
//        orderformService.addOrderForm(ids)
        if(i!=0)
        {
            return Result.success("创建成功");
        }
        return Result.fail("创建失败");
    }
    @GetMapping("orderformui")
    public String getOrderformUi(Model model,HttpSession session)
    {
        //获取登录的user的数据
        User userInfo =(User) session.getAttribute("userInfo");
        //获取登录的userid
        Integer uid = userInfo.getUid();
        //查找订单表是当天的而且是登录的用户的订单
        List<Orderform> orderform=orderformService.getOrderform(uid);
        if(orderform.isEmpty())
        {
            //如果当天没有这个用户的订单则跳转到点餐页面
            return "utils";
        }
        //根据找到的订单中的点餐表的id找出点的菜
        List<Order> orders=orderformService.getOrder(orderform);

        model.addAttribute("orderform",orderform);
        model.addAttribute("orders",orders);
        model.addAttribute("User",userInfo);
        return "orderform/myorderform";
    }
    @GetMapping("peicanorder1")
    public String getpeicanorderformUi(Model model,HttpSession session)
    {
        //获取登录的user的数据
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String creatime = localDate.format(formatter);
        List<Monthly> monthlies= orderformService.peicanorderlist(creatime);
        List<Integer> lists=orderformService.getUids(creatime);
        List<User> users=userService.getUsers(lists);
        if(monthlies.isEmpty())
        {
            //如果当天没有这个用户的订单则跳转到点餐页面
            return "utils";
        }
        model.addAttribute("Users",users);
        model.addAttribute("monthlies",monthlies);
        return "orderform/peicanorderList";
    }

    @GetMapping("peicanorder")
    public String toMonthlystatisticsListUI()
    {

        return "orderform/peicanorderList";
    }


    @GetMapping("getpeicanorderList")
    @ResponseBody
    public Result getpeicanorderList(PeicanQuery peicanQuery,Model model)
    {
        Result result=orderformService.getpeicanorderList(peicanQuery,model);

        return result;
    }


}
