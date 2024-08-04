package com.whms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.whms.common.QueryParam;
import com.whms.common.Result;
import com.whms.entity.SaleDetail;
import com.whms.entity.vo.SdGoodVO;
import com.whms.service.SaleDetailService;
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
@RequestMapping("/sale-detail")
public class SaleDetailController {
    @Resource
    private SaleDetailService saleDetailService;

    @PostMapping("/page")
    public Result pageC(@RequestBody QueryParam query) {
        Page<SaleDetail> page = new Page<>();
        page.setCurrent(query.getPageIndex());
        page.setSize(query.getPageSize());
        IPage result = saleDetailService.page(page);
        return Result.success(result.   getRecords(), result.getTotal());
    }

    @PostMapping("/page-fullInfo")
    public Result pageFullInfo(@RequestBody QueryParam query) {
        QueryWrapper<SdGoodVO> wrapper = new QueryWrapper<>();
        if(query.getParams() != null && query.getParams().get("soid") != null){
            wrapper.eq("sd.soid", query.getParams().get("soid"));
        }
        Page<SdGoodVO> page = new Page<>();
        page.setCurrent(query.getPageIndex());
        page.setSize(query.getPageSize());
        IPage result = saleDetailService.pageFullInfo(page, wrapper);
        return Result.success(result.getRecords(), result.getTotal());
    }
    
    @PostMapping("/add")
    public Result addSaleDetail(@RequestBody SaleDetail saleDetail) {
        try{
            Boolean res = saleDetailService.save(saleDetail);
            if(res) return Result.success();
            else return Result.fail();
        }catch(Exception e){
            return Result.result(400, "该记录已存在,或者字段不完整", 0, null);
        }
    }
    
    @PostMapping("/update")
    public Result updateSaleDetail(@RequestBody SaleDetail saleDetail){
        try{
            Boolean res = saleDetailService.updateByMultiId(saleDetail);
            if(res) return Result.success();
            else return Result.fail();
        }catch(Exception e){
            return Result.fail();
        }
    }


    @PostMapping("/delete")
    public Result deleteSaleDetail(@RequestBody SaleDetail saleDetail){
        System.out.println("remove saleDetail id:"+"("+saleDetail.getSoid()+","+saleDetail.getGid()+")");
        Boolean res = saleDetailService.deleteByMultiId(saleDetail);
        if(res) return Result.success();
        else return Result.fail();
    }
}
