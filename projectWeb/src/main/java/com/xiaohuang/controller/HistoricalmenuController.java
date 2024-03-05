package com.xiaohuang.controller;

import com.xiaohuang.service.HistoricalmenuService;
import com.xiaohuang.utils.Result;
import com.xiaohuang.vo.HistoricalmenuQuery;
import com.xiaohuang.vo.RecipeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("historicalmenu")
public class HistoricalmenuController {


    @Autowired
    private HistoricalmenuService historicalmenuService;
    @GetMapping("")
    public String toHistoricalmenuListUI()
    {
        return "historicalmenu/historicalmenuList";
    }

    @GetMapping("historicalmenulist")
    @ResponseBody
    public Result historicalmenuList(HistoricalmenuQuery historicalmenuQuery)
    {
        Result result=historicalmenuService.historicalmenuList(historicalmenuQuery);

        return result;
    }

}
