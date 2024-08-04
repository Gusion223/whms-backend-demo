package com.whms.controller;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.whms.common.QueryParam;
import com.whms.common.Result;
import com.whms.entity.Good;
import com.whms.service.GoodService;
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
@RequestMapping("/good")
public class GoodController {
    @Resource
    private GoodService goodService;

    @GetMapping("/list")
    public Result list(){
        return Result.success(goodService.list(), goodService.count());
    }
    @PostMapping("/page")
    public Result pageC(@RequestBody QueryParam query) {
        LambdaQueryWrapper<Good> wrapper = new LambdaQueryWrapper<>();
        if(query.getParams() != null){
            if(query.getParams().get("gname") != null)
                wrapper.like(Good::getGname, query.getParams().get("gname"));
            if(query.getParams().get("gtype") != null)
                wrapper.eq(Good::getGtype, query.getParams().get("gtype"));
        }
        Page<Good> page = new Page<>();
        page.setCurrent(query.getPageIndex());
        page.setSize(query.getPageSize());
        IPage result = goodService.page(page, wrapper);
        return Result.success(result.getRecords(), result.getTotal());
    }

    @PostMapping("/add")
    public Result addGood(@RequestBody Good good) {
        try{
            Boolean res = goodService.save(good);
            if(res) return Result.success();
            else return Result.fail();
        }catch(Exception e){
            e.printStackTrace();
            return Result.result(400, "提交数据字段缺失或者商品名重复", 0, null);
        }
    }

    @PostMapping("/update")
    public Result updateGood(@RequestBody Good good){
        try{
            Boolean res = goodService.updateById(good);
            if(res) return Result.success();
            else return Result.fail();
        }catch(Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }


    @PostMapping("/delete")
    public Result deleteGood(@RequestBody Good good){
        try{
            System.out.println("remove good id:"+good.getGid());
            Boolean res = goodService.removeById(good.getGid());
            if(res) return Result.success();
            else return Result.tip(400, "请先删除供货信息中有相关商品的记录");
        }catch (Exception e){
            return Result.tip(400, "请先删除供货信息中有相关商品的记录");
        }
    }
}
