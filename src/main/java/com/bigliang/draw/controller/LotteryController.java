package com.bigliang.draw.controller;

import com.bigliang.draw.cache.IPCache;
import com.bigliang.draw.cache.LoginUsers;
import com.bigliang.draw.cache.WinningCache;
import com.bigliang.draw.entity.Prize;
import com.bigliang.draw.protocol.PrizeEnum;
import com.bigliang.draw.utils.IPUtil;
import com.bigliang.draw.utils.LotteryUtil;
import com.bigliang.draw.utils.TaskUtil;
import com.bigliang.draw.vo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/8/29 17:46
 */

@RestController
public class LotteryController {
    private static Logger logger = LoggerFactory.getLogger(com.bigliang.draw.controller.LotteryController.class);
    @Autowired
    private JedisPool jedisPool;

    /**
     * 抽奖
     * @param request
     * @return
     */
    @PostMapping("/begin")
    public Result begin(HttpServletRequest request) {
        Prize prize = LotteryUtil.beginLottery();
        //先声明一个未就绪的返回结果
        Result feedback = new Result();
        if (prize.getPgrade() < 4) {
            long result = cutPrize(PrizeEnum.getPrizeTypeByLevel(prize.getPgrade()));
            if (result > -1) {
                //设置返回结果的中奖参数
                feedback.setWinning(true);
                //设置中奖结果的等级
                feedback.setPrizeGrade(prize.getPgrade());
            } else {
                //中奖但是奖品开完了，降级处理
                feedback.setWinning(false);
                feedback.setPrizeGrade(4);
            }
        } else {
            //本来就没中奖
            feedback.setWinning(false);
            feedback.setPrizeGrade(4);
        }
        //调用异步线程来处理日志任务
        String token = request.getHeader("Authorization");
        String ip = IPUtil.getClientIp(request);
        task(token, ip, feedback.isWinning(), feedback.getPrizeGrade());
        //统一设置本次抽奖请求的code
        feedback.setCode(200);
        //将就绪结果返回
        return feedback;
    }

    /**
     * 获取本次请求开奖的结果
     * @param prizeType 中奖的类型
     * @return 返回是否能否中奖，如果没有中奖的话就返回降级的结果
     */
    private long cutPrize(String prizeType) {
        long result = -1;
        try (Jedis jedis = jedisPool.getResource()) {
            result = jedis.decr(prizeType);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return result;
    }

    /**
     * 异步任务，请求接入之后，出来结果之后立即返回，异步任务负责记录日志
     * @param token 本次接入的请求附带的token
     * @param ip ip地址
     * @param isHit 是否中奖
     * @param prizeLevel 中奖的等级
     */
    private void task(String token, String ip, boolean isHit, long prizeLevel) {
        TaskUtil.execute(() -> {
            String phone = LoginUsers.getLoginUserByToken(token);
            IPCache.addPhone(ip, phone);
            if (isHit) {
                WinningCache.addUser(phone, prizeLevel);
            }
        });
    }

}
