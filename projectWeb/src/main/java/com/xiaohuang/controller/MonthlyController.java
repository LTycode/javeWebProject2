package com.xiaohuang.controller;

import com.xiaohuang.pojo.Monthly;
import com.xiaohuang.pojo.Order;
import com.xiaohuang.pojo.Orderform;
import com.xiaohuang.pojo.User;
import com.xiaohuang.service.MonthlyService;
import com.xiaohuang.utils.Result;
import com.xiaohuang.vo.HistoricalmenuQuery;
import com.xiaohuang.vo.PeicanQuery;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
@RequestMapping("monthly")
public class MonthlyController {

    @Autowired
    private MonthlyService monthlyService;
    @GetMapping("")
    public String toMonthlystatisticsListUI()
    {

        return "monthly/monthlyList";
    }

    @GetMapping("empmonthlist")
    public String toempmonthlistUI(Model model, HttpSession session)
    {
        //获取登录的user的数据
        User userInfo =(User) session.getAttribute("userInfo");
        //获取登录的userid
        Integer uid = userInfo.getUid();
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
        String creatime = localDate.format(formatter);
       List<Monthly> monthlies= monthlyService.empmonthlist(uid,creatime);
        if(monthlies.isEmpty())
        {
            //如果当天没有这个用户的订单则跳转到点餐页面
            return "utils";
        }
        monthlies.get(0).setCreatime(creatime);

        model.addAttribute("monthlies",monthlies);
        model.addAttribute("User",userInfo);
        return "monthly/empmonthlyList";
    }

    @GetMapping("getmonthlyList")
    @ResponseBody
    public Result monthlyList(HistoricalmenuQuery historicalmenuQuery)
    {
        Result result=monthlyService.monthlyList(historicalmenuQuery);

        return result;
    }


    @GetMapping("empmonthly")
    public String toempmonthlyListUI()
    {

        return "monthly/empmonthlyList";
    }
    @GetMapping("getempmonthlyList")
    @ResponseBody
    public Result getempmonthlyList(PeicanQuery peicanQuery)
    {
        Result result=monthlyService.getempmonthlyList(peicanQuery);

        return result;
    }
}
