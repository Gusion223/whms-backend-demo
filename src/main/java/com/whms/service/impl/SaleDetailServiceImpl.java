package com.whms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.jeffreyning.mybatisplus.service.MppServiceImpl;
import com.whms.entity.SaleDetail;
import com.whms.entity.vo.SdGoodVO;
import com.whms.mapper.SaleDetailMapper;
import com.whms.service.SaleDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class SaleDetailServiceImpl extends MppServiceImpl<SaleDetailMapper, SaleDetail> implements SaleDetailService {

    @Override
    public IPage<SdGoodVO> pageFullInfo(IPage<SdGoodVO> page, QueryWrapper<SdGoodVO> wrapper) {
        return baseMapper.pageFullInfo(page, wrapper);
    }
}
