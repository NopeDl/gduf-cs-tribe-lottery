package com.bigliang.draw.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/11/17 16:30
 * 设置默认首页类
 */

@Configuration
public class IndexConfig implements WebMvcConfigurer {
    /**
     * 当外部访问根路径、index、index.html都将自动跳转static
     * 文件夹下面的首页
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("/index.html");
        registry.addViewController("/index").setViewName("/index.html");
    }
}
