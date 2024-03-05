package com.xiaohuang.controller;


import com.xiaohuang.utils.JwtHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TestController {

    @Autowired
    private JwtHelper jwtHelper;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @GetMapping("login")
    public String tologin(){
        logger.info("定向登陆页");
        return "login";
    }


    @RequestMapping("home")
    public String tohome(){
        return "home";
    }

    @RequestMapping("peican")
    public String topeican(){
        return "peican";
    }
    @RequestMapping("caiwu")
    public String tocaiwu(){
        return "caiwu";
    }
    @RequestMapping("employee")
    public String toemployee(){
        return "employee";
    }
    @RequestMapping("chufang")
    public String tochufang(){
        return "chufang";
    }
    @GetMapping("welcome")
    public String welcome()
    {
            return "welcome";
    }
}
