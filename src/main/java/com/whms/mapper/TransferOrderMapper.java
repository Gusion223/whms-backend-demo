package com.whms.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.whms.entity.TransferOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.whms.entity.vo.ToWarehouseUserVO;
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
public interface TransferOrderMapper extends BaseMapper<TransferOrder> {
    @Select("SELECT tro.*, wp.wname as wname_prev, wc.wname as wname_cur, u.nick_name FROM transfer_order tro " +
            "LEFT JOIN warehouse wp ON wp.wid=wid_prev " +
            "LEFT JOIN warehouse wc ON wc.wid=wid_cur " +
            "LEFT JOIN user u ON u.id=tro.id ${ew.customSqlSegment}  ")
    IPage<ToWarehouseUserVO> pageFullInfo(IPage<ToWarehouseUserVO> page, @Param(Constants.WRAPPER)QueryWrapper<ToWarehouseUserVO> wrapper);

}
