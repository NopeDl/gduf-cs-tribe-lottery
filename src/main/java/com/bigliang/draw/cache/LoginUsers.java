package com.bigliang.draw.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/8/31 14:32
 */

public class LoginUsers {
    private static final Logger logger = LoggerFactory.getLogger(LoginUsers.class);
    private static ConcurrentHashMap<String, String> loginUser = new ConcurrentHashMap<>(100);

    /**
     * 根据token获取登录的用户
     * @param token 令牌
     * @return
     */
    public static String getLoginUserByToken(String token) {
        String phone = null;
        try {
            phone = loginUser.get(token);
        } catch (NullPointerException e) {
            logger.debug("空指针异常：" + e);
            return phone;
        } finally {
            return phone;
        }
    }

    /**
     * 将新登录的用户加入缓存中
     * @param phone
     * @param token
     */
    public static void addUser(String token, String phone) {
        loginUser.put(token, phone);
    }

    /**
     * 获取所有已经登录的用户
     * @return
     */
    public static ConcurrentHashMap<String, String> getLoginUsers() {
        return loginUser;
    }

    /**
     * 清空缓存
     */
    public static void clean() {
        loginUser.clear();
    }

}
