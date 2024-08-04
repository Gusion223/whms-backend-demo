package com.whms.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.whms.entity.SaleOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.whms.entity.vo.SoWarehouseCustomerUserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author whms
 * @since 2024-06-18
 */
@Mapper
public interface SaleOrderMapper extends BaseMapper<SaleOrder> {
    @Select("SELECT so.*, c.cname, w.wname, u.nick_name FROM sale_order so " +
            "LEFT JOIN customer c ON so.cid=c.cid " +
            "LEFT JOIN warehouse w ON so.wid=w.wid " +
            "LEFT JOIN user u ON so.id=u.id ${ew.customSqlSegment} ")
    IPage<SoWarehouseCustomerUserVO> pageFullInfo(IPage<SoWarehouseCustomerUserVO> page, @Param(Constants.WRAPPER)QueryWrapper<SoWarehouseCustomerUserVO> wrapper);
}
