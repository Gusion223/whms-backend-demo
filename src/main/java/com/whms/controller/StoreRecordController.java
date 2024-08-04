package com.whms.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.whms.common.QueryParam;
import com.whms.common.Result;
import com.whms.entity.StoreRecord;
import com.whms.entity.vo.SrWarehouseGoodVO;
import com.whms.service.StoreRecordService;
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
@RequestMapping("/store-record")
public class StoreRecordController {
    @Resource
    private StoreRecordService storeRecordService;

    @PostMapping("/page")
    public Result pageC(@RequestBody QueryParam query) {
        Page<StoreRecord> page = new Page<>();
        page.setCurrent(query.getPageIndex());
        page.setSize(query.getPageSize());
        IPage result = storeRecordService.page(page);
        return Result.success(result.   getRecords(), result.getTotal());
    }

    @PostMapping("/list-fullInfo")
    public Result listFullInfo(@RequestBody QueryParam query){
        QueryWrapper<SrWarehouseGoodVO> wrapper = new QueryWrapper<>();
        if(query.getParams()!= null){
            if(query.getParams().get("wid")!= null) {
                Integer wid = (Integer) query.getParams().get("wid");
                if(!wid.equals(-1))
                    wrapper.eq("sr.wid",query.getParams().get("wid"));
            }
            if(query.getParams().get("gname")!=null)
                wrapper.like("g.gname", query.getParams().get("gname"));
            if(query.getParams().get("gtype")!=null)
                wrapper.eq("g.gtype", query.getParams().get("gtype"));
        }

        List<SrWarehouseGoodVO> result = storeRecordService.listFullInfo(wrapper);
        return Result.success(result, result.size());
    }
    @PostMapping("/page-fullInfo")
    public Result pageFullInfo(@RequestBody QueryParam query) {
        Page<SrWarehouseGoodVO> page = new Page<>();
        QueryWrapper<SrWarehouseGoodVO> wrapper = new QueryWrapper<>();
        if(query.getParams()!= null){
            if(query.getParams().get("wid")!= null)
            {
                Integer wid = (Integer) query.getParams().get("wid");
                if(!wid.equals(-1))
                    wrapper.eq("sr.wid",query.getParams().get("wid"));
            }
            if(query.getParams().get("gname")!=null)
                wrapper.like("g.gname", query.getParams().get("gname"));
            if(query.getParams().get("gtype")!=null)
                wrapper.eq("g.gtype", query.getParams().get("gtype"));
        }
        page.setCurrent(query.getPageIndex());
        page.setSize(query.getPageSize());
        IPage result = storeRecordService.pageFullInfo(page, wrapper);
        return Result.success(result.getRecords(), result.getTotal());
    }

    @PostMapping("/add")
    public Result addStoreRecord(@RequestBody StoreRecord storeRecord) {
        try{
            Boolean res = storeRecordService.save(storeRecord);
            if(res) return Result.success();
            else return Result.fail();
        }catch(Exception e){
            e.printStackTrace();
            return Result.result(400, "该记录已存在,或者字段不完整", 0, null);
        }
    }

    @PostMapping("/update")
    public Result updateStoreRecord(@RequestBody StoreRecord storeRecord){
        try{
            Boolean res = storeRecordService.updateByMultiId(storeRecord);
            if(res) return Result.success();
            else return Result.fail();
        }catch(Exception e){
            e.printStackTrace();
            return Result.fail();
        }
    }


    @PostMapping("/delete")
    public Result deleteStoreRecord(@RequestBody StoreRecord storeRecord){
        System.out.println("remove storeRecord id:"+"("+storeRecord.getWid()+","+storeRecord.getGid()+")");
        Boolean res = storeRecordService.deleteByMultiId(storeRecord);
        if(res) return Result.success();
        else return Result.fail();
    }
}
