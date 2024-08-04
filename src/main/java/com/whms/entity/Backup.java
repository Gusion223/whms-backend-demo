package com.whms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author whms
 * @since 2024-06-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Backup对象", description="")
public class Backup implements Serializable {

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
}
