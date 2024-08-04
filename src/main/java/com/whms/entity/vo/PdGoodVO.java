package com.whms.entity.vo;

import com.github.jeffreyning.mybatisplus.anno.MppMultiId;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class PdGoodVO implements Serializable {
    @ApiModelProperty(value = "订货订单id")
    private Integer poid;

    @ApiModelProperty(value = "商品id")
    private Integer gid;

    private String gname;

    @ApiModelProperty(value = "商品数量")
    private Integer pdamount;

    @ApiModelProperty(value = "进货开销")
    private BigDecimal pdtotalCost;
}
