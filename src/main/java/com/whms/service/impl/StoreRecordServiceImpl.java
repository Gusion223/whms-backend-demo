package com.whms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.jeffreyning.mybatisplus.service.MppServiceImpl;
import com.whms.entity.StoreRecord;
import com.whms.entity.vo.SrWarehouseGoodVO;
import com.whms.mapper.StoreRecordMapper;
import com.whms.service.StoreRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author whms
 * @since 2024-06-15
 */
@Service
public class StoreRecordServiceImpl extends MppServiceImpl<StoreRecordMapper, StoreRecord> implements StoreRecordService {

    @Override
    public IPage<SrWarehouseGoodVO> pageFullInfo(IPage<SrWarehouseGoodVO> page, QueryWrapper<SrWarehouseGoodVO> wrapper) {
        return baseMapper.pageFullInfo(page, wrapper);
    }

    @Override
    public List<SrWarehouseGoodVO> listFullInfo(QueryWrapper<SrWarehouseGoodVO> wrapper) {
        return baseMapper.listFullInfo(wrapper);
    }
}
