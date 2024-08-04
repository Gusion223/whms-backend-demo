package com.whms.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.github.jeffreyning.mybatisplus.service.IMppService;
import com.whms.entity.SaleDetail;
import com.baomidou.mybatisplus.extension.service.IService;
import com.whms.entity.vo.SdGoodVO;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author whms
 * @since 2024-06-15
 */
public interface SaleDetailService extends IMppService<SaleDetail> {
    IPage<SdGoodVO> pageFullInfo(IPage<SdGoodVO> page, QueryWrapper<SdGoodVO> wrapper);
}
