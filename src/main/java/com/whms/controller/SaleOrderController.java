package com.whms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.whms.common.QueryParam;
import com.whms.common.Result;
import com.whms.entity.SaleDetail;
import com.whms.entity.SaleOrder;
import com.whms.entity.bo.SaleOrderWithDetail;
import com.whms.entity.vo.SoWarehouseCustomerUserVO;
import com.whms.service.SaleOrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author whms
 * @since 2024-06-15
 */
@RestController
@RequestMapping("/sale-order")
public class SaleOrderController {
    @Resource
    private SaleOrderService saleOrderService;

    @PostMapping("/page")
    public Result pageC(@RequestBody QueryParam query) {
        Page<SaleOrder> page = new Page<>();
        page.setCurrent(query.getPageIndex());
        page.setSize(query.getPageSize());
        IPage result = saleOrderService.page(page);
        return Result.success(result.   getRecords(), result.getTotal());
    }

    @PostMapping("/page-fullInfo")
    public Result pageFullInfo(@RequestBody QueryParam query){
        Page<SoWarehouseCustomerUserVO> page = new Page<>();
        page.setCurrent(query.getPageIndex());
        page.setSize(query.getPageSize());
        QueryWrapper<SoWarehouseCustomerUserVO> wrapper = new QueryWrapper<>();
        if(query.getParams() != null){
            if(query.getParams().get("cid")!=null)
                wrapper.eq("so.cid",query.getParams().get("cid"));
            if(query.getParams().get("id")!=null)
                wrapper.eq("so.id", query.getParams().get("id"));
            if(query.getParams().get("wid") !=null)
                wrapper.eq("so.wid", query.getParams().get("wid"));
            if(query.getParams().get("sotime") != null)
                wrapper.apply("DATE(sotime)=DATE({0})", query.getParams().get("sotime"));
            if(query.getParams().get("soid")!=null)
                wrapper.eq("so.soid", query.getParams().get("soid"));
        }
        wrapper.orderByDesc("so.sotime");
        IPage<SoWarehouseCustomerUserVO> result = saleOrderService.pageFullInfo(page,wrapper);
        return Result.success(result.getRecords(), result.getTotal());
    }

    @PostMapping("/add")
    public Result addSaleOrder(@RequestBody SaleOrder saleOrder) {
        try{
            Boolean res = saleOrderService.save(saleOrder);
            if(res) return Result.success();
            else return Result.fail();
        }catch(Exception e){
            return Result.result(400, "用户名已存在, 请重新填写一个新的用户名", 0, null);
        }
    }

    @PostMapping("/update")
    public Result updateSaleOrder(@RequestBody SaleOrder saleOrder){
        try{
            Boolean res = saleOrderService.updateById(saleOrder);
            if(res) return Result.success();
            else return Result.fail();
        }catch(Exception e){
            return Result.fail();
        }
    }


    @PostMapping("/delete")
    public Result deleteSaleOrder(@RequestBody SaleOrder saleOrder){
        System.out.println("remove saleOrder id:"+saleOrder.getSoid());
        Boolean res = saleOrderService.removeById(saleOrder.getSoid());
        if(res) return Result.success();
        else return Result.fail();
    }

    @PostMapping("/addOrderWithDetail")
    public Result orderWithDetail(@RequestBody SaleOrderWithDetail saleOrderWithDetail){
        SaleOrder order = saleOrderWithDetail.getOrder();
        List<SaleDetail> list = saleOrderWithDetail.getList();
        System.out.println( saleOrderWithDetail.getOrder());
        if(list!=null)
            for(SaleDetail sd: list) System.out.println(sd);
        try{
            return saleOrderService.orderWithDetail(order, list);
        }catch (Exception e)
        {
            e.printStackTrace();
            return Result.tip(400, "表单提交失败");
        }
    }
}
