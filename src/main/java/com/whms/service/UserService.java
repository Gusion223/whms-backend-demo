package com.whms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.whms.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.whms.entity.bo.DayPurchaseSale;
import com.whms.entity.bo.TotalCostSale;
import com.whms.mapper.UserMapper;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author whms
 * @since 2024-03-17
 */
public interface UserService extends IService<User> {
    IPage pageC(IPage<User> page);
    List<DayPurchaseSale> listDayPurchaseSale();

    TotalCostSale getTotalCostSale();
}
