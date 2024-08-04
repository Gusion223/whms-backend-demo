package com.whms.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.jeffreyning.mybatisplus.service.IMppService;
import com.whms.entity.SG;
import com.whms.entity.vo.SGGoodSupplierVO;
import com.whms.entity.vo.SGGoodVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author whms
 * @since 2024-06-15
 */
public interface SGService extends IMppService<SG> {
    public List<SGGoodVO> listLJGoodInfo(Wrapper wrapper);
    IPage<SGGoodSupplierVO> pageLJGoodLJSupplier(IPage<SGGoodSupplierVO> page, QueryWrapper<SGGoodSupplierVO> wrapper);
}
