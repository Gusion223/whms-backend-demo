package com.whms.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.github.jeffreyning.mybatisplus.service.IMppService;
import com.whms.entity.StoreRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.whms.entity.vo.SrWarehouseGoodVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author whms
 * @since 2024-06-15
 */
public interface StoreRecordService extends IMppService<StoreRecord> {
    IPage<SrWarehouseGoodVO> pageFullInfo(IPage<SrWarehouseGoodVO> page,  QueryWrapper<SrWarehouseGoodVO> wrapper);


    List<SrWarehouseGoodVO> listFullInfo(QueryWrapper<SrWarehouseGoodVO> wrapper);
}
