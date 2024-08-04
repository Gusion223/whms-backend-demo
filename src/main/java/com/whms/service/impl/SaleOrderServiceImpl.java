package com.whms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.whms.common.Result;
import com.whms.entity.SaleDetail;
import com.whms.entity.SaleOrder;
import com.whms.entity.vo.SoWarehouseCustomerUserVO;
import com.whms.mapper.SaleDetailMapper;
import com.whms.mapper.SaleOrderMapper;
import com.whms.service.SaleOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author whms
 * @since 2024-06-15
 */
@Service
public class SaleOrderServiceImpl extends ServiceImpl<SaleOrderMapper, SaleOrder> implements SaleOrderService {

    @Resource
    private SaleDetailMapper saleDetailMapper;
    @Override
    @Transactional
    public Result orderWithDetail(SaleOrder order, List<SaleDetail> list) {
        baseMapper.insert(order);
        Integer soid = order.getSoid();
        for(SaleDetail sd : list){
            sd.setSoid(soid);
            saleDetailMapper.insert(sd);
        }
        return Result.success();
    }

    public IPage<SoWarehouseCustomerUserVO> pageFullInfo(IPage<SoWarehouseCustomerUserVO> page, QueryWrapper<SoWarehouseCustomerUserVO> wrapper){
        return baseMapper.pageFullInfo(page, wrapper);
    }

}
