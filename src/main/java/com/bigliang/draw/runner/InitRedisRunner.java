package com.bigliang.draw.runner;

import com.bigliang.draw.entity.Prize;
import com.bigliang.draw.protocol.PrizeEnum;
import com.bigliang.draw.service.PrizeService;
import com.bigliang.draw.utils.LotteryUtil;
import com.bigliang.draw.utils.TaskUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.CharacterEncodingFilter;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/11/10 21:50
 */

@Component
public class InitRedisRunner implements CommandLineRunner {
    @Autowired
    private JedisPool jedisPool;
    @Autowired
    private PrizeService prizeService;
    @Autowired
    private CharacterEncodingFilter characterEncodingFilter;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 初始化任务类，在项目启动的时候负责将抽奖需要的数据初始化好
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        logger.debug("初始化资源中....");
        //TODO 初始化奖池的信息到redis中去
        List<Prize> prizes = prizeService.getPrizes();
        if (prizes == null) {
            logger.debug("资源初始化失败!");
            System.exit(0);
        }
        for (int i = 0; i < prizes.size(); i++) {
            Prize prize = prizes.get(i);
            if (prize.getPgrade() < 4) {
                TaskUtil.execute(() -> {
                    Jedis jedis = jedisPool.getResource();
                    jedis.select(0);
                    jedis.set(PrizeEnum.getPrizeTypeByLevel(prize.getPgrade()), prize.getPcount() + "");
                    StringBuilder sb = new StringBuilder("已将奖品");
                    sb.append(prize.getPgrade() +  ", 数量：" + prize.getPcount());
                    sb.append("传到redis中....");
                    logger.debug(sb.toString());
                });
            }
        }
        logger.debug("数据已经往redis上输送....");
        LotteryUtil.init(prizes);
        characterEncodingFilter.setEncoding("UTF-8");
        logger.debug("抽奖工具类就绪完毕....");
    }
}
