package com.xiaohuang.controller;


import com.alibaba.druid.util.StringUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xiaohuang.pojo.User;
import com.xiaohuang.service.UserService;
import com.xiaohuang.utils.Result;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 登录
     * @param
     * @return 返回1 登录成功，返回0 账号不存在，返回2 密码错误
     */
    @PostMapping("login")
    public Result login(User user,HttpSession session)
    {
        User user1=userService.login(user);
        session.setAttribute("userInfo",user1);
        if(user1==null)
        {
            return Result.fail("账号不存在");
        }
        if(!StringUtils.isEmpty(user.getPassword())
                && user1.getPassword().equals(user.getPassword()))
        {
            Map data=new HashMap<>();
            data.put("role",user1.getRole());
            return Result.success(data,null);
        }
        return Result.fail("密码错误");
    }
}
