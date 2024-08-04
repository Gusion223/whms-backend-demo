package com.whms.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="SGGoodVO对象", description="")
public class SGGoodVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "供应商id")
    private Integer sid;

    @ApiModelProperty(value = "供应商品的id")
    private Integer gid;

    @ApiModelProperty(value = "商品购入单价")
    private BigDecimal gunitCost;

    @ApiModelProperty(value = "商品名称")
    private String gname;

    @ApiModelProperty(value = "商品类型")
    private String gtype;

    @ApiModelProperty(value = "商品零售价格")
    private BigDecimal gunitPrice;

    @ApiModelProperty(value = "商品单位")
    private String gunit;
}
