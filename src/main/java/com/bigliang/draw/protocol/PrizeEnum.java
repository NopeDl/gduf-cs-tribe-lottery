package com.bigliang.draw.protocol;

/**
 * @author 大雨两点
 * @time 2020.11.15
 */

public enum PrizeEnum {
    /**
     * 一等奖
     */
    FIRST_PRIZE("FIRST_PRIZE", 1),
    /**
     * 二等奖
     */
    SECOND_PRIZE("SECOND_PRIZE", 2),
    /**
     * 三等奖
     */
    THIRD_PRIZE("THIRD_PRIZE", 3),
    /**
     * 四等奖
     */
    FORTH_PRIZE("FORTH_PRIZE", 4);
    private String prizeType;
    private int prizeLevel;

    /**
     * 枚举构造器
     * @param prizeType 奖品类型
     * @param prizeLevel 奖品等级
     */
    PrizeEnum(String prizeType, int prizeLevel) {
        this.prizeType = prizeType;
        this.prizeLevel = prizeLevel;
    }

    /**
     * 获取奖品类型
     * @return
     */
    public String getPrizeType() {
        return this.prizeType;
    }

    /**
     * 获取奖品等级
     * @return
     */
    public int getPrizeLevel() {
        return this.prizeLevel;
    }

    /**
     * 根据奖品等级获取奖品类型
     * @param prizeLevel
     * @return
     */
    public static String getPrizeTypeByLevel(long prizeLevel) {
        if (prizeLevel == 1) {
            return FIRST_PRIZE.prizeType;
        } else if (prizeLevel == 2) {
                return SECOND_PRIZE.prizeType;
        } else if (prizeLevel == 3){
            return THIRD_PRIZE.prizeType;
        } else {
            return FORTH_PRIZE.prizeType;
        }
    }
}
