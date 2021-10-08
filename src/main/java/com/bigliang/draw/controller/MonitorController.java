package com.bigliang.draw.controller;

import com.bigliang.draw.cache.IPCache;
import com.bigliang.draw.cache.LoginUsers;
import com.bigliang.draw.cache.WinningCache;
import com.bigliang.draw.entity.Prize;
import com.bigliang.draw.utils.LotteryUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/9/1 23:33
 */

@RestController
@RequestMapping("/monitor")
public class MonitorController {

    @RequestMapping("/loginUsers")
    public ConcurrentHashMap<String, String> loginUsers() {
        return LoginUsers.getLoginUsers();
    }

    @RequestMapping("/winningUsers")
    public ConcurrentHashMap<String, Long> winningUsers() {
        return WinningCache.getWinningMap();
    }

    @RequestMapping("/prizePool")
    public List<Prize> prizesPool() {
        return LotteryUtil.prizeList;
    }

    @RequestMapping("/ipCache")
    public ConcurrentHashMap<String, String> ipCache() {
        return IPCache.getIpcache();
    }

    @GetMapping("/clean")
    public String clean() {
        LoginUsers.clean();
        IPCache.clean();
        return "<script type='text/javascript'>alert('缓存已清空！');</script>";
    }

}
