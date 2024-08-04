package com.whms.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.jeffreyning.mybatisplus.service.MppServiceImpl;
import com.whms.entity.SG;
import com.whms.entity.vo.SGGoodSupplierVO;
import com.whms.entity.vo.SGGoodVO;
import com.whms.mapper.SGMapper;
import com.whms.service.SGService;
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
public class SGServiceImpl extends MppServiceImpl<SGMapper, SG> implements SGService {
    @Override
    public List<SGGoodVO> listLJGoodInfo(Wrapper wrapper) {
        return baseMapper.listLJGoodInfo(wrapper);
    }

    @Override
    public IPage<SGGoodSupplierVO> pageLJGoodLJSupplier(IPage<SGGoodSupplierVO> page, QueryWrapper<SGGoodSupplierVO> wrapper) {
        return baseMapper.pageLJGoodLJSupplier(page, wrapper);
    }
}
