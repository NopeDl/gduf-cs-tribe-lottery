package com.bigliang.draw;

import com.bigliang.draw.cache.WinningCache;
import com.bigliang.draw.utils.TaskUtil;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Collection;

//@SpringBootTest
class DrawApplicationTests {
//    @Autowired
    private JedisPool jedisPool;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

//    @Test
    void contextLoads() {
    }

//    @Test
    void cut() {
        Jedis jedis = jedisPool.getResource();
        long result = jedis.decr("FIRST_PRIZE");
        logger.info("开奖结果：" + result);
        jedis.close();
    }

//    @Test
    void testMap() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            int a = i;
            TaskUtil.execute(() -> {
                WinningCache.addUser(a + "", a);
            });
        }
        Thread.sleep(300);
        logger.info(WinningCache.getWinningMap().size() + "======");
    }

}
