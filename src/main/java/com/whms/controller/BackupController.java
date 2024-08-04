package com.whms.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.whms.common.QueryParam;
import com.whms.common.Result;
import com.whms.entity.Backup;
import com.whms.entity.vo.BackupUserVO;
import com.whms.service.BackupService;
import org.apache.ibatis.io.ResolverUtil;
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
@RequestMapping("/backup")
public class BackupController {
    @Resource
    private BackupService backupService;
    @PostMapping("/page")
    public Result page(@RequestBody QueryParam queryParam){
        Page<BackupUserVO> page = new Page<>();
        page.setCurrent(queryParam.getPageIndex());
        page.setSize(queryParam.getPageSize());
        String date;
        if(queryParam.getParams()==null || queryParam.getParams().get("date")==null)
            date=null;
        else
            date=(String)queryParam.getParams().get("date");

        IPage<BackupUserVO> result = backupService.pageLJoinUser(page, date);
        return Result.success(result.getRecords(), result.getTotal());
    }

    @PostMapping("/create")
    public Result createBackup(@RequestBody Backup backup){
        Result result = backupService.createWholeMysqlBackup(backup);
        return result;
    }

    @PostMapping("/delete")
    public Result deleteBackup(@RequestBody Backup backup){
        return backupService.deleteBackup(backup);
    }

    @PostMapping("/rollback")
    public Result rollback(@RequestBody Backup backup){
        return backupService.rollbackWithWholeBackUp(backup);
    }

}
