package com.whms.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.whms.entity.PurchaseOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.whms.entity.vo.PoWarehouseSupplierUserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author whms
 * @since 2024-06-15
 */
@Mapper
public interface PurchaseOrderMapper extends BaseMapper<PurchaseOrder> {


    @Select("SELECT s.*, w.*, po.poid, po.potime, pototal_cost, u.nick_name, u.id FROM purchase_order po " +
            "LEFT JOIN supplier s ON s.sid=po.sid " +
            "LEFT JOIN warehouse w ON w.wid=po.wid " +
            "LEFT JOIN user u ON u.id=po.id ${ew.customSqlSegment}")
    IPage<PoWarehouseSupplierUserVO> pageFullInfo(IPage<PoWarehouseSupplierUserVO> page, @Param(Constants.WRAPPER) QueryWrapper<PoWarehouseSupplierUserVO> wrapper);
}
