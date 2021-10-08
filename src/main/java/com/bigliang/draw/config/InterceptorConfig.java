package com.bigliang.draw.config;

import com.bigliang.draw.interceptor.HeaderInterceptor;
import com.bigliang.draw.interceptor.LoginInterceptor;
import com.bigliang.draw.interceptor.RepeatDrawInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/11/16 14:35
 * 拦截器配置类
 */

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    /**
     * 设置请求头的拦截器，拦截所有的请求，除了请求页面的之外
     * 设置抽奖的拦截器，拦截非法登录的请求、无效的请求等
     * 设置登录的拦截器，拦截企图重复登录的请求
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HeaderInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/*.html");


        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/begin");


        registry.addInterceptor(new RepeatDrawInterceptor())
                .addPathPatterns("/login");
    }

}
