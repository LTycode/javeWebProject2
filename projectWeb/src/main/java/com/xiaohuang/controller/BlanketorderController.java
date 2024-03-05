package com.xiaohuang.controller;


import com.xiaohuang.service.BlanketorderService;
import com.xiaohuang.utils.Result;
import com.xiaohuang.vo.BlanketorderQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("blanketorder")
public class BlanketorderController {

    @Autowired
    private BlanketorderService blanketorderService;

    /**
     * 跳转总括订单页面
     * @return
     */
    @GetMapping("")
    public String toBlanketorderListUI()
    {

        return "chufang/blanketorderList";
    }

    @GetMapping("blanketorderlist")
    @ResponseBody
    public Result getBlanketorderList(BlanketorderQuery blanketorderQuery)
    {
        Result result=blanketorderService.getBlanketorderList(blanketorderQuery);
        System.out.println("result = " + result);
        return result;
    }
}
