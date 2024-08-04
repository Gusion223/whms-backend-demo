package com.whms.service.impl;

import cn.hutool.core.io.FileUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.whms.common.Result;
import com.whms.entity.Backup;
import com.whms.mapper.BackupMapper;
import com.whms.service.BackupService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.hutool.core.date.DateUtil;
import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author whms
 * @since 2024-06-15
 */
@Service
public class BackupServiceImpl extends ServiceImpl<BackupMapper, Backup> implements BackupService {

    @Resource
    private Environment env;

    private String databaseName="whms";
    private String filepath="whms/backups/";

    @Value("${spring.datasource.username}")
    String userName;

    @Value("${spring.datasource.password}")
    String password;

    @Override
    public Result createWholeMysqlBackup(Backup backupInfo) {

        StringBuilder mysqlFileName = new StringBuilder()
                .append("whms_backup")
                .append("_")
                .append(DateUtil.format(new Date(), "yyyyMMddHHmmss"))
                .append(".sql");

        // mysqldump 命令
        StringBuilder cmd = new StringBuilder()
                .append("mysqldump ")
                // 不进行表的创建
                .append("--no-tablespaces ")
                .append("-u").append(userName)
                .append(" -p").append(password)
                // 不对 backup进行备份
                .append(" --ignore-table ")
                .append(databaseName).append(".backup ")
                .append(databaseName)
                .append(" > ")
                .append(filepath).append(mysqlFileName);
        if(!FileUtil.exist(java.lang.String.valueOf(filepath)))
            FileUtil.mkdir(filepath);
        // 理论上要判断操作系统再运行此处略过
        String[] command = new String[0];
        if(System.getProperty("os.name").toLowerCase().contains("windows")){
            command = new String[]{"cmd", "/c", String.valueOf(cmd)};
        }else{
            command = new String[]{"/bin/sh", "-c", String.valueOf(cmd)};
        }
        System.out.println(command[2]);
        backupInfo.setBfilepath(filepath+mysqlFileName);
        backupInfo.setBtime(LocalDateTime.now());
        backupInfo.setAutoCreate("N");
        backupInfo.setBtype(0);
        // 记录备份记录
        Process process = null;
        Result fail = Result.fail();
        fail.setMsg("网络异常，数据库备份失败");
        fail.setStatus(500);
        try{
            process = Runtime.getRuntime().exec(command);
            if(process.waitFor()==0){
                System.out.println("mysql备份成功, 文件名为:"+mysqlFileName);
                baseMapper.insert(backupInfo);
            }else{
                return fail;
            }
        }catch (Exception e){
            e.printStackTrace();
            return fail;
        }
        return Result.success(backupInfo, 0);
    }

    @Override
    public Result rollbackWithWholeBackUp(Backup backupInfo) {
        String filepath = backupInfo.getBfilepath();
        Integer bid = backupInfo.getBid();
        File file = new File(filepath.toString());
        if(!FileUtil.exist(file)){
            return Result.tip(500, "数据库恢复失败, 请检查服务器中是否存在对应备份");
        }
        StringBuilder cmd = new StringBuilder()
                .append("mysql")
                .append(" -u").append(userName)
                .append(" -p").append(password)
                .append(" ").append(databaseName)
                .append(" < ").append(filepath);
        String [] command = new String[0];
        if(System.getProperty("os.name").toLowerCase().contains("windows"))
            command = new String[]{"cmd", "/c", cmd.toString()};
        else
            command = new String[]{"/bin/sh", "-c", cmd.toString()};
        // 开始调用 mysql 进行数据的回复
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(command);
            if(process.waitFor() == 0)
                return Result.tip(200, "数据库和id为"+bid+"的备份文件完成同步");
            else
                return Result.tip(500, "数据库程序运行错误, 请稍后尝试");
        }catch (Exception e){
            e.printStackTrace();
            return Result.tip(500, "数据库程序运行错误, 请稍后尝试");
        }
    }

    public Result deleteBackup(Backup backupInfo){
        String filepath = backupInfo.getBfilepath();
        File file = new File(filepath);
        if(FileUtil.isFile(file)){
           FileUtil.del(file);
           System.out.println("删除备份文件"+filepath);
        }else{
            System.out.println("未找到备份文件"+filepath);
        }
        baseMapper.deleteById(backupInfo.getBid());
        return Result.tip(200, "数据库备份删除成功");
    }

    @Override
    public IPage pageLJoinUser(Page page, String date) {
        return baseMapper.pageLJoinUser(page, date);
    }
}
