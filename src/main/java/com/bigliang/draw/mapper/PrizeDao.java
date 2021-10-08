package com.bigliang.draw.mapper;

import com.bigliang.draw.entity.Prize;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface PrizeDao {
    /**
     * 获取奖品列表
     * @return
     */
    @Select(value = "select * from prize")
    List<Prize> getPrizes();

    /**
     * 扣除开出的奖项
     * @param pid 奖品的id
     * @return 返回受影响的行数
     */
    @Update(value = "update prize set pcount = pcount - 1 where pid = #{pid} and pcount > 0")
    int drawPrize(long pid);
}
