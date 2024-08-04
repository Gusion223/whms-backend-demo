package com.whms.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
 * @since 2024-06-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="PurchaseDetail对象", description="")
public class PurchaseDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @MppMultiId
    @ApiModelProperty(value = "订货订单id")
    private Integer poid;

    @MppMultiId
    @ApiModelProperty(value = "商品id")
    private Integer gid;

    @ApiModelProperty(value = "商品数量")
    private Integer pdamount;

    @ApiModelProperty(value = "进货开销")
    private BigDecimal pdtotalCost;


}
