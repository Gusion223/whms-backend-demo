package com.whms.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
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
 * @since 2024-06-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="SaleOrder对象", description="")
public class SaleOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "销售记录id")
    @TableId(value = "soid", type = IdType.AUTO)
    private Integer soid;

    @ApiModelProperty(value = "顾客id")
    private Integer cid;

    @ApiModelProperty(value = "仓库id")
    private Integer wid;

    @ApiModelProperty(value = "业务员id")
    private Integer id;

    @ApiModelProperty(value = "销售时间")
    private LocalDateTime sotime;

    @ApiModelProperty(value = "销售总金额")
    private BigDecimal sototal;


}
