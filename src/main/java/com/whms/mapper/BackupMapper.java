package com.whms.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.whms.entity.Backup;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.whms.entity.vo.BackupUserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author whms
 * @since 2024-06-15
 */
@Mapper
public interface BackupMapper extends BaseMapper<Backup> {

    IPage<BackupUserVO> pageLJoinUser(IPage<BackupUserVO> page, @Param("date") String date);

}
