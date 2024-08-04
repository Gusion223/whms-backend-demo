package com.whms.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.github.jeffreyning.mybatisplus.base.MppBaseMapper;
import com.whms.entity.TransferDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.whms.entity.vo.TdGoodVO;
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
public interface TransferDetailMapper extends MppBaseMapper<TransferDetail> {
    @Select("SELECT td.*, g.gname FROM transfer_detail td LEFT JOIN good g ON td.gid=g.gid ${ew.customSqlSegment} ")
    IPage<TdGoodVO> pageFullInfo(IPage<TdGoodVO> page, @Param(Constants.WRAPPER)QueryWrapper<TdGoodVO> wrapper);

}
