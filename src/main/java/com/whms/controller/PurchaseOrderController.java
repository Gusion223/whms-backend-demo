package com.whms.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.whms.common.QueryParam;
import com.whms.common.Result;
import com.whms.entity.PurchaseDetail;
import com.whms.entity.PurchaseOrder;
import com.whms.entity.vo.PoWarehouseSupplierUserVO;
import com.whms.entity.bo.PurchaseOrderWithDetail;
import com.whms.service.PurchaseOrderService;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/purchase-order")
public class PurchaseOrderController {
    @Resource
    private PurchaseOrderService purchaseOrderService;
    @PostMapping("/page")
    public Result pageC(@RequestBody QueryParam query) {
        Page<PurchaseOrder> page = new Page<>();
        LambdaQueryWrapper<PurchaseOrder> wrapper = new LambdaQueryWrapper<>();
        if(query.getParams() != null){
            if(query.getParams().get("potime") != null)
                wrapper.apply("DATE(potime)=DATE({0})", query.getParams().get("potime"));
            if(query.getParams().get("poid")!=null)
                wrapper.eq(PurchaseOrder::getPoid, query.getParams().get("poid"));
        }

        page.setCurrent(query.getPageIndex());
        page.setSize(query.getPageSize());
        IPage result = purchaseOrderService.page(page);
        return Result.success(result.getRecords(), result.getTotal());
    }

    @PostMapping("/page-fullInfo")
    public Result pageFullInfo(@RequestBody QueryParam query)
    {
        Page<PoWarehouseSupplierUserVO> page = new Page<>();
        QueryWrapper<PoWarehouseSupplierUserVO> wrapper = new QueryWrapper<>();
        if(query.getParams() != null){
            if(query.getParams().get("potime") != null)
                wrapper.apply("DATE(potime)=DATE({0})", query.getParams().get("potime"));
            if(query.getParams().get("wid") !=null)
                wrapper.eq("po.wid", query.getParams().get("wid"));
            if(query.getParams().get("sid")!=null)
                wrapper.eq("po.sid", query.getParams().get("sid"));
            if(query.getParams().get("id")!=null)
                wrapper.eq("po.id", query.getParams().get("id"));
            if(query.getParams().get("sname")!=null)
                wrapper.eq("s.sname", query.getParams().get("sname"));
        }
        wrapper.orderByDesc("po.potime");
        page.setCurrent(query.getPageIndex());
        page.setSize(query.getPageSize());
        IPage<PoWarehouseSupplierUserVO> result = purchaseOrderService.pageFullInfo(page, wrapper);
        return Result.success(result.getRecords(), result.getTotal());
    }

    @PostMapping("/add")
    public Result addPurchaseOrder(@RequestBody PurchaseOrder purchaseOrder) {
        try{
            Boolean res = purchaseOrderService.save(purchaseOrder);
            if(res) return Result.success();
            else return Result.fail();
        }catch(Exception e){
            e.printStackTrace();
            return Result.result(400, "当前记录的仓库或供货商不存在", 0, null);
        }
    }

    @PostMapping("/update")
    public Result updatePurchaseOrder(@RequestBody PurchaseOrder purchaseOrder){
        try{
            Boolean res = purchaseOrderService.updateById(purchaseOrder);
            if(res) return Result.success();
            else return Result.fail();
        }catch(Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }

    @PostMapping("/delete")
    public Result deletePurchaseOrder(@RequestBody PurchaseOrder purchaseOrder){
        try{
            System.out.println("remove purchaseOrder id:"+purchaseOrder.getPoid());
            Boolean res = purchaseOrderService.removeById(purchaseOrder.getPoid());
            if(res) return Result.success();
            else return Result.fail();
        }catch (Exception e){
            return Result.tip(400, "请先删除相关的细则记录");
        }
    }

    @PostMapping("/addOrderWithDetail")
    public Result orderWithDetail(@RequestBody PurchaseOrderWithDetail purchaseOrderWithDetail){
        PurchaseOrder order = purchaseOrderWithDetail.getOrder();
        List<PurchaseDetail> list = purchaseOrderWithDetail.getList();
        System.out.println(order);
        if(list!=null)
            for(PurchaseDetail pd : list) System.out.println(pd);

        try{
           return purchaseOrderService.orderWithDetail(order, list);
        }catch (Exception e)
        {
            return Result.tip(400, "表单提交失败");
        }
    }


}
