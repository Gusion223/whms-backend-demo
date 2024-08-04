package com.whms.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.whms.common.QueryParam;
import com.whms.common.Result;
import com.whms.entity.Supplier;
import com.whms.service.SupplierService;
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
@RequestMapping("/supplier")
public class SupplierController {
    @Resource
    private SupplierService supplierService;

    @GetMapping("/list")
    public Result listAll(){
        return Result.success(supplierService.list(), supplierService.count());
    }

    @PostMapping("/page")
    public Result pageC(@RequestBody QueryParam query) {
        Page<Supplier> page = new Page<>();
        page.setCurrent(query.getPageIndex());
        page.setSize(query.getPageSize());
        LambdaQueryWrapper<Supplier> wrapper = new LambdaQueryWrapper<>();
        if(query.getParams()!=null && query.getParams().get("sname") != null)
            wrapper.like(Supplier::getSname, query.getParams().get("sname"));
        IPage result = supplierService.page(page, wrapper);
        return Result.success(result.getRecords(), result.getTotal());
    }

    @PostMapping("/add")
    public Result addSupplier(@RequestBody Supplier supplier) {
        try{
            Boolean res = supplierService.save(supplier);
            if(res) return Result.success();
            else return Result.fail();
        }catch(Exception e){
            return Result.result(400, "该经销商已存在", 0, null);
        }
    }

    @PostMapping("/update")
    public Result updateSupplier(@RequestBody Supplier supplier){
        try{
            Boolean res = supplierService.updateById(supplier);
            if(res) return Result.success();
            else return Result.fail();
        }catch(Exception e){
            return Result.fail();
        }
    }


    @PostMapping("/delete")
    public Result deleteSupplier(@RequestBody Supplier supplier){
        System.out.println("remove supplier id:"+supplier.getSid());
        Boolean res = supplierService.removeById(supplier.getSid());
        if(res) return Result.success();
        else return Result.fail();
    }
}
