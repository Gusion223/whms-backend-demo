package com.whms.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.github.jeffreyning.mybatisplus.base.MppBaseMapper;
import com.whms.entity.SaleDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.whms.entity.vo.SdGoodVO;
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
public interface SaleDetailMapper extends MppBaseMapper<SaleDetail> {
    @Select("SELECT sd.*, g.gname FROM sale_detail sd LEFT JOIN good g ON sd.gid=g.gid ${ew.customSqlSegment} ")
    IPage<SdGoodVO> pageFullInfo(IPage<SdGoodVO> page, @Param(Constants.WRAPPER)QueryWrapper<SdGoodVO> wrapper);

}
