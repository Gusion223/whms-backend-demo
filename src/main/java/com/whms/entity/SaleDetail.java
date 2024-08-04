package com.whms.entity;

import java.math.BigDecimal;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2024-06-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="SaleDetail对象", description="")
public class SaleDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @MppMultiId
    @ApiModelProperty(value = "销售记录id")
    private Integer soid;

    @MppMultiId
    @ApiModelProperty(value = "销售商品id")
    private Integer gid;

    @ApiModelProperty(value = "销售商品数量")
    private Integer sdamount;

    @TableField(value = "sdtotal")
    @ApiModelProperty(value = "销售总数")
    private BigDecimal sdtotal;


}
