package com.whms.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.whms.common.Result;
import com.whms.entity.Backup;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author whms
 * @since 2024-06-15
 */
public interface BackupService extends IService<Backup> {
    Result createWholeMysqlBackup(Backup backupInfo);
    Result rollbackWithWholeBackUp(Backup backupInfo);
    Result deleteBackup(Backup backupInfo);
    IPage pageLJoinUser(Page page, String date);
}
