package com.bigliang.draw.utils;

import java.util.regex.Pattern;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/11/16 14:58
 */

public final class PhoneUtil {
    public static boolean check(String phone) {
        return phone.matches("^1[3|4|5||7|8][0-9]{9}$") ? true : false;
    }
}
