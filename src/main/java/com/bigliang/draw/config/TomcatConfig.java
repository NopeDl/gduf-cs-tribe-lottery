package com.bigliang.draw.config;

import org.apache.catalina.connector.Connector;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.ConfigurableTomcatWebServerFactory;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/11/16 21:42
 * 自定义tomcat配置，但是在配置文件中做了相关的配置，这里就先不使用
 */
//TODO 未被使用的tomcat配置
//@Configuration
public class TomcatConfig {
    @Value("${server.port}")
    private int port;

//    @Bean
    public ConfigurableTomcatWebServerFactory configurableTomcatWebServerFactory() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addAdditionalTomcatConnectors(createConnector());
        return tomcat;
    }

    public Connector createConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
        //设置端口
        connector.setPort(port);
        //设置最大线程数
        protocol.setMaxThreads(500);
        //设置最大连接数
        protocol.setMaxConnections(1000);
        //设置可以接受的数量
        protocol.setAcceptCount(800);
        //设置线程最小空闲时间
        protocol.setMinSpareThreads(500);

        //设置超时时间
        protocol.setConnectionTimeout(5000);
        //设置保持连接的时长
        protocol.setKeepAliveTimeout(5000);

        return connector;
    }
}
