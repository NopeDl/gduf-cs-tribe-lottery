package com.bigliang.draw.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/11/16 14:23
 * 处理预请求
 */

public class HeaderInterceptor implements HandlerInterceptor {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final String OPTIONS_METHODS = "OPTIONS";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //设置请求头过滤器
        logger.debug("请求头拦截器开始干活啦....");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type,Access-Token,Authorization");
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, PATCH, OPTIONS");
        resp.setHeader("Cache-Control", "no-cache");
        String method = req.getMethod();
        if (OPTIONS_METHODS.equals(method)) {
            resp.setStatus(200);
        }
        logger.debug("请求头拦截器任务完成....");
        return true;
    }
}
