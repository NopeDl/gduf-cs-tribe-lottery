package com.bigliang.draw.utils;

import org.apache.commons.lang.RandomStringUtils;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/8/31 14:42
 */

public final class TokenUtil {
    /**
     * token工具，获取一个字母与数字混合的随机字符串，拼接上当前的时间戳之后组成一个token
     * @return
     */
    public static String getToken() {
        return RandomStringUtils.randomAlphanumeric(8) + System.currentTimeMillis();
    }
}
