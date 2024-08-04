package com.whms.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.whms.entity.User;
import com.whms.entity.bo.DayPurchaseSale;
import com.whms.entity.bo.TotalCostSale;
import com.whms.mapper.UserMapper;
import com.whms.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author whms
 * @since 2024-03-17
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;
    @Override
    public IPage pageC(IPage<User> page) {
        return userMapper.pageC(page);
    }

    @Override
    public List<DayPurchaseSale> listDayPurchaseSale() {
        return userMapper.listDayPurchaseSale();
    }

    @Override
    public TotalCostSale getTotalCostSale() {
        return userMapper.getTotalCostSale();
    }
}
