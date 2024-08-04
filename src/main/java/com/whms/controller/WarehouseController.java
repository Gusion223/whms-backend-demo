package com.whms.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.whms.common.QueryParam;
import com.whms.common.Result;
import com.whms.entity.Warehouse;
import com.whms.service.WarehouseService;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/warehouse")
public class WarehouseController {
    @Resource
    private WarehouseService warehouseService;

    @GetMapping("/list")
    public Result listAll(){
        return Result.success(warehouseService.list(), warehouseService.count());
    }
    @PostMapping("/page")
    public Result pageC(@RequestBody QueryParam query) {
        Page<Warehouse> page = new Page<>();
        page.setCurrent(query.getPageIndex()).setSize(query.getPageSize());
        LambdaQueryWrapper<Warehouse> wrapper = new LambdaQueryWrapper<>();
        if(query.getParams() != null && query.getParams().get("wname") != null)
            wrapper.like(Warehouse::getWname, query.getParams().get("wname"));
        IPage result = warehouseService.page(page, wrapper);
        return Result.success(result.getRecords(), result.getTotal());
    }

    @PostMapping("/add")
    public Result addWarehouse(@RequestBody Warehouse warehouse) {
        try{
            Boolean res = warehouseService.save(warehouse);
            if(res) return Result.success();
            else return Result.fail();
        }catch(Exception e){
            return Result.result(400, "用户名已存在, 请重新填写一个新的用户名", 0, null);
        }
    }

    @PostMapping("/update")
    public Result updateWarehouse(@RequestBody Warehouse warehouse){
        try{
            Boolean res = warehouseService.updateById(warehouse);
            if(res) return Result.success();
            else return Result.fail();
        }catch(Exception e){
            return Result.fail();
        }
    }

    @PostMapping("/delete")
    public Result deleteWarehouse(@RequestBody Warehouse warehouse){
        System.out.println("remove warehouse id:"+warehouse.getWid());
        Boolean res = warehouseService.removeById(warehouse.getWid());
        if(res) return Result.success();
        else return Result.fail();
    }
}
