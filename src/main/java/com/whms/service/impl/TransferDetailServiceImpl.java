package com.whms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.jeffreyning.mybatisplus.service.MppServiceImpl;
import com.whms.entity.TransferDetail;
import com.whms.entity.vo.TdGoodVO;
import com.whms.mapper.TransferDetailMapper;
import com.whms.service.TransferDetailService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author whms
 * @since 2024-06-15
 */
@Service
public class TransferDetailServiceImpl extends MppServiceImpl<TransferDetailMapper, TransferDetail> implements TransferDetailService {

    @Override
    public IPage<TdGoodVO> pageFullInfo(IPage<TdGoodVO> page, QueryWrapper<TdGoodVO> wrapper) {
        return baseMapper.pageFullInfo(page, wrapper);
    }
}
