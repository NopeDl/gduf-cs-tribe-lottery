package com.bigliang.draw.interceptor;

import com.bigliang.draw.cache.LoginUsers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/11/16 15:21
 */

public class LoginInterceptor implements HandlerInterceptor {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final String POST_METHOD = "POST";
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.debug("登录校验中....");
        String method = request.getMethod();
        if (!POST_METHOD.equals(method)) {
            response.setContentType("text/json;charset=UTF-8");
            response.getWriter().write("{\"code\": 4000, \"message\": \"非法登录！\"}");
            return false;
        }
        String token = request.getHeader("Authorization");
        if (token == null) {
            response.setContentType("text/json;charset=UTF-8");
            response.getWriter().write("{\"code\": 4000, \"message\": \"请先授权登录，谢谢！\"}");
            return false;
        }
        String phone = LoginUsers.getLoginUserByToken(token);
        if (phone == null) {
            response.setContentType("text/json;charset=UTF-8");
            response.getWriter().write("{\"code\": 4000, \"message\": \"请先授权登录，谢谢！\"}");
            return false;
        } else {
            return true;
        }
    }
}
