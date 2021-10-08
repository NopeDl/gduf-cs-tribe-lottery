package com.bigliang.draw.interceptor;

import com.bigliang.draw.cache.IPCache;
import com.bigliang.draw.cache.LoginUsers;
import com.bigliang.draw.utils.IPUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/11/17 11:27
 */

public class RepeatDrawInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String phone = request.getParameter("phone");
        if (phone == null) {
            response.setContentType("text/json;charset=UTF-8");
            response.getWriter().write("{\"code\": 4000, \"message\": \"请先授权登录，谢谢！\"}");
            return false;
        }
        //TODO 拦截器白名单
        if (phone.equals("13825484651") || phone.equals("13060621103")) {
            return true;
        }
        Collection<String> collection = LoginUsers.getLoginUsers().values();
        if (collection.contains(phone)) {
            response.setContentType("text/json;charset=UTF-8");
            response.getWriter().write("{\"code\": 4003, \"message\": \"您的号码已经被登录过了！\"}");
            return false;
        }
        String ip = IPUtil.getClientIp(request);
        boolean isRepeat = IPCache.getIpcache().containsKey(ip);
        if (isRepeat) {
            response.setContentType("text/json;charset=UTF-8");
            response.getWriter().write("{\"code\": 4003, \"message\": \"您的IP已经被登录过了！\"}");
            return false;
        }
        return true;

    }
}
