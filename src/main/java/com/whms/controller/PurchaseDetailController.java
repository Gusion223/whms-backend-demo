package com.whms.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.whms.common.QueryParam;
import com.whms.common.Result;
import com.whms.entity.Customer;
import com.whms.entity.PurchaseDetail;
import com.whms.entity.vo.PdGoodVO;
import com.whms.service.PurchaseDetailService;
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
@RequestMapping("/purchase-detail")
public class PurchaseDetailController {
    @Resource
    private PurchaseDetailService purchaseDetailService;

    @PostMapping("/page")
    public Result pageC(@RequestBody QueryParam query) {
        LambdaQueryWrapper<PurchaseDetail> wrapper = new LambdaQueryWrapper<>();
        if(query.getParams() != null && query.getParams().get("poid") != null){
            wrapper.eq(PurchaseDetail::getPoid, query.getParams().get("poid"));
        }
        Page<PurchaseDetail> page = new Page<>();
        page.setCurrent(query.getPageIndex());
        page.setSize(query.getPageSize());
        IPage result = purchaseDetailService.page(page, wrapper);
        return Result.success(result.   getRecords(), result.getTotal());
    }

    @PostMapping("/page-fullInfo")
    public Result pageFullInfo(@RequestBody QueryParam query) {
        QueryWrapper<PdGoodVO> wrapper = new QueryWrapper<>();
        if(query.getParams() != null && query.getParams().get("poid") != null){
            wrapper.eq("pd.poid", query.getParams().get("poid"));
        }
        Page<PdGoodVO> page = new Page<>();
        page.setCurrent(query.getPageIndex());
        page.setSize(query.getPageSize());
        IPage result = purchaseDetailService.pageFullInfo(page, wrapper);
        return Result.success(result.getRecords(), result.getTotal());
    }

    @PostMapping("/add")
    public Result addPurchaseDetail(@RequestBody PurchaseDetail purchaseDetail) {
        try{
            Boolean res = purchaseDetailService.save(purchaseDetail);
            if(res) return Result.success();
            else return Result.fail();
        }catch(Exception e){
            return Result.result(400, "该记录已存在,或者字段不完整", 0, null);
        }
    }

    @PostMapping("/update")
    public Result updatePurchaseDetail(@RequestBody PurchaseDetail purchaseDetail){
        try{
            Boolean res = purchaseDetailService.updateByMultiId(purchaseDetail);
            if(res) return Result.success();
            else return Result.fail();
        }catch(Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }


    @PostMapping("/delete")
    public Result deletePurchaseDetail(@RequestBody PurchaseDetail purchaseDetail){
        System.out.println("remove purchaseDetail id:"+"("+purchaseDetail.getPoid()+","+purchaseDetail.getGid()+")");
        Boolean res = purchaseDetailService.deleteByMultiId(purchaseDetail);
        if(res) return Result.success();
        else return Result.fail();
    }
}
