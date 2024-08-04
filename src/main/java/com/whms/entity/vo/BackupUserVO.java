package com.whms.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class BackupUserVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "数据库备份id")
    @TableId(value = "bid", type = IdType.AUTO)
    private Integer bid;

    @ApiModelProperty(value = "创建的用户id")
    private Integer id;

    @ApiModelProperty(value = "是否由系统自动创建")
    private String autoCreate;

    @ApiModelProperty(value = "备份时间")
    private LocalDateTime btime;

    @ApiModelProperty(value = "备份描述")
    private String bdesc;

    @ApiModelProperty(value = "备份文件的路径")
    private String bfilepath;

    @ApiModelProperty(value = "备份类型, 0为完全备份")
    private Integer btype;

    @ApiModelProperty(value = "账号")
    private String userName;
}
