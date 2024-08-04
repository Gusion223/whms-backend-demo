package com.whms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.whms.common.Result;
import com.whms.entity.PurchaseDetail;
import com.whms.entity.PurchaseOrder;
import com.whms.entity.vo.PoWarehouseSupplierUserVO;
import com.whms.mapper.PurchaseDetailMapper;
import com.whms.mapper.PurchaseOrderMapper;
import com.whms.service.PurchaseOrderService;
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
public class PurchaseOrderServiceImpl extends ServiceImpl<PurchaseOrderMapper, PurchaseOrder> implements PurchaseOrderService {

    @Resource
    private PurchaseDetailMapper purchaseDetailMapper;
    @Override
    @Transactional
    public Result orderWithDetail(PurchaseOrder order, List<PurchaseDetail> list) {
        baseMapper.insert(order);
        Integer poid = order.getPoid();
        for(PurchaseDetail pd : list){
            pd.setPoid(poid);
            purchaseDetailMapper.insert(pd);
        }
        return Result.success();
    }

    @Override
    public IPage<PoWarehouseSupplierUserVO> pageFullInfo(IPage<PoWarehouseSupplierUserVO> page, QueryWrapper<PoWarehouseSupplierUserVO> wrapper) {
        return baseMapper.pageFullInfo(page, wrapper);
    }
}
