package com.whms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.whms.common.QueryParam;
import com.whms.common.Result;
import com.whms.entity.TransferDetail;
import com.whms.entity.vo.SdGoodVO;
import com.whms.entity.vo.TdGoodVO;
import com.whms.service.TransferDetailService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author whms
 * @since 2024-06-15
 */
@RestController
@RequestMapping("/transfer-detail")
public class TransferDetailController {
    @Resource
    private TransferDetailService transferDetailService;

    @PostMapping("/page")
    public Result pageC(@RequestBody QueryParam query) {
        Page<TransferDetail> page = new Page<>();
        page.setCurrent(query.getPageIndex());
        page.setSize(query.getPageSize());
        IPage result = transferDetailService.page(page);
        return Result.success(result.   getRecords(), result.getTotal());
    }
    @PostMapping("/page-fullInfo")
    public Result pageFullInfo(@RequestBody QueryParam query) {
        QueryWrapper<TdGoodVO> wrapper = new QueryWrapper<>();
        if(query.getParams() != null && query.getParams().get("toid") != null){
            wrapper.eq("td.toid", query.getParams().get("toid"));
        }
        Page<TdGoodVO> page = new Page<>();
        page.setCurrent(query.getPageIndex());
        page.setSize(query.getPageSize());
        IPage result = transferDetailService.pageFullInfo(page, wrapper);
        return Result.success(result.getRecords(), result.getTotal());
    }
    @PostMapping("/add")
    public Result addTransferDetail(@RequestBody TransferDetail transferDetail) {
        try{
            Boolean res = transferDetailService.save(transferDetail);
            if(res) return Result.success();
            else return Result.fail();
        }catch(Exception e){
            e.printStackTrace();
            return Result.result(400, "该记录已存在,或者字段不完整", 0, null);
        }
    }

    @PostMapping("/update")
    public Result updateTransferDetail(@RequestBody TransferDetail transferDetail){
        try{
            Boolean res = transferDetailService.updateByMultiId(transferDetail);
            if(res) return Result.success();
            else return Result.fail();
        }catch(Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }

    @PostMapping("/delete")
    public Result deleteTransferDetail(@RequestBody TransferDetail transferDetail){
        System.out.println("remove transferDetail id:"+"("+transferDetail.getToid()+","+transferDetail.getGid()+")");
        Boolean res = transferDetailService.deleteByMultiId(transferDetail);
        if(res) return Result.success();
        else return Result.fail();
    }
}
