package com.whms.entity;

import java.math.BigDecimal;
import java.io.Serializable;

import com.github.jeffreyning.mybatisplus.anno.MppMultiId;
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
 * @since 2024-06-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="SG对象", description="")
public class SG implements Serializable {

    private static final long serialVersionUID = 1L;

    @MppMultiId
    @ApiModelProperty(value = "供应商id")
    private Integer sid;

    @MppMultiId
    @ApiModelProperty(value = "供应商品的id")
    private Integer gid;

    @ApiModelProperty(value = "商品购入单价")
    private BigDecimal gunitCost;


}
