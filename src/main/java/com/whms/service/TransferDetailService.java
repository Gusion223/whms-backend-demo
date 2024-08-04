package com.whms.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.github.jeffreyning.mybatisplus.service.IMppService;
import com.whms.entity.TransferDetail;
import com.baomidou.mybatisplus.extension.service.IService;
import com.whms.entity.vo.TdGoodVO;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author whms
 * @since 2024-06-15
 */
public interface TransferDetailService extends IMppService<TransferDetail> {
    IPage<TdGoodVO> pageFullInfo(IPage<TdGoodVO> page, QueryWrapper<TdGoodVO> wrapper);

}
