package com.whms.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.whms.common.QueryParam;
import com.whms.common.Result;
import com.whms.entity.TransferDetail;
import com.whms.entity.TransferOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.whms.entity.vo.ToWarehouseUserVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author whms
 * @since 2024-06-15
 */
public interface TransferOrderService extends IService<TransferOrder> {

    Result orderWithDetail(TransferOrder order, List<TransferDetail> list);

    IPage<ToWarehouseUserVO> pageFullInfo(IPage<ToWarehouseUserVO> page, QueryWrapper<ToWarehouseUserVO> wrapper);
}
