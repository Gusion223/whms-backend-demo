package com.whms.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.whms.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.whms.entity.bo.DayPurchaseSale;
import com.whms.entity.bo.TotalCostSale;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author whms
 * @since 2024-03-17
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    IPage<User> pageC(IPage<User> page);


    @Select("call last7day_purchase_and_sale()")
    List<DayPurchaseSale> listDayPurchaseSale();

    TotalCostSale getTotalCostSale();
}
