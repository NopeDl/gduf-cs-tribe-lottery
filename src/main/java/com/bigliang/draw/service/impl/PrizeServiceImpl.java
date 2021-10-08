package com.bigliang.draw.service.impl;

import com.bigliang.draw.entity.Prize;
import com.bigliang.draw.mapper.PrizeDao;
import com.bigliang.draw.service.PrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 大雨两点
 * @version 1.0
 * @date 2020/8/29 17:50
 */

@Service
public class PrizeServiceImpl implements PrizeService {
    @Autowired(required = false)
    PrizeDao prizeDao;

    /**
     * 获取奖品列表
     * @return
     */
    @Override
    public List<Prize> getPrizes() {
        return prizeDao.getPrizes();
    }

    /**
     * 中奖之后将奖品数减一
     * @return
     */
    @Override
    public int drawPrize(long pid) {
        return prizeDao.drawPrize(pid);
    }
}
