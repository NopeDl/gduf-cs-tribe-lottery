package com.bigliang.draw.vo;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/8/31 16:04
 */

public class Result {
    /**
     * 是否中奖
     */
    private boolean winning;
    /**
     * 中奖等级
     */
    private long prizeGrade;

    /**
     * 是否已经抽奖
     */
    private boolean lotteried = true;

    /**
     * 错误信息
     */
    private String message;

    private long code;

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Result() {

    }

    public boolean isWinning() {
        return winning;
    }

    public void setWinning(boolean winning) {
        this.winning = winning;
    }

    public Result(boolean winning, long prizeGrade, long code) {
        this.winning = winning;
        this.prizeGrade = prizeGrade;
        this.code = code;
    }

    public boolean isLotteried() {
        return lotteried;
    }

    public void setLotteried(boolean lotteried) {
        this.lotteried = lotteried;
    }

    public long getPrizeGrade() {
        return prizeGrade;
    }

    public void setPrizeGrade(long prizeGrade) {
        this.prizeGrade = prizeGrade;
    }
}
