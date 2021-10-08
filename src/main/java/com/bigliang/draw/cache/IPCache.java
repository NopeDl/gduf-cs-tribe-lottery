package com.bigliang.draw.cache;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/10/31 14:45
 */

public class IPCache {
    private static ConcurrentHashMap<String, String> ipcache = new ConcurrentHashMap<>(100);

    /**
     * 通过ip地址过去电话号码
     * @param ip 请求的IP地址
     * @return 返回该ip使用过的电话
     */
    public static String getPhoneByIp(String ip){
        return ipcache.get(ip);
    }

    /**
     * 将该访问ip与登录号码绑定，翻入缓存中
     * @param ip IP地址
     * @param phone 登录号码
     */
    public static void addPhone(String ip, String phone) {
        //todo IP缓存白名单
        if ("13825484651".equals(phone) || "13060621103".equals(phone)) {
            return;
        } else {
            ipcache.put(ip, phone);
        }
    }

    public static ConcurrentHashMap<String, String> getIpcache() {
        return ipcache;
    }

    public static void clean() {
        ipcache.clear();
    }
}
