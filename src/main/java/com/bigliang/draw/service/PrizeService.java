package com.bigliang.draw.service;

import com.bigliang.draw.entity.Prize;

import java.util.List;

public interface PrizeService {
    /**
     * 获取奖品列表
     * @return
     */
    List<Prize> getPrizes();

    /**
     * 中奖之后将奖品数减一
     * @return
     */
    int drawPrize(long pid);
}
