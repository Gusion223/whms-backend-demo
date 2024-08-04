package com.whms.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.github.jeffreyning.mybatisplus.base.MppBaseMapper;
import com.whms.entity.PurchaseDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.whms.entity.vo.PdGoodVO;
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
public interface PurchaseDetailMapper extends MppBaseMapper<PurchaseDetail> {

    @Select("SELECT pd.*, g.gname FROM purchase_detail pd LEFT JOIN good g ON pd.gid=g.gid ${ew.customSqlSegment} ")
    IPage<PdGoodVO> pageFullInfo(IPage<PdGoodVO> page, @Param(Constants.WRAPPER) QueryWrapper<PdGoodVO> wrapper);
}
