package com.whms.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.github.jeffreyning.mybatisplus.base.MppBaseMapper;
import com.whms.entity.StoreRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.whms.entity.vo.SrWarehouseGoodVO;
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
public interface StoreRecordMapper extends MppBaseMapper<StoreRecord> {
    @Select("SELECT sr.*, w.wname, g.gname, g.gunit, g.gunit_price, g.gtype FROM store_record sr " +
            "LEFT JOIN good g ON g.gid=sr.gid " +
            "LEFT JOIN  warehouse w ON w.wid=sr.wid  ${ew.customSqlSegment} ")
    IPage<SrWarehouseGoodVO> pageFullInfo(IPage<SrWarehouseGoodVO> page, @Param(Constants.WRAPPER)QueryWrapper<SrWarehouseGoodVO> wrapper);
    @Select("SELECT sr.*, w.wname, g.gname, g.gunit, g.gunit_price, g.gtype FROM store_record sr " +
            "LEFT JOIN good g ON g.gid=sr.gid " +
            "LEFT JOIN  warehouse w ON w.wid=sr.wid  ${ew.customSqlSegment} ")
    List<SrWarehouseGoodVO> listFullInfo(@Param(Constants.WRAPPER) QueryWrapper<SrWarehouseGoodVO> wrapper);
}
