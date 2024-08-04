package com.whms.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.github.jeffreyning.mybatisplus.base.MppBaseMapper;
import com.whms.entity.SG;
import com.whms.entity.vo.SGGoodSupplierVO;
import com.whms.entity.vo.SGGoodVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author whms
 * @since 2024-06-15
 */
@Mapper
public interface SGMapper extends MppBaseMapper<SG> {

    @Select("SELECT sg.sid, sg.gunit_cost, g.* FROM s_g sg LEFT JOIN good g ON sg.gid=g.gid ${ew.customSqlSegment}")
    List<SGGoodVO> listLJGoodInfo(@Param(Constants.WRAPPER) Wrapper wrapper);

    @Select("SELECT s.*, sg.gunit_cost, g.* FROM s_g sg " +
            "LEFT JOIN good g ON sg.gid = g.gid " +
            "LEFT JOIN supplier s ON sg.sid=s.sid ${ew.customSqlSegment}")
    IPage<SGGoodSupplierVO> pageLJGoodLJSupplier(IPage<SGGoodSupplierVO> page,@Param(Constants.WRAPPER) QueryWrapper<SGGoodSupplierVO> wrapper);
}
