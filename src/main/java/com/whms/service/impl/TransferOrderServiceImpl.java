package com.whms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.whms.common.Result;
import com.whms.entity.TransferDetail;
import com.whms.entity.TransferOrder;
import com.whms.entity.vo.ToWarehouseUserVO;
import com.whms.mapper.TransferDetailMapper;
import com.whms.mapper.TransferOrderMapper;
import com.whms.service.TransferOrderService;
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
public class TransferOrderServiceImpl extends ServiceImpl<TransferOrderMapper, TransferOrder> implements TransferOrderService {

    @Resource
    private TransferDetailMapper transferDetailMapper;
    @Override
    @Transactional
    public Result orderWithDetail(TransferOrder order, List<TransferDetail> list) {
        baseMapper.insert(order);
        Integer poid = order.getToid();
        for(TransferDetail td : list){
            td.setToid(poid);
            transferDetailMapper.insert(td);
        }
        return Result.success();
    }

    @Override
    public IPage<ToWarehouseUserVO> pageFullInfo(IPage<ToWarehouseUserVO> page, QueryWrapper<ToWarehouseUserVO> wrapper) {
        return baseMapper.pageFullInfo(page, wrapper);
    }
}
