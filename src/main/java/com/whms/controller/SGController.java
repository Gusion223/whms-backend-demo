package com.whms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.whms.common.QueryParam;
import com.whms.common.Result;
import com.whms.entity.SG;
import com.whms.entity.vo.SGGoodSupplierVO;
import com.whms.entity.vo.SGGoodVO;
import com.whms.service.SGService;
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
@RequestMapping("/s-g")
public class SGController {
    @Resource
    private SGService sgService;

    @PostMapping("/list-goodInfo")
    public Result listLJGoodInfo(@RequestBody QueryParam query){
        if(query.getParams()==null || query.getParams().get("sid")==null)
            return Result.tip(400, "缺少必要参数");
        Integer sid = (Integer)query.getParams().get("sid");
        QueryWrapper<SGGoodVO> wrapper = new QueryWrapper<>();
        wrapper.eq("sg.sid", sid);

        List<SGGoodVO> result = sgService.listLJGoodInfo(wrapper);
        return Result.success(result, result.size());
    }

    @PostMapping("/page-good-supplierInfo")
    public Result pageLJGoodLJSupplier(@RequestBody QueryParam query){
        QueryWrapper<SGGoodSupplierVO> wrapper = new QueryWrapper<>();
        if(query.getParams()!=null){
            if(query.getParams().get("sname")!=null)
                wrapper.like("s.sname", query.getParams().get("sname"));
            if(query.getParams().get("gtype")!=null)
                wrapper.eq("g.gtype", query.getParams().get("gtype"));
        }

        Page<SGGoodSupplierVO> page = new Page<>();
        page.setSize(query.getPageSize()).setCurrent(query.getPageIndex());
        IPage result = sgService.pageLJGoodLJSupplier(page, wrapper);
        return Result.success(result.getRecords(), result.getTotal());
    }


    @PostMapping("/page")
    public Result pageC(@RequestBody QueryParam query) {
        Page<SG> page = new Page<>();
        page.setCurrent(query.getPageIndex());
        page.setSize(query.getPageSize());
        IPage result = sgService.page(page);
        return Result.success(result.getRecords(), result.getTotal());
    }

    @PostMapping("/add")
    public Result addSG(@RequestBody SG sg) {
        try{
            Boolean res = sgService.save(sg);
            if(res) return Result.success();
            else return Result.fail();
        }catch(Exception e){
            return Result.result(400, "该记录已存在,或者字段不完整", 0, null);
        }
    }

    @PostMapping("/update")
    public Result updateSG(@RequestBody SG sg){
        try{
            Boolean res = sgService.updateByMultiId(sg);
            if(res) return Result.success();
            else return Result.fail();
        }catch(Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }


    @PostMapping("/delete")
    public Result deleteSG(@RequestBody SG sg){
        System.out.println("remove sg id:"+"("+sg.getSid()+","+sg.getGid()+")");
        Boolean res = sgService.deleteByMultiId(sg);
        if(res) return Result.success();
        else return Result.fail();
    }
}
