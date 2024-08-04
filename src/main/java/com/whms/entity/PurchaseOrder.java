package com.whms.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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
@ApiModel(value="PurchaseOrder对象", description="")
public class PurchaseOrder implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "poid", type = IdType.AUTO)
    @ApiModelProperty(value = "入库记录id")
    private Integer poid;

    @ApiModelProperty(value = "操作员id")
    private Integer id;

    @ApiModelProperty(value = "供应商id")
    private Integer sid;

    @ApiModelProperty(value = "入库仓库id")
    private Integer wid;

    @ApiModelProperty(value = "入库操作的时间")
    private LocalDateTime potime;

    @ApiModelProperty(value = "入库订货的总成本")
    private BigDecimal pototalCost;


}
