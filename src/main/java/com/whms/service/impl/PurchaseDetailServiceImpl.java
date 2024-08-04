package com.whms.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.jeffreyning.mybatisplus.service.MppServiceImpl;
import com.whms.entity.PurchaseDetail;
import com.whms.entity.vo.PdGoodVO;
import com.whms.mapper.PurchaseDetailMapper;
import com.whms.service.PurchaseDetailService;
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
public class PurchaseDetailServiceImpl extends MppServiceImpl<PurchaseDetailMapper, PurchaseDetail> implements PurchaseDetailService {
    @Override
    public IPage<PdGoodVO> pageFullInfo(IPage<PdGoodVO> page, QueryWrapper<PdGoodVO> wrapper) {
        return baseMapper.pageFullInfo(page, wrapper);
    }
}
