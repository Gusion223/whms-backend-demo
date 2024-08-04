package com.whms.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.whms.common.Result;
import com.whms.entity.PurchaseDetail;
import com.whms.entity.PurchaseOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.whms.entity.vo.PoWarehouseSupplierUserVO;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author whms
 * @since 2024-06-15
 */
public interface PurchaseOrderService extends IService<PurchaseOrder> {
    @Transactional
    Result orderWithDetail(PurchaseOrder order, List<PurchaseDetail> list);

    IPage<PoWarehouseSupplierUserVO> pageFullInfo(IPage<PoWarehouseSupplierUserVO> page, QueryWrapper<PoWarehouseSupplierUserVO> wrapper);
}
