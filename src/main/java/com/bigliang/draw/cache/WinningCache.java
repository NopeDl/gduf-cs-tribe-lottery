package com.bigliang.draw.cache;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/8/31 20:33
 * 中奖者信息
 */

public class WinningCache {
    private static ConcurrentHashMap<String, Long> winningMap = new ConcurrentHashMap<>();

    public static void addUser(String phone, long prizeLevel) {
        winningMap.put(phone, prizeLevel);
    }

    public static ConcurrentHashMap<String, Long> getWinningMap() {
        return winningMap;
    }
}
