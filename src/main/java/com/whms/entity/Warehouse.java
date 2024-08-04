package com.whms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value="Warehouse对象", description="")
public class Warehouse implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "仓库id	")
    @TableId(value = "wid", type = IdType.AUTO)
    private Integer wid;

    @ApiModelProperty(value = "仓库名称")
    private String wname;

    @ApiModelProperty(value = "仓库地址")
    private String waddr;


}
