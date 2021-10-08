package com.bigliang.draw.utils;


import com.bigliang.draw.entity.Lottery;
import com.bigliang.draw.entity.Prize;
import com.bigliang.draw.service.PrizeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.PrivateKey;
import java.util.List;
import java.util.Random;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/8/20 22:46
 */

public class LotteryUtil {
    private static Logger logger = LoggerFactory.getLogger(com.bigliang.draw.utils.LotteryUtil.class);
    private static final Random random = new Random();
    private static final Integer MAXSOPE = 100000000;
    public static final Lottery lottery = new Lottery();
    public static List<Prize> prizeList = null;

    /**
     * 获取开奖范围
     *
     * @param lottery   记录本次抽奖信息
     * @param prizeList
     */
    private static void calAwardProbability(Lottery lottery, List<Prize> prizeList) {
        Integer codeScope = 1;
        for (Prize prize : prizeList) {
            Integer nowScope = 1;
            //获取中奖概率
            Double awardProbability = prize.getPweight();
            while (true) {
                Double test = awardProbability * nowScope;
                // 概率的精确度，调整到小数点后10位，概率太小等于不中奖，跳出
                if (test < 0.0000000001) {
                    break;
                }
                if ((test >= 1L && (test - test.longValue()) < 0.0001D) || nowScope >= MAXSOPE) {
                    if (nowScope > codeScope) {
                        // 设置中奖范围
                        codeScope = nowScope;
                    }
                    break;
                } else {
                    // 中奖数字范围以10倍进行增长
                    nowScope = nowScope * 10;
                }
            }
        }
        Integer winningStartCode = 0;
        Integer winningEndCode = winningStartCode;

        for (Prize prize : prizeList) {
            Integer codeNum = (int) (prize.getPweight() * codeScope); // 获得其四舍五入的整数值
            // 无人中奖时，将中奖的起始范围设置在随机数的范围之外
            if (codeNum == 0) {
                prize.setStartCode(codeScope + 1);
                prize.setEndCode(codeScope + 1);
            } else {
                prize.setStartCode(winningEndCode);
                prize.setEndCode(winningEndCode + codeNum - 1);
                winningEndCode = winningEndCode + codeNum;
            }
        }
        // 设置用户的中奖随机码信息
        lottery.setWinningStartCode(winningStartCode);
        lottery.setWinningEndCode(winningEndCode);
        lottery.setCodeScope(codeScope);
    }

    /**
     * 开始判奖
     * @return
     */
    public static Prize beginLottery() {
        // 确定活动是否有效,如果活动无效则，直接抽奖失败
        Integer randomCode = random.nextInt(lottery.getCodeScope());
        if (randomCode >= lottery.getWinningStartCode() && randomCode <= lottery.getWinningEndCode()) {
            for (Prize prize : prizeList) {
                if (randomCode >= prize.getStartCode() && randomCode <= prize.getEndCode()) {
                    prize.setHitCode(randomCode);
                    return prize;
                }
            }
        }
        return null;
    }

    /**
     * 初始化
     *
     */
    public static void init(List<Prize> prizes) {
        prizeList = prizes;
        calAwardProbability(lottery, prizeList);
    }
}