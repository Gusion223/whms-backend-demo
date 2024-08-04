package com.whms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.whms.common.QueryParam;
import com.whms.common.Result;
import com.whms.entity.TransferDetail;
import com.whms.entity.TransferOrder;
import com.whms.entity.vo.ToWarehouseUserVO;
import com.whms.entity.bo.TransferOrderWithDetail;
import com.whms.service.TransferOrderService;
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
@RequestMapping("/transfer-order")
public class TransferOrderController {
    @Resource
    private TransferOrderService transferOrderService;

    @PostMapping("/page")
    public Result pageC(@RequestBody QueryParam query) {
        Page<TransferOrder> page = new Page<>();
        page.setCurrent(query.getPageIndex());
        page.setSize(query.getPageSize());
        IPage result = transferOrderService.page(page);
        return Result.success(result.   getRecords(), result.getTotal());
    }

    @PostMapping("/page-fullInfo")
    public Result pageFullInfo(@RequestBody QueryParam query){
        Page<ToWarehouseUserVO> page = new Page<>();
        QueryWrapper<ToWarehouseUserVO> wrapper = new QueryWrapper<>();
        if(query.getParams() != null) {
            if(query.getParams().get("totime") != null)
                wrapper.apply("DATE(totime)=DATE({0})", query.getParams().get("totime"));
            if(query.getParams().get("wid_prev") !=null)
                wrapper.eq("tro.wid_prev", query.getParams().get("wid_prev"));
            if(query.getParams().get("wid_cur")!=null)
                wrapper.eq("tro.wid_cur", query.getParams().get("wid_cur"));
            if(query.getParams().get("id")!=null)
                wrapper.eq("tro.id", query.getParams().get("id"));
            if(query.getParams().get("toid") != null)
                wrapper.eq("tro.toid", query.getParams().get("toid"));
        }
        wrapper.orderByDesc("tro.totime");
        page.setCurrent(query.getPageIndex());
        page.setSize(query.getPageSize());
        IPage<ToWarehouseUserVO> result = transferOrderService.pageFullInfo(page, wrapper);
        return Result.success(result.getRecords(), result.getTotal());
    }

    @PostMapping("/add")
    public Result addTransferOrder(@RequestBody TransferOrder transferOrder) {
        try{
            Boolean res = transferOrderService.save(transferOrder);
            if(res) return Result.success();
            else return Result.fail();
        }catch(Exception e){
            return Result.result(400, "用户名已存在, 请重新填写一个新的用户名", 0, null);
        }
    }

    @PostMapping("/update")
    public Result updateTransferOrder(@RequestBody TransferOrder transferOrder){
        try{
            Boolean res = transferOrderService.updateById(transferOrder);
            if(res) return Result.success();
            else return Result.fail();
        }catch(Exception e){
            return Result.fail();
        }
    }

    @PostMapping("/delete")
    public Result deleteTransferOrder(@RequestBody TransferOrder transferOrder){
        System.out.println("remove transferOrder id:"+transferOrder.getToid());
        Boolean res = transferOrderService.removeById(transferOrder.getToid());
        if(res) return Result.success();
        else return Result.fail();
    }

    @PostMapping("/addOrderWithDetail")
    public Result orderWithDetail(@RequestBody TransferOrderWithDetail transferOrderWithDetail){
        TransferOrder order = transferOrderWithDetail.getOrder();
        List<TransferDetail> list = transferOrderWithDetail.getList();
        System.out.println(order);
        if(list!=null)
            for(TransferDetail td : list) System.out.println(td);
        try{
            return transferOrderService.orderWithDetail(order, list);
        }catch (Exception e)
        {
            return Result.tip(400, "表单提交失败");
        }
    }
}
