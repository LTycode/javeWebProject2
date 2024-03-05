package com.xiaohuang.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 获取session， 判断session用户信息是否存在
        Object user = request.getSession().getAttribute("userInfo");
        if(user == null){
            // 未登录
            log.debug("未登录请求：" + request.getRequestURI());
            response.sendRedirect(request.getContextPath() + "/login");
            return false;
        }
        log.debug("放行请求：" + request.getRequestURI());
        return true;
    }

}
