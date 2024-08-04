package com.whms.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.whms.common.Result;
import com.whms.entity.SaleDetail;
import com.whms.entity.SaleOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.whms.entity.vo.PoWarehouseSupplierUserVO;
import com.whms.entity.vo.SoWarehouseCustomerUserVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author whms
 * @since 2024-06-15
 */
public interface SaleOrderService extends IService<SaleOrder> {

    @Transactional
    Result orderWithDetail(SaleOrder order, List<SaleDetail> list);

    IPage<SoWarehouseCustomerUserVO> pageFullInfo(IPage<SoWarehouseCustomerUserVO> page, QueryWrapper<SoWarehouseCustomerUserVO> wrapper);

}
